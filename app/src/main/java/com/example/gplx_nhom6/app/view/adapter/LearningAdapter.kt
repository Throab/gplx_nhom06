package com.example.gplx_nhom6.app.view.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.app.view.activity.LearnTheoryActivity
import com.example.gplx_nhom6.app.view.activity.LessonViewPagerActivity
import com.example.gplx_nhom6.app.model.ItemLearning

class LearningAdapter constructor(private val getActivity: LearnTheoryActivity, private val learningList: List<ItemLearning> ):
    RecyclerView.Adapter<LearningAdapter.MyViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_learning, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return learningList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = learningList[position].title
        holder.des.text = learningList[position].description
        holder.thumb.setImageResource(learningList[position].thumb)
        holder.itemView.setOnClickListener{
            Log.d("CLICK", learningList[position].title)
            val intent = Intent(getActivity, LessonViewPagerActivity::class.java).apply {
                putExtra("learning_title", learningList[position].title)
                putExtra("position", position.toString())
            }
            Log.d("TRUE",learningList[position].title.equals("Câu hỏi điểm liệt").toString())
            getActivity.startActivity(intent)
        }
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.text_name_item_learning)
        val des : TextView = itemView.findViewById(R.id.text_count_question)
        val thumb : ImageView = itemView.findViewById(R.id.image_item_learning)

    }
}