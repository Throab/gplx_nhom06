package com.example.gplx_nhom6.app.view.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.app.model.Answer
import com.example.gplx_nhom6.app.view.adapter.AnswerAdapter
import com.example.gplx_nhom6.app.viewmodel.DataViewModel
import com.example.gplx_nhom6.databinding.ActivityShowQuestionBinding

class ShowQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowQuestionBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var aAdapter : AnswerAdapter
    private var answerList = mutableListOf<Answer>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_question)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_question)
        binding.textQuestionContent.text = intent.getStringExtra("question_content")
        setupToolBar()
        initListener()
        val string = intent.getStringExtra("question_content")
        val isd = intent.getStringExtra("question_id")
        answerList = ArrayList()
        recyclerView = findViewById<View>(R.id.rcv_answers) as RecyclerView
        aAdapter = AnswerAdapter(this, answerList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = aAdapter
        initViewModel()
    }
    fun setupToolBar(){
        binding.customToolbar.toolbarTitle.text = ""
        binding.customToolbar.toolbarLeftIcon.setImageResource(R.drawable.baseline_arrow_back_24)
        binding.customToolbar.toolbarRightIcon.visibility = View.GONE
    }
    fun initListener(){
        binding.customToolbar.toolbarLeftIcon.setOnClickListener{
            super.onBackPressed()
        }
        binding.showEx.setOnClickListener{
            binding.layoutEx.visibility = View.VISIBLE
            binding.layoutExplainAnswer.visibility = View.VISIBLE
            binding.showEx.visibility = View.GONE
        }
    }
    private fun initViewModel(){
        val viewModel : DataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        viewModel.getAnswerLiveDataObserver().observe(this, Observer{
            if(it != null){
                Log.d("COUNT", it.size.toString())
                for(i : Answer in it){
                    if(i.questionId == intent.getStringExtra("question_id")?.toInt() ?: null){
                        answerList.add(i)
                        if(i.isCorrect == 1){
                            binding.textExplainAnswer.text = i.answerExplain
                            binding.textExplainAnswer.setTextColor(Color.parseColor("#FFFFFF"))
                        }
                    }
                }
                aAdapter.notifyDataSetChanged()
            }
        })
        viewModel.makeApiCallAnswer()

    }

}