package com.example.gplx_nhom6.app.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.app.model.Question
import com.example.gplx_nhom6.app.view.adapter.QuestionLookupAdapter
import com.example.gplx_nhom6.app.viewmodel.DataViewModel
import com.example.gplx_nhom6.databinding.ActivityLookUpBinding
import java.util.*
import kotlin.collections.ArrayList

class LookUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLookUpBinding
    private lateinit var recyclerView : RecyclerView
    private var listQuestion = mutableListOf<Question>()
    private lateinit var lAdapter : QuestionLookupAdapter
    private lateinit var searchView:SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLookUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchView = findViewById(R.id.search_text)
//        searchView.clearFocus()
        setupToolBar()
        initListener()
        listQuestion = ArrayList()
        recyclerView = findViewById<View>(R.id.lookUpRcv) as RecyclerView
        lAdapter = QuestionLookupAdapter(this, listQuestion)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = lAdapter
        initViewModel()
    }
    private fun getQuestionList(){
        var item = Question(1, "Khái niệm phương tiện cơ giới đường bộ được hiểu như thế nào là đúng?", 0)
        listQuestion.add(item)
        item = Question(2, "question 2", 1)
        listQuestion.add(item)
        item = Question(3, "question 3", 0)
        listQuestion.add(item)
        item = Question(4, "question 4", 0)
        listQuestion.add(item)
        lAdapter.notifyDataSetChanged()
    }


    private fun setupToolBar(){
        binding.customToolbar.toolbarTitle.text = "Tra cứu câu hỏi"
        binding.customToolbar.toolbarLeftIcon.setImageResource(R.drawable.baseline_arrow_back_24)
        binding.customToolbar.toolbarRightIcon.visibility = View.GONE
    }

    private fun initListener(){
        binding.customToolbar.toolbarLeftIcon.setOnClickListener{
            super.onBackPressed()
        }
    }

    private fun initViewModel(){
        val viewModel : DataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        viewModel.getQuestionLiveDataObserver().observe(this, Observer{
            if(it != null){
                listQuestion.addAll(it)
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        if (newText != null) {
                            filterList(newText)
                        }
                        return true
                    }

                })
                lAdapter.notifyDataSetChanged()


            }
        })
        viewModel.makeApiCallQuestion()
    }
    private fun filterList(query : String){
        if(query != null){
            val filterList = mutableListOf<Question>()
            for(i in listQuestion){
                if(i.content.lowercase(Locale.ROOT).contains(query.lowercase())){
                    filterList.add(i)
                }
            }

                lAdapter.setFilterList(filterList)
        }

    }
}