package com.example.pr15

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginEditText = findViewById(R.id.login_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.button)

        loginButton.setOnClickListener {
            val login = loginEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if(login == "ects" || password == "123"){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            if (login.isEmpty() || password.isEmpty()) {
                showToast("Логин и пароль должны быть заполнены")
                return@setOnClickListener
            }
            else
            if (!login.matches(Regex("[a-zA-Z]+"))) {
                showToast("Логин не должен содержать цифры")
                return@setOnClickListener
            }
            else
            if (login != "name" || password != "1234") {
                showToast("Неверный логин или пароль")
                return@setOnClickListener
            }
        }
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }
}
