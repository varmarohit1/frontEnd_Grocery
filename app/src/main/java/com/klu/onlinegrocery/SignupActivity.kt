package com.klu.onlinegrocery

//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.klu.onlinegrocery.models.User
//import retrofit2.Call
//import retrofit2.Response
//
//class SignupActivity : AppCompatActivity() {
//    private lateinit var nameText: EditText
//    private lateinit var emailText: EditText
//    private lateinit var passwordText: EditText
//    private lateinit var btnSignUp: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_signup)
//
//
//        nameText = findViewById(R.id.name_input)
//        emailText = findViewById(R.id.email_input)
//        passwordText = findViewById(R.id.password_input)
//        btnSignUp = findViewById(R.id.signup_button)
//
//        btnSignUp.setOnClickListener {
//
//            registerUser()
//
//        }
//
//
//    }
//    private fun registerUser() {
//        val email = emailText.text.toString().trim()
//        val password = passwordText.text.toString().trim()
//        val name = nameText.text.toString().trim()
//
//
//        if (email.isNotEmpty() && password.length >= 6) {
//            val user = User(name, email, password)
//
//            val BASE_URL = "http://10.0.2.2:3000"  // Change if needed
//            Log.d("API_CALL", "Registering user at: $BASE_URL/api/auth/register-user")
//
//            RetrofitClient.instance.registerUser(user).enqueue(object : retrofit2.Callback<User> {
//                override fun onResponse(call : Call<User>, response: Response<User>){
//                    if(response.isSuccessful){
//                        Toast.makeText(this@SignupActivity,"Registration Succesful", Toast.LENGTH_SHORT).show()
//                        val intent = Intent(this@SignupActivity, MainActivity::class.java)
//                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Clears back stack
//
//                        startActivity(intent)
//                        finish()
//                    }else{
//                        val errorBody = response.errorBody()?.string()
//                        Toast.makeText(this@SignupActivity,"Registration failed: ${errorBody}", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<User?>, t: Throwable) {
//                    Toast.makeText(this@SignupActivity,"Network Error: ${t.message}", Toast.LENGTH_LONG).show()
//                }
//            })
//
//
//        } else {
//            Toast.makeText(this, "Enter valid email & password", Toast.LENGTH_SHORT).show()
//        }
//    }
//}

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.klu.onlinegrocery.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {

    private lateinit var nameText: EditText
    private lateinit var emailText: EditText
    private lateinit var passwordText: EditText
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Bind views
        nameText = findViewById(R.id.name_input)
        emailText = findViewById(R.id.email_input)
        passwordText = findViewById(R.id.password_input)
        btnSignUp = findViewById(R.id.signup_button)

        // On Sign Up button click
        btnSignUp.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val name = nameText.text.toString().trim()
        val email = emailText.text.toString().trim()
        val password = passwordText.text.toString().trim()

        if (email.isNotEmpty() && password.length >= 6) {
            val user = User(name, email, password)
            val BASE_URL = "http://10.0.2.2:3000" // Adjust for your environment
            Log.d("API_CALL", "Registering user at: $BASE_URL/api/auth/register-user")

            RetrofitClient.instance.registerUser(user).enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        Toast.makeText(
                            this@SignupActivity,
                            "Registration Successful",
                            Toast.LENGTH_SHORT
                        ).show()

                        // 🔔 Show push notification
                        NotificationClass().showNotification(
                            context = this@SignupActivity,
                            eventType = "Signup",
                            message = "Welcome ${name}!"
                        )

                        // Navigate to MainActivity
                        val intent = Intent(this@SignupActivity, MainActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                        finish()
                    } else {

                        NotificationClass().showNotification(
                            context = this@SignupActivity,
                            eventType = "Signup",
                            message = "sign up failed ${name}!"
                        )

                        val errorBody = response.errorBody()?.string()
                        Toast.makeText(
                            this@SignupActivity,
                            "Registration failed: $errorBody",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(
                        this@SignupActivity,
                        "Network Error: ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        } else {
            Toast.makeText(this, "Enter valid email & password", Toast.LENGTH_SHORT).show()
        }
    }
}
