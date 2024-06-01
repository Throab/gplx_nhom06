package com.example.gplx_nhom6.app.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.databinding.ActivityShowEditBinding

class ShowEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_edit)
        binding = ActivityShowEditBinding.inflate(layoutInflater)
    }
}