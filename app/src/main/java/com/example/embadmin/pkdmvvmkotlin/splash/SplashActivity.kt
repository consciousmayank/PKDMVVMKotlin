package com.example.embadmin.pkdmvvmkotlin.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.embadmin.pkdmvvmkotlin.R
import com.example.embadmin.pkdmvvmkotlin.homepage.ContainerActivity
import com.example.embadmin.pkdmvvmkotlin.signin.SignInActivity
import com.example.embadmin.pkdmvvmkotlin.utils.MyPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {


    lateinit var myPreferences: MyPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        test_textView.text = getString(R.string.app_title)
        myPreferences = MyPreferences(this.applicationContext)
        val handler = Handler()
        handler.postDelayed({

            if (! myPreferences.isUserLoggedIn) {
                startActivity(Intent(SplashActivity@ this, SignInActivity::class.java))
            } else {
                startActivity(Intent(SplashActivity@ this, ContainerActivity::class.java))
            }
            finish()
        }, 2000)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
