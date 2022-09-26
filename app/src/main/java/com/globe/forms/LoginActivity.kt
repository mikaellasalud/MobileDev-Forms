package com.globe.forms

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var tvAppName:TextView
    private lateinit var ivAppLogo:ImageView
    private lateinit var etEmail:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvAppName = findViewById(R.id.tvAppName)
        ivAppLogo = findViewById(R.id.ivAppLogo)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("LoginActivity","Login button clicked")

                login()
            }
        })

    }

    private fun login() {

        val isValidPassword = validatePassword()
        if(!isValidPassword){
            Toast.makeText(this, "Password should be greater than 6 characters", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        Log.d("LoginActivity","email: $email password:$password")

        toMainActivity()
    }

    private fun toMainActivity() {

        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        val mainIntent = Intent(this, MainActivity::class.java)

        mainIntent.putExtra(Constants.EMAIL, email)
        mainIntent.putExtra(Constants.PASSWORD, password)

        startActivity(mainIntent)
        finish()
    }

    private fun validatePassword() : Boolean {
        val password = etPassword.text.toString()
        return password.length > 6
    }
}
