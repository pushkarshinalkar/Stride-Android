package com.tutorial.courser.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.courser.R
import com.tutorial.courser.databinding.ActivityRecomendedCoursesBinding
import com.tutorial.courser.databinding.FragmentCoursesBinding
import com.tutorial.courser.databinding.FragmentFavBinding
import com.tutorial.courser.model.videos.VideosItem
import com.tutorial.courser.ui.adapters.CoursesListAdapter
import com.tutorial.courser.ui.adapters.VideoListAdapter
import com.tutorial.courser.viewmodel.CoursesViewModel

class FavFrag : Fragment() {

    private lateinit var binding: FragmentFavBinding
    private lateinit var rc_viewModel: CoursesViewModel
    private lateinit var mCoursesListAdapter: CoursesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            rc_viewModel = ViewModelProvider(this@FavFrag)[CoursesViewModel::class.java]

            val layoutManager = LinearLayoutManager(view.context)
            favVidsRvId.layoutManager = layoutManager
            mCoursesListAdapter = CoursesListAdapter()
            favVidsRvId.adapter = mCoursesListAdapter

            rc_viewModel.coursesLiveData.observe(viewLifecycleOwner) {
                mCoursesListAdapter.setData(it)
            }
        }
        rc_viewModel.fetchCourses()


    }

}