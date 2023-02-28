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
import com.tutorial.courser.model.videos.VideosItem
import com.tutorial.courser.ui.activities.VideoPlayerActivity

class VideoListAdapter : RecyclerView.Adapter<MyViewHolder>() {

    private var data: List<VideosItem> = emptyList()

    fun setData(data: List<VideosItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item_video_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val video_title_textview: TextView = itemView.findViewById(R.id.video_title_text_id)
    private val video_time_textview: TextView = itemView.findViewById(R.id.video_time_text_id)
    private val video_small_image: ImageView = itemView.findViewById(R.id.video_smallimg_id)
    private val maincard: CardView = itemView.findViewById(R.id.video_item_card_id)

    fun bind(item: VideosItem) {

        val vid_title = item.v_name // replace myString with the actual variable name in MyData
        val vid_time = item.v_time // replace myString with the actual variable name in MyData

        video_title_textview.text = vid_title
        video_time_textview.text = vid_time
        Glide.with(itemView.context).load(item.v_small_image_link).into(video_small_image)
        maincard.setOnClickListener{
            val intent1 = Intent(it.context, VideoPlayerActivity::class.java)
            intent1.putExtra("vid_link_passed", item.v_link)
            it.context.startActivity(intent1)
        }
    }
}
