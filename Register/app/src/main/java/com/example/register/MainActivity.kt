package com.example.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtUsername = findViewById<EditText>(R.id.username) as EditText;
        val edtEmail = findViewById<EditText>(R.id.email) as EditText;
        val edtPassword = findViewById<EditText>(R.id.password) as EditText;
        val edtRepassword = findViewById<EditText>(R.id.repassword) as EditText;

        val btnSignup = findViewById<Button>(R.id.btnsignup) as Button;
        val btnSignin = findViewById<Button>(R.id.btnsignin) as Button;

        var dbHelper = DBHelper(this)

        btnSignup.setOnClickListener{
            val name = edtUsername.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            val repassword = edtRepassword.text.toString()
            if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter data into the required fields", Toast.LENGTH_SHORT)
                    .show()
            } else if(!(password.equals(repassword))){
                Toast.makeText(this, "The passwords do not match", Toast.LENGTH_SHORT)
                    .show()

            }
            else{
                val usr = UserModel(name = name, email = email)
                Log.i("Register","usr made: " + usr.id)
                val status = dbHelper.insertUser(usr)
                Toast.makeText(this, "Status: $status", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}