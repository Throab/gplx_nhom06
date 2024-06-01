package com.example.gplx_nhom6.app.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.app.view.adapter.LearningAdapter
import com.example.gplx_nhom6.app.model.ItemLearning
import com.example.gplx_nhom6.databinding.ActivityLearnTheoryBinding

class LearnTheoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLearnTheoryBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var learningAdapter: LearningAdapter
    private var learningList = mutableListOf<ItemLearning>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_theory)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_theory)
        setupToolBar()
        initListener()
        learningList = ArrayList()
        recyclerView = findViewById<View>(R.id.rcv_learning) as RecyclerView
        learningAdapter = LearningAdapter(this, learningList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = learningAdapter
        preparelist()
    }
    private fun setupToolBar(){
        binding.customToolbar.toolbarTitle.text = "Học lý thuyết"
        binding.customToolbar.toolbarLeftIcon.setImageResource(R.drawable.baseline_arrow_back_24)
        binding.customToolbar.toolbarRightIcon.visibility = View.INVISIBLE
    }

    private fun initListener(){
        binding.customToolbar.toolbarLeftIcon.setOnClickListener {
            super.onBackPressed()
        }
    }
    private fun preparelist(){
        var item = ItemLearning("Câu hỏi điểm liệt", "Câu hỏi điểm liệt", R.drawable.warning)
        learningList.add(item)
        item = ItemLearning("Khái niệm và quy tắc", "Câu hỏi về khái niệm và quy tắc", R.drawable.writing)
        learningList.add(item)
        item = ItemLearning("Văn hóa và đạo đức lái xe", "Câu hỏi ....", R.drawable.cultures)
        learningList.add(item)
        item = ItemLearning("Kỹ thuật lái xe", "Câu hỏi điểm liệt", R.drawable.driving)
        learningList.add(item)
        item = ItemLearning("Biển báo đường bộ", "Câu hỏi điểm liệt", R.drawable.forbidden)
        learningList.add(item)
        item = ItemLearning("Sa hình", "Câu hỏi điểm liệt", R.drawable.conversation)
        learningList.add(item)

        learningAdapter.notifyDataSetChanged()
    }
}