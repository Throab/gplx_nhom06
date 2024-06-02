package com.example.gplx_nhom6.app.view.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.app.model.Answer
import com.example.gplx_nhom6.app.view.QuestionFragment
import com.example.gplx_nhom6.app.view.activity.ShowQuestionActivity
import kotlinx.android.synthetic.main.item_answer.view.*

class AnswerAdapter(private val context: Context, private var answerList: List<Answer> ):
    RecyclerView.Adapter<AnswerAdapter.MyViewHolder>()
{

    private var onItemClick: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClick = listener
    }
    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val count : TextView = itemView.findViewById(R.id.text_answer_count)
        val content : TextView = itemView.findViewById(R.id.text_answer_content)
        val status : ImageView = itemView.findViewById(R.id.image_status)
//        init{
//            itemView.rowItem.setOnClickListener{
//                setSingleSelection(adapterPosition)
//            }
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_answer, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return answerList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.content.text = answerList[position].answerContent
        holder.count.text = (position + 1).toString()


        holder.itemView.setOnClickListener {

                if (answerList[position].isCorrect == 1) {
                    holder.content.setTextColor(Color.parseColor("#307A42"))
                    holder.count.setBackgroundResource(R.drawable.bg_round_count_green)
                    holder.count.setTextColor(Color.parseColor("#FFFFFF"))
                    holder.status.visibility = View.VISIBLE
                    holder.status.setImageResource(R.drawable.icon_check)
                } else {
                    holder.content.setTextColor(Color.parseColor("#E00707"))
                    holder.count.setBackgroundResource(R.drawable.bg_round_count_red)
                    holder.count.setTextColor(Color.parseColor("#FFFFFF"))
                    holder.status.visibility = View.VISIBLE
                    holder.status.setImageResource(R.drawable.icon_close)
            }

        }

    }

}