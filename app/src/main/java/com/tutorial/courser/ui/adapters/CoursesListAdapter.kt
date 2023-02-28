package com.tutorial.courser.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tutorial.courser.R
import com.tutorial.courser.model.courses.CoursesItem
import com.tutorial.courser.ui.activities.CourseDetailsActivity

class CoursesListAdapter : RecyclerView.Adapter<C_MyViewHolder>() {

    private var data: List<CoursesItem> = emptyList()

    fun setData(data: List<CoursesItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): C_MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item_courses_list, parent, false)
        return C_MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: C_MyViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class C_MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val course_title_textview: TextView = itemView.findViewById(R.id.course_title_text_id)
    private val course_novids_textview: TextView = itemView.findViewById(R.id.textView16)
    private val course_small_image: ImageView = itemView.findViewById(R.id.course_smallimg_id)
    private val maincard: CardView = itemView.findViewById(R.id.course_item_card_id)

    fun bind(item: CoursesItem) {

        val co_title = item.c_name // replace myString with the actual variable name in MyData
        val co_numvid = item.c_num_videos // replace myString with the actual variable name in MyData

        course_title_textview.text = co_title
        course_novids_textview.text = (co_numvid.toString() + " Videos")
        Glide.with(itemView.context).load(item.c_small_image_link).into(course_small_image)
        maincard.setOnClickListener{
            val intent1 = Intent(it.context, CourseDetailsActivity::class.java)
//            intent1.putExtra("vid_link_passed", item.v_link)
            it.context.startActivity(intent1)
        }
    }
}
