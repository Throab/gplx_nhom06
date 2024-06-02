package com.example.gplx_nhom6.app.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.app.model.Question
import com.example.gplx_nhom6.app.view.adapter.ViewPagerAdapter
import com.example.gplx_nhom6.app.viewmodel.DataViewModel
import com.example.gplx_nhom6.databinding.ActivityLessonViewPagerBinding

class LessonViewPagerActivity : AppCompatActivity() {
    private var learning_title:String ?= null
    private lateinit var binding:ActivityLessonViewPagerBinding
    private lateinit var viewPager : ViewPager2
    private lateinit var back : ImageView
    private lateinit var forward : ImageView
    private lateinit var current : TextView
    private lateinit var total : TextView
    private var questionList = mutableListOf<Question>()
    private lateinit var aAdapter : ViewPagerAdapter

//    private var title = intent.getStringExtra("learning_title")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolBar()
        initListener()
        initUi()
        viewPager.adapter = ViewPagerAdapter(this,questionList)
        Log.d("LIET","LIET")
        initViewModel()
        current.text = (viewPager.currentItem + 1).toString()

    }
    fun test(){
        var item = Question(1,"Cau hoi",0)
        questionList.add(item)
        item = Question(1,"Cau hoi",0)
        questionList.add(item)
        viewPager.adapter?.notifyDataSetChanged()
    }
    private fun setupToolBar(){
        learning_title =intent.getStringExtra("learning_title")
        binding.customToolbar.toolbarTitle.text = learning_title
        binding.customToolbar.toolbarLeftIcon.setImageResource(R.drawable.baseline_arrow_back_24)
        binding.customToolbar.toolbarRightIcon.visibility = View.INVISIBLE
    }

    private fun initListener(){
        binding.customToolbar.toolbarLeftIcon.setOnClickListener{
            super.onBackPressed()
        }
        binding.btnBackQuestion.setOnClickListener{
                viewPager.setCurrentItem(viewPager.currentItem -1 , true)
        }
        binding.btnForwardQuestion.setOnClickListener{
            viewPager.setCurrentItem(viewPager.currentItem + 1 , true)
        }
    }



    private fun initUi(){
        viewPager = findViewById<ViewPager2>(R.id.viewPager)
        back = findViewById(R.id.btnBackQuestion)
        forward = findViewById(R.id.btnForwardQuestion)
        current = findViewById(R.id.text_current_question)
        total = findViewById(R.id.text_total_question)
        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                current.text = (position + 1).toString()
                if(position == 0){
                    back.visibility = View.INVISIBLE
                    forward.visibility = View.VISIBLE
                }else if(position == questionList.size - 1){
                    forward.visibility = View.INVISIBLE
                    back.visibility = View.VISIBLE
                }else{
                    forward.visibility = View.VISIBLE
                    back.visibility = View.VISIBLE
                }
            }
        })
    }
    private fun initViewModel(){
        val viewModel : DataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        viewModel.getQuestionLiveDataObserver().observe(this, Observer{
            if(it != null) {
                var pos = intent.getStringExtra("position")
                        for(i :Question in it){
                            if(pos?.toInt() == 0){
                                if(i.isImportant == 1){
                                    questionList.add(i)
                                }
                            }else{
                                if(i.type == pos?.toInt()){
                                    questionList.add(i)
                                }
                            }
                            Log.d("TRUE", (pos?.toInt() == 0).toString())

                        }
                total.text = questionList.size.toString()
                back.visibility = View.VISIBLE
                back.setImageResource(R.drawable.baseline_arrow_back_ios_24)
                viewPager.adapter?.notifyDataSetChanged()

            }
        })
        viewModel.makeApiCallQuestion()
    }
}