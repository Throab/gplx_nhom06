package com.example.gplx_nhom6.app.retrofit

import com.example.gplx_nhom6.app.model.Answer
import com.example.gplx_nhom6.app.model.Question
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("answers.php")
    fun getAnswers(): Call<List<Answer>>
    @GET("questions.php")
    fun getQuestions() : Call<List<Question>>


}