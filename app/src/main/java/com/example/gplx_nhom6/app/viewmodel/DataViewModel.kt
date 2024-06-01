package com.example.gplx_nhom6.app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gplx_nhom6.app.model.Answer
import com.example.gplx_nhom6.app.model.Question
import com.example.gplx_nhom6.app.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class DataViewModel: ViewModel() {
    lateinit var questionLiveData : MutableLiveData<List<Question>>
    lateinit var answerLiveData : MutableLiveData<List<Answer>>
    init{
        questionLiveData = MutableLiveData()
        answerLiveData = MutableLiveData()
    }
    fun getQuestionLiveDataObserver(): MutableLiveData<List<Question>>{
        return questionLiveData
    }

    fun getAnswerLiveDataObserver(): MutableLiveData<List<Answer>>{

        return answerLiveData
    }

    fun makeApiCallQuestion(){
        RetrofitClient.getRetrofitClient().getQuestions().enqueue(object : retrofit2.Callback<List<Question>>{
            override fun onResponse(
                call: Call<List<Question>>,
                response: Response<List<Question>>
            ) {
                questionLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Question>>, t: Throwable) {
                Log.d("FAILLIVE","question")
            }

        })
    }
    fun makeApiCallAnswer(){
        RetrofitClient.getRetrofitClient().getAnswers().enqueue(object : retrofit2.Callback<List<Answer>>{
            override fun onResponse(
                call: Call<List<Answer>>,
                response: Response<List<Answer>>
            ) {
                answerLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Answer>>, t: Throwable) {
                Log.d("FAILLIVE","question")
            }

        })
    }
}