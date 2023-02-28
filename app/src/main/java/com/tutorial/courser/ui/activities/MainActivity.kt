package com.tutorial.courser.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.tutorial.courser.R
import com.tutorial.courser.databinding.ActivityMainBinding
import com.tutorial.courser.databinding.FragmentCoursesBinding
import com.tutorial.courser.viewmodel.CoursesViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var c_viewModel: CoursesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {


            navigationView.setItemIconTintList(null);
            navigationView.setNavigationItemSelectedListener { menuItem ->
                val itemId = menuItem.itemId // get the ID of the selected menu item
                val itemResId = menuItem.actionView?.id ?: menuItem.itemId // get the resource ID of the menu item

                if (itemResId == R.id.settings_side) { // use itemResId instead of menuItem.itemId
                    val intent = Intent(this@MainActivity, SettingsActivity::class.java)
                    startActivity(intent)
                }

                true
            }



            sideMenuButId.setOnClickListener {
                mainDrawerId.openDrawer(GravityCompat.START)
            }
            notiId.setOnClickListener{
                val intent1 = Intent(this@MainActivity, NotificationActivity::class.java)
                startActivity(intent1)
            }
        }


        c_viewModel = ViewModelProvider(this)[CoursesViewModel::class.java]

        c_viewModel.coursesLiveData.observe(this) { courses ->


        }
        // Fetch the courses data
        // this function contains live data so when data is fetched , above observer takes that list displays toast
        c_viewModel.fetchCourses()

        bottomNav()



    }

    private fun bottomNav() {
        navController = (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController
        bottomNavigationView = findViewById(R.id.ChipBottom)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        // Set up the BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Movie_frag_button -> {
                    navController.navigate(R.id.coursesFrag)

                }

                R.id.Series_frag_button -> {
                    navController.navigate(R.id.favFrag)

                }

                R.id.Upcoming_frag_button -> {
                    navController.navigate(R.id.historyFrag)

                }

                R.id.Account_frag_button -> {
                    navController.navigate(R.id.profileFrag)

                }

            }
            true
        }
    }
}