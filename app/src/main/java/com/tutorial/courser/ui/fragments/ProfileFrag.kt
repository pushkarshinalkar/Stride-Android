package com.tutorial.courser.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tutorial.courser.R
import com.tutorial.courser.databinding.FragmentFavBinding
import com.tutorial.courser.databinding.FragmentProfileBinding
import com.tutorial.courser.ui.activities.LoginActivity
import com.tutorial.courser.ui.activities.SelectDomainActivity
import com.tutorial.courser.ui.activities.SignInActivity
import es.dmoral.toasty.Toasty


class ProfileFrag : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            certificatesCard.setOnClickListener {
                Toasty.warning(view.context, "No Certificates", Toast.LENGTH_SHORT, true).show()
            }

            offersCard.setOnClickListener {
                Toasty.info(view.context, "Offers will be available soon", Toast.LENGTH_SHORT, true).show()
            }

            logoutCard.setOnClickListener {
                val intent = Intent(view.context, LoginActivity::class.java)
                startActivity(intent)
                Toasty.info(view.context, "Logout Successful", Toast.LENGTH_SHORT, true).show()

            }

        }

    }

}