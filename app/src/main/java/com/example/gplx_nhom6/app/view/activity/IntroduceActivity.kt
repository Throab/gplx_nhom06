package com.example.gplx_nhom6.app.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet.GONE
import androidx.databinding.DataBindingUtil
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.databinding.ActivityIntroduceBinding

class IntroduceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroduceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduce)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_introduce)
        setupToolBar()
        initListener()
    }
    private fun setupToolBar(){
        binding.customToolbar.toolbarTitle.text = "Giới thiệu"
        binding.customToolbar.toolbarLeftIcon.setImageResource(R.drawable.baseline_arrow_back_24)
        binding.customToolbar.toolbarRightIcon.visibility = View.INVISIBLE
    }
    private fun initListener(){
        binding.customToolbar.toolbarLeftIcon.setOnClickListener{
            super.onBackPressed()
        }

    }
}