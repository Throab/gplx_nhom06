package com.example.gplx_nhom6.app.model

data class Answer(
    val answerId: Int,
    val answerContent: String,
    val isCorrect: Int,
    val questionId: Int,
    val answerExplain: String? = null,
    var flag: Int?=1,
    var isChoose: Int?=0
)