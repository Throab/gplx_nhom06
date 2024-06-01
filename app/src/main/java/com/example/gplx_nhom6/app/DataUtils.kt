package com.example.gplx_nhom6.app

import android.content.Context
import com.example.gplx_nhom6.app.model.Question
import com.example.gplx_nhom6.app.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Response
var listQuestionImportant = mutableListOf<MutableList<Question>>()
var listAllQuestion : MutableList<Question> = mutableListOf<Question>()
fun initImportant(context: Context){
    RetrofitClient.getRetrofitClient().getQuestions().enqueue(object: retrofit2.Callback<List<Question>>{
        override fun onResponse(call: Call<List<Question>>, response: Response<List<Question>>) {
            listAllQuestion = response.body() as MutableList<Question>
        }

        override fun onFailure(call: Call<List<Question>>, t: Throwable) {
            TODO("Not yet implemented")
        }

    })


}