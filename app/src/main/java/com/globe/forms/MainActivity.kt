package com.globe.forms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var tvShowEmail: TextView
    private lateinit var btnResetPassword: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Log.d("MainActivity", "onCreate")
        tvShowEmail = findViewById(R.id.tvShowEmail)
        btnResetPassword = findViewById(R.id.btnResetPassword)

        val email = intent.getStringExtra(Constants.EMAIL)
        //val password = intent.getStringExtra(Constants.PASSWORD)
        //Log.d("MainActivity", "$email $password")

        tvShowEmail.text = "$email"

        btnResetPassword.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("LoginActivity","Login button clicked")

                resetPassword()
            }
        })
    }
    private fun resetPassword() {

        val currentPassword = intent.getStringExtra(Constants.PASSWORD)

        val resetIntent = Intent(this, ResetPasswordActivity::class.java)

        resetIntent.putExtra(Constants.PASSWORD, currentPassword)

        startActivity(resetIntent)
    }

    /*override fun onStart() {
        super.onStart()
        Log.d("Main Activity", "onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.d("Main Activity", "onResume")

    }

    override fun onPause(){
        super.onPause()
        Log.d("Main Activity", "onPause")

    }

    override fun onStop(){
        super.onStop()
        Log.d("Main Activity", "onStop")

    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("Main Activity", "onDestroy")


    }*/
}