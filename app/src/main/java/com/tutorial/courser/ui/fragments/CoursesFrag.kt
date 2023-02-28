package com.tutorial.courser.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.tutorial.courser.databinding.FragmentCoursesBinding
import com.tutorial.courser.ui.activities.CourseDetailsActivity
import com.tutorial.courser.ui.activities.RecomCoursesActivity
import com.tutorial.courser.viewmodel.CoursesViewModel


class CoursesFrag : Fragment() {

    private lateinit var binding: FragmentCoursesBinding
    private lateinit var c_viewModel: CoursesViewModel

    private var course_id1: Int = 0
    private var course_id2: Int = 0
    private var course_id3: Int = 0
    private var course_id4: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)

            c_viewModel = ViewModelProvider(this@CoursesFrag)[CoursesViewModel::class.java]
            c_viewModel.coursesLiveData.observe(viewLifecycleOwner) { courses ->

                Glide.with(this@CoursesFrag).load(courses[0].c_small_image_link).apply(requestOptions).into(course1SmallimgId)
                Glide.with(this@CoursesFrag).load(courses[1].c_small_image_link).apply(requestOptions).into(course2SmallimgId)
                Glide.with(this@CoursesFrag).load(courses[2].c_small_image_link).apply(requestOptions).into(course3SmallimgId)
                Glide.with(this@CoursesFrag).load(courses[3].c_small_image_link).apply(requestOptions).into(course4SmallimgId)

                recoCard1.setOnClickListener {
                    val r_intent1 = Intent(view.context, CourseDetailsActivity::class.java)
                    r_intent1.putExtra("courseid_passed", courses[0].c_id)
                    startActivity(r_intent1)
                    activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }
                recoCard2.setOnClickListener {
                    val r_intent2 = Intent(view.context, CourseDetailsActivity::class.java)
                    r_intent2.putExtra("courseid_passed", courses[1].c_id)
                    startActivity(r_intent2)
                    activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }
                recoCard3.setOnClickListener {
                    val r_intent3 = Intent(view.context, CourseDetailsActivity::class.java)
                    r_intent3.putExtra("courseid_passed", courses[2].c_id)
                    startActivity(r_intent3)
                    activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }
                recoCard4.setOnClickListener {
                    val r_intent4 = Intent(view.context, CourseDetailsActivity::class.java)
                    r_intent4.putExtra("courseid_passed", courses[3].c_id)
                    startActivity(r_intent4)
                    activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }
            }
            c_viewModel.fetchCourses()

            c_viewModel.featuredLiveData.observe(viewLifecycleOwner) { featured ->

                Glide.with(this@CoursesFrag).load(featured[0].c_mid_image_link).apply(requestOptions).into(course1ImageId)
                Glide.with(this@CoursesFrag).load(featured[1].c_mid_image_link).apply(requestOptions).into(course2ImageId)
                Glide.with(this@CoursesFrag).load(featured[2].c_mid_image_link).apply(requestOptions).into(course3ImageId)
                Glide.with(this@CoursesFrag).load(featured[3].c_mid_image_link).apply(requestOptions).into(course4ImageId)


                course1NametxtId.setText(featured[0].c_name)
                course2NametxtId.setText(featured[1].c_name)
                course3NametxtId.setText(featured[2].c_name)
                course4NametxtId.setText(featured[3].c_name)

                course1VidnoId.setText(featured[0].c_num_videos.toString() + " Videos")
                course2VidnoId.setText(featured[1].c_num_videos.toString() + " Videos")
                course3VidnoId.setText(featured[2].c_num_videos.toString() + " Videos")
                course4VidnoId.setText(featured[3].c_num_videos.toString() + " Videos")

                course1WtId.setText(featured[0].c_total_time)
                course2WtId.setText(featured[1].c_total_time)
                course3WtId.setText(featured[2].c_total_time)
                course4WtId.setText(featured[3].c_total_time)
                lottieLoadingView.visibility = View.GONE

                course1CardId.setOnClickListener {
                    val intent1 = Intent(view.context, CourseDetailsActivity::class.java)
                    intent1.putExtra("courseid_passed", featured[0].c_id)
                    startActivity(intent1)
                    activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }

                course2CardId.setOnClickListener {
                    val intent2 = Intent(view.context, CourseDetailsActivity::class.java)
                    intent2.putExtra("courseid_passed", featured[1].c_id)
                    startActivity(intent2)
                    activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }

                course3CardId.setOnClickListener {
                    val intent3 = Intent(view.context, CourseDetailsActivity::class.java)
                    intent3.putExtra("courseid_passed", featured[2].c_id)
                    startActivity(intent3)
                    activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }

                course4CardId.setOnClickListener {
                    val intent4 = Intent(view.context, CourseDetailsActivity::class.java)
                    intent4.putExtra("courseid_passed", featured[3].c_id)
                    startActivity(intent4)
                    activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                }
            }
            c_viewModel.fetchFeaturedCourses()




            seeallRecomText.setOnClickListener {
                val intent5 = Intent(view.context, RecomCoursesActivity::class.java)
                startActivity(intent5)
            }

            if(searchEnterText.text!=null){
                searchCard.setOnClickListener {
                    val s_intent = Intent(view.context, RecomCoursesActivity::class.java)
                    s_intent.putExtra("courses_name", searchEnterText.text.toString())
                    Toast.makeText(view.context, searchEnterText.text, Toast.LENGTH_SHORT).show()
                    startActivity(s_intent)
                    activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

                }
            }

            searchEnterText.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    val s_intent = Intent(view.context, RecomCoursesActivity::class.java)
                    s_intent.putExtra("courses_name", searchEnterText.text.toString())
                    Toast.makeText(view.context, searchEnterText.text, Toast.LENGTH_SHORT).show()
                    startActivity(s_intent)
                    activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    true
                } else false
            })


        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCoursesBinding.inflate(layoutInflater)
        return binding.root


    }
}