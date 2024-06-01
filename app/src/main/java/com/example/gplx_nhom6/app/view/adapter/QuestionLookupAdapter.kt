package com.example.gplx_nhom6.app.view.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.app.model.Question
import com.example.gplx_nhom6.app.view.activity.LearnTheoryActivity
import com.example.gplx_nhom6.app.view.activity.LookUpActivity
import com.example.gplx_nhom6.app.view.activity.ShowQuestionActivity

class QuestionLookupAdapter constructor(private val getActivity : LookUpActivity, private var questionList: List<Question>):
    RecyclerView.Adapter<QuestionLookupAdapter.MyViewHolder>()
{
    fun setFilterList(mList: List<Question>){
        this.questionList = mList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.question_lookup_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.content.text = questionList[position].content
        if(questionList[position].isImportant == 1){
            holder.isImportant.setImageResource(R.drawable.alert_warning)
            holder.isImportant.visibility = View.VISIBLE
        }
//        if(getActivity.){
//            holder.image.visibility = View.VISIBLE
//            holder.image.setImageResource(R.drawable.b_r301b)
//        }

        holder.itemView.setOnClickListener{
            Log.d("CLICK3",questionList[position].questionId.toString())
            val intent = Intent(getActivity, ShowQuestionActivity::class.java).apply{
                putExtra("question_content", questionList[position].content)
                putExtra("question_id", questionList[position].questionId.toString())
            }
            getActivity.startActivity(intent)
        }
    }
    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val content : TextView = itemView.findViewById(R.id.content_item_question)
        val image : ImageView = itemView.findViewById(R.id.image_item_question)
        val isImportant : ImageView = itemView.findViewById(R.id.is_important_item_question)

    }
}