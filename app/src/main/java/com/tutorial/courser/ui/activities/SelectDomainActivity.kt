package com.tutorial.courser.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import com.tutorial.courser.R
import com.tutorial.courser.databinding.ActivitySelectDomainBinding


class SelectDomainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectDomainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectDomainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            cardViewtop1.setOnClickListener {
                val intent = Intent(this@SelectDomainActivity, MainActivity::class.java)
                val options = ActivityOptionsCompat.makeScaleUpAnimation(binding.root, 0, 0, binding.root.getWidth(), binding.root.getHeight())
                ActivityCompat.startActivity(this@SelectDomainActivity, intent, options.toBundle())
                finish()

            }
        }
    }
}