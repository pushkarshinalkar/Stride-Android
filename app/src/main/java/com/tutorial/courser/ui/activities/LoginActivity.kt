package com.tutorial.courser.ui.activities


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.ViewModelProvider
import com.tutorial.courser.databinding.ActivityLoginBinding
import com.tutorial.courser.viewmodel.CoursesViewModel
import com.tutorial.courser.viewmodel.UsersViewModel
import es.dmoral.toasty.Toasty


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var u_viewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

//            u_viewModel = ViewModelProvider(this@LoginActivity)[UsersViewModel::class.java]
//
//            u_viewModel.usersLiveData.observe(this@LoginActivity) {userdata ->
//                if(userdata!=null){
////                    Toast.makeText(this@LoginActivity, "data working", Toast.LENGTH_SHORT).show()
//                }else{
////                    Toast.makeText(this@LoginActivity, "working", Toast.LENGTH_SHORT).show()
//                }
//
//
//            }
//            u_viewModel.fetchUsers()
//
//            u_viewModel.loginLiveData.observe(this@LoginActivity) {login ->
//                if(login!=null){
//
//                }else{
//
//                }
//
//            }


            registerText.setOnClickListener {
                val intent2 = Intent(this@LoginActivity, SignInActivity::class.java)
                startActivity(intent2)
                finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }

            loginButton.setOnClickListener {

                if (mailidEdittextLogin.text.toString()=="pushkarshinalkar@gmail.com"&& passwordEdittextLogin.text.toString()=="password123" ){
                    val intent = Intent(this@LoginActivity, SelectDomainActivity::class.java)
                    startActivity(intent)
                    Toasty.success(this@LoginActivity, "Successful login ", Toast.LENGTH_SHORT, true).show()
                    finish()
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
//                    u_viewModel.login(mailidEdittextLogin.text.toString(),passwordEdittextLogin.text.toString())
                }else{
                    Toasty.error(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_SHORT, true).show()
                }

            }




        }
    }
}