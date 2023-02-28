package com.tutorial.courser.ui.activities

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.tutorial.courser.R
import com.tutorial.courser.databinding.ActivityCourseDetailsBinding
import com.tutorial.courser.databinding.ActivityRecomendedCoursesBinding
import com.tutorial.courser.ui.adapters.CoursesListAdapter
import com.tutorial.courser.ui.adapters.VideoListAdapter
import com.tutorial.courser.viewmodel.CoursesViewModel
import com.tutorial.courser.viewmodel.VideosViewModel

class RecomCoursesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecomendedCoursesBinding
    private lateinit var rc_viewModel: CoursesViewModel
    private lateinit var mCoursesListAdapter: CoursesListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendedCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            rc_viewModel = ViewModelProvider(this@RecomCoursesActivity)[CoursesViewModel::class.java]

            val layoutManager = LinearLayoutManager(this@RecomCoursesActivity)
            recomRv.layoutManager = layoutManager
            mCoursesListAdapter = CoursesListAdapter()
            recomRv.adapter = mCoursesListAdapter

            rc_viewModel.coursesLiveData.observe(this@RecomCoursesActivity) {
                mCoursesListAdapter.setData(it)
            }
        }

        val message = intent.getStringExtra("courses_name")
        Toast.makeText(this@RecomCoursesActivity, "message " + message, Toast.LENGTH_SHORT).show()
        val queryParameters = HashMap<String, String>()

        if (message != null) {
            Toast.makeText(this@RecomCoursesActivity, "not null", Toast.LENGTH_SHORT).show()
            binding.changeTextviewText.setText("Search results for : "+ message)
            rc_viewModel.fetchSearchedCourses(message)

        } else {
            Toast.makeText(this@RecomCoursesActivity, "null", Toast.LENGTH_SHORT).show()
            rc_viewModel.fetchCourses()
        }


    }


}
