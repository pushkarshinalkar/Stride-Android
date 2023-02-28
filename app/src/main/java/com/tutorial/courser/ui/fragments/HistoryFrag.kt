package com.tutorial.courser.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.courser.R
import com.tutorial.courser.model.videos.VideosItem
import com.tutorial.courser.ui.adapters.VideoListAdapter


class HistoryFrag : Fragment() {

    private lateinit var mVideoListAdapter: VideoListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rc: RecyclerView = view.findViewById(R.id.rc_vids_hist)
        val layoutManager = LinearLayoutManager(view.context)
        rc.layoutManager = layoutManager
        mVideoListAdapter = VideoListAdapter()
        rc.adapter = mVideoListAdapter

        val vidslist: List<VideosItem> = listOf(
            VideosItem(
                v_course_id = 1,
                v_id = 2,
                v_link = "https://example.com/video2.mp4",
                v_name = "Building UI with XML Layouts",
                v_small_image_link = "https://firebasestorage.googleapis.com/v0/b/stride-database.appspot.com/o/1_small_course_img.png?alt=media&token=1fbac543-e145-4079-9eeb-dc0264014b2b",
                v_time = "00:18:45",
                v_transcript = "Lorem ipsum dolor sit amet, consectetur adipiscing elit..."
            ),
            VideosItem(
                1,
                101,
                "https://example.com/videos/101.mp4",
                "Introduction to Java",
                "https://firebasestorage.googleapis.com/v0/b/stride-database.appspot.com/o/1_small_course_img.png?alt=media&token=1fbac543-e145-4079-9eeb-dc0264014b2b",
                "12:30",
                "This is the transcript for the introduction video."
            ),
            VideosItem(
                1,
                102,
                "https://example.com/videos/102.mp4",
                "Java Data Types",
                "https://firebasestorage.googleapis.com/v0/b/stride-database.appspot.com/o/1_small_course_img.png?alt=media&token=1fbac543-e145-4079-9eeb-dc0264014b2b",
                "15:45",
                "This is the transcript for the data types video."
            ),
            VideosItem(
                1,
                103,
                "https://example.com/videos/103.mp4",
                "Java Control Flow",
                "https://firebasestorage.googleapis.com/v0/b/stride-database.appspot.com/o/1_small_course_img.png?alt=media&token=1fbac543-e145-4079-9eeb-dc0264014b2b",
                "20:12",
                "This is the transcript for the control flow video."
            ),
            VideosItem(
                1,
                104,
                "https://firebasestorage.googleapis.com/v0/b/stride-database.appspot.com/o/1_small_course_img.png?alt=media&token=1fbac543-e145-4079-9eeb-dc0264014b2b",
                "Java Functions",
                "https://firebasestorage.googleapis.com/v0/b/stride-database.appspot.com/o/1_small_course_img.png?alt=media&token=1fbac543-e145-4079-9eeb-dc0264014b2b",
                "18:05",
                "This is the transcript for the functions video."
            ),
            VideosItem(
                1,
                105,
                "https://example.com/videos/105.mp4",
                "Java Classes and Objects",
                "https://firebasestorage.googleapis.com/v0/b/stride-database.appspot.com/o/1_small_course_img.png?alt=media&token=1fbac543-e145-4079-9eeb-dc0264014b2b",
                "23:09",
                "This is the transcript for the classes and objects video."
            )
            // Add more VideosItem objects as needed
        )


        mVideoListAdapter.setData(vidslist)
    }
}