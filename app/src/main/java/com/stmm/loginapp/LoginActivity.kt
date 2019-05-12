package com.stmm.loginapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    var usernameLog: String = ""
    var passwordLog: String = ""
    var dataUsername: String = ""
    var dataPassword: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ambilData()

        btnLogin.setOnClickListener() {
            validasiLogin()
        }

    }

    private fun ambilData() {
        val bundle = intent.extras
        dataUsername = bundle.getString("username1")
        dataPassword = bundle.getString("password1")
        txtUsername.text = dataUsername
        txtPassword.text = dataPassword

    }

    private fun validasiLogin() {
        usernameLog = logUsername.text.toString()
        passwordLog = logPassword.text.toString()


        if (usernameLog != dataUsername) {
            tampilToast("Username yang dimasukkan salah")
        } else if (passwordLog != dataPassword) {
            tampilToast("Password yang dimasukkan salah")
        } else {
            tampilToast("Menuju Halaman Utama")
            navigasiKeHalamanUtama()

        }
    }


    private fun navigasiKeHalamanUtama() {
        val intent = Intent(this, Hello::class.java)
        val bundle = Bundle()
        bundle.putString("usernameLog", usernameLog)
        bundle.putString("passwordLog", passwordLog)
        intent.putExtras(bundle)
        startActivity(intent)

    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }


}
