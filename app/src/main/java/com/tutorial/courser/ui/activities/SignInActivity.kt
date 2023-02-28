package com.tutorial.courser.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tutorial.courser.R
import com.tutorial.courser.databinding.ActivitySigninBinding
import es.dmoral.toasty.Toasty


class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            signinButton.setOnClickListener {
                val intent = Intent(this@SignInActivity, MainActivity::class.java)
                startActivity(intent)
                Toasty.info(this@SignInActivity, "Sign In Successful", Toast.LENGTH_SHORT, true).show()
                finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        }
    }
}