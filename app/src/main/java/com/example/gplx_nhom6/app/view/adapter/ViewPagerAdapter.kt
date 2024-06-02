package com.example.gplx_nhom6.app.view.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gplx_nhom6.R
import com.example.gplx_nhom6.app.model.Answer
import com.example.gplx_nhom6.app.model.Question
import com.example.gplx_nhom6.app.view.activity.LessonViewPagerActivity
import com.example.gplx_nhom6.app.viewmodel.DataViewModel
import com.squareup.picasso.Picasso

class ViewPagerAdapter(private val getActivity: LessonViewPagerActivity, private var questionList : List<Question> ):
    RecyclerView.Adapter<ViewPagerAdapter.PageViewHolder>()
{
    class PageViewHolder (itemView :View): RecyclerView.ViewHolder(itemView){
        val content : TextView = itemView.findViewById(R.id.text_question_content)
        val image : ImageView = itemView.findViewById(R.id.image_question)
        val rcvAnswer :RecyclerView = itemView.findViewById(R.id.rcv_answers)
        val layoutEx : LinearLayout = itemView.findViewById(R.id.layout_ex)
        val layoutExa: ScrollView = itemView.findViewById(R.id.layout_explain_answer)
        val exAnswer : TextView = itemView.findViewById(R.id.text_explain_answer)
        val showEx : TextView = itemView.findViewById(R.id.showEx)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_question, parent, false)
        return PageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    var answerList = mutableListOf<Answer>()
    lateinit var aAdapter : AnswerAdapter
    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {

        holder.content.text = questionList[position].content

        if(questionList[position].image != "NULL"){
            holder.image.visibility = View.VISIBLE
            val url = "http://192.168.1.20/Nhom6_Api/image/" + questionList[position].image
            Picasso.get().load(url).into(holder.image)
            Log.d("NULLAAAA", questionList[position].image?.length.toString())
        }else{
            holder.image.visibility = View.GONE
        }
        holder.showEx.setOnClickListener{
            holder.layoutEx.visibility = View.VISIBLE
            holder.layoutExa.visibility = View.VISIBLE
            holder.showEx.visibility = View.GONE
        }

        aAdapter = AnswerAdapter(getActivity, answerList)
        holder.rcvAnswer.layoutManager = LinearLayoutManager(getActivity)
        holder.rcvAnswer.adapter = aAdapter
        val viewModel: DataViewModel = ViewModelProvider(getActivity).get(DataViewModel::class.java)
        viewModel.getAnswerLiveDataObserver().observe(getActivity, Observer {
            if (it != null) {
                answerList.clear()
                Log.d("COUNT", it.size.toString())
                for (i: Answer in it) {
                    if (i.questionId == questionList[position].questionId) {
                        answerList.add(i)
                        if(i.isCorrect == 1){
                            holder.exAnswer.text = i.answerExplain
                            holder.exAnswer.setTextColor(Color.parseColor("#FFFFFF"))
                        }

                    }
                }
                aAdapter.notifyDataSetChanged()
            }
        })
        viewModel.makeApiCallAnswer()

    }


}