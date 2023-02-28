package com.tutorial.courser.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.tutorial.courser.databinding.ActivityCourseDetailsBinding
import com.tutorial.courser.ui.adapters.VideoListAdapter
import com.tutorial.courser.viewmodel.CoursesViewModel
import com.tutorial.courser.viewmodel.VideosViewModel

class CourseDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseDetailsBinding
    private lateinit var c_viewModel: CoursesViewModel
    private lateinit var v_viewModel: VideosViewModel

    private lateinit var mVideoListAdapter: VideoListAdapter
    private var courseno : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCourseDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = getIntent().extras
        if (extras != null) {
            courseno = extras.getInt("courseno_passed", 0)
            //The key argument here must match that used in the other activity
        }

        binding.apply {

            backImgId.setOnClickListener{
                val intent1 = Intent(this@CourseDetailsActivity, MainActivity::class.java)
                startActivity(intent1)
            }
            c_viewModel = ViewModelProvider(this@CourseDetailsActivity)[CoursesViewModel::class.java]
            v_viewModel = ViewModelProvider(this@CourseDetailsActivity)[VideosViewModel::class.java]

            val layoutManager = LinearLayoutManager(this@CourseDetailsActivity)
            videoListRvId.layoutManager = layoutManager
            mVideoListAdapter = VideoListAdapter()
            videoListRvId.adapter = mVideoListAdapter

            c_viewModel.coursesLiveData.observe(this@CourseDetailsActivity) {

                Glide.with(this@CourseDetailsActivity).load(it[courseno].c_big_image_link).into(courseDetailsImgId)

                noOfVidsId.setText(it[courseno].c_num_videos.toString())
                courseDetailsWtId.setText((it[courseno].c_total_time.toString()).substring(0,(it[courseno].c_total_time.toString()).indexOf(" ")))
                courseDetailsAboutId.setText(it[courseno].c_about)
                courseDetailsPointsId.setText(it[courseno].c_points.toString())
                courseDetailsNameId.setText(it[courseno].c_name)
            }

            v_viewModel.videosLiveData.observe(this@CourseDetailsActivity){
                mVideoListAdapter.setData(it)
            }
        }
        c_viewModel.fetchCourses()
        v_viewModel.fetchVideos()







    }

}