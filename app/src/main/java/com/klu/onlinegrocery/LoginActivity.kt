package com.klu.onlinegrocery

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.klu.onlinegrocery.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var emailText: EditText
    private lateinit var passwordText: EditText
    private lateinit var btnLogin: Button
    private lateinit var signupLink: TextView  // 🔹 Add this to refer to the Sign Up link

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailText = findViewById(R.id.email_input)
        passwordText = findViewById(R.id.password_input)
        btnLogin = findViewById(R.id.login_button)
        signupLink = findViewById(R.id.signup_link)  // 🔹 Refer to the Sign Up TextView

        // 🔹 Redirect to SignupActivity
        signupLink.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        // 🔹 On Login button click
        btnLogin.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val email = emailText.text.toString().trim()
        val password = passwordText.text.toString().trim()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            // 🔹 Pass name if required by the backend User model
            val user = User(email = email, password = password, name = "User") // Replace with real name if needed

            RetrofitClient.instance.loginUser(user).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        val token = loginResponse?.token

                        // 🔹 Show success
                        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT).show()

                        // 🔹 Proceed to main screen
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Login Failed: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Network Error: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
        } else {
            Toast.makeText(this, "Enter valid email & password", Toast.LENGTH_SHORT).show()
        }
    }
}
