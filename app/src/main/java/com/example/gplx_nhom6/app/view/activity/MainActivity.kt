package com.example.gplx_nhom6.app.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.app.view.adapter.ActionAdapter
import com.example.gplx_nhom6.app.model.Answer
import com.example.gplx_nhom6.app.model.ItemAction
import com.example.gplx_nhom6.app.model.Question
import com.example.gplx_nhom6.app.retrofit.RetrofitClient
import com.example.gplx_nhom6.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var actionAdapter: ActionAdapter
    private lateinit var api : Call<List<Question>>
    private lateinit var res :Response<List<Question>>
    private var actionList = mutableListOf<ItemAction>()
    var list : MutableList<Question> ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupToolBar()
        initListener()
        actionList = ArrayList()
        recyclerView = findViewById<View>(R.id.recyclerAction) as RecyclerView
        actionAdapter = ActionAdapter(this, actionList)
        val layoutManager :RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = actionAdapter
        preparelist()
        getQuestions()
        getAnswers()




        }
    private fun setupToolBar(){
        binding.customToolbar.toolbarTitle.text = "Trang chủ"
        binding.customToolbar.toolbarLeftIcon.setImageResource(R.drawable.baseline_home_24)
        binding.customToolbar.toolbarRightIcon.setImageResource(R.drawable.baseline_info_24)

    }
    private fun initListener(){
        binding.customToolbar.toolbarRightIcon.setOnClickListener{
            val intent = Intent(this, IntroduceActivity::class.java)
            startActivity(intent)
        }
    }


    private fun preparelist(){
        var item = ItemAction("Thi sát hạch",R.drawable.exam, R.drawable.border_item_1)
        actionList.add(item)
        item = ItemAction("Học lý thuyết",R.drawable.book, R.drawable.border_item_2)
        actionList.add(item)
        item = ItemAction("Tra cứu câu hỏi",R.drawable.search, R.drawable.border_item_3)
        actionList.add(item)
        item = ItemAction("Chỉnh sửa",R.drawable.edit, R.drawable.border_item_4)
        actionList.add(item)
        actionAdapter.notifyDataSetChanged()
    }
    fun getAnswers(){
        RetrofitClient.getRetrofitClient()
            .getAnswers().enqueue(object: retrofit2.Callback<List<Answer>>{
            override fun onResponse(call: Call<List<Answer>>, response: Response<List<Answer>>) {
                val list : MutableList<Answer> = response.body() as MutableList<Answer>
                for(i : Answer in list){
                    Log.d("ANSWER", i.answerContent)
                }
            }

            override fun onFailure(call: Call<List<Answer>>, t: Throwable) {
                Log.d("fail", t.toString())
            }


        })
    }
    fun getQuestions(){
        RetrofitClient.getRetrofitClient()
            .getQuestions().enqueue(object: retrofit2.Callback<List<Question>>{
            override fun onResponse(
                call: Call<List<Question>>,
                response: Response<List<Question>>
            ) {
                list = response.body() as MutableList<Question>
                for(i in 0 until list?.size!!){
                    Log.d("LIST", list!![i]?.content.toString())
                }


            }

            override fun onFailure(call: Call<List<Question>>, t: Throwable) {
                Log.d("fail", t.toString())
            }

        })
    }
}
