package com.globe.forms

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ResetPasswordActivity: AppCompatActivity() {

    private lateinit var etNewPassword : EditText
    private lateinit var btnReset : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        val currentPassword = intent.getStringExtra(Constants.PASSWORD)
        etNewPassword = findViewById(R.id.etNewPassword)
        btnReset = findViewById(R.id.btnReset)

        etNewPassword.setText(currentPassword!!)


        btnReset.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {

                finish()
            }
    })
}}