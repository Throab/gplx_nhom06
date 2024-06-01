package com.example.gplx_nhom6.app.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.app.view.activity.LearnTheoryActivity
import com.example.gplx_nhom6.app.view.activity.MainActivity
import com.example.gplx_nhom6.app.model.ItemAction
import com.example.gplx_nhom6.app.view.activity.LookUpActivity

class ActionAdapter constructor(private val getActivity: MainActivity, private val actionList: List<ItemAction>):
    RecyclerView.Adapter<ActionAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_action_home, parent, false)
        return MyViewHolder(view)    }

    override fun getItemCount(): Int {
        return actionList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.acTitle.text = actionList[position].title
        holder.acImg.setImageResource(actionList[position].thumb)
        holder.acImg.setBackgroundResource(actionList[position].color)
        holder.linearItem.setOnClickListener{

            when(actionList[position].title){
                "Học lý thuyết"->{
                    val intent = Intent(getActivity, LearnTheoryActivity::class.java)
                    getActivity.startActivity(intent)
                }
                "Thi sát hạch" ->{
                    val intent = Intent(getActivity, LearnTheoryActivity::class.java)
                    getActivity.startActivity(intent)
                }
                "Tra cứu câu hỏi" ->{
                    val intent = Intent(getActivity, LookUpActivity::class.java)
                    getActivity.startActivity(intent)
                }
                "Sửa bộ đề" ->{
                    val intent = Intent(getActivity, LearnTheoryActivity::class.java)
                    getActivity.startActivity(intent)
                }
            }
        }

    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val acTitle : TextView = itemView.findViewById(R.id.actionTitle)
        val acImg : ImageView = itemView.findViewById(R.id.actionImg)
        val linearItem : LinearLayout = itemView.findViewById(R.id.linearItem)
    }


}