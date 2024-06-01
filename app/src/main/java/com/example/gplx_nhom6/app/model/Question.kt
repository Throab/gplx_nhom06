package com.example.gplx_nhom6.app.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    val questionId: Int,
    val content: String,
    val isImportant: Int, //câu điểm liệt (sai => trượt)
    var type: Int? = 0,
    val image: String?=null,
    var isChooseAnswer: Int?=0,


    ): Parcelable
