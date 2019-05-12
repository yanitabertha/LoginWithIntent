package com.stmm.loginapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var usernameInput: String = ""
    var passwordInput: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnReg.setOnClickListener() {
            validasiReg()
        }
    }

    private fun validasiReg() {
        usernameInput = edtUsername.text.toString()
        passwordInput = edtPassword.text.toString()

        when {
            usernameInput.isEmpty() -> edtUsername.error = "Username tidak boleh kosong"
            passwordInput.isEmpty() -> edtPassword.error = "Password tidak boleh kosong"

            else -> {
                tampilToast("Menuju Login Page")
                navigasiKeLoginPage()
            }
        }
    }


    private fun navigasiKeLoginPage() {
        val intent = Intent(this, LoginActivity::class.java)
        val bundle = Bundle()
        bundle.putString("username1", usernameInput)
        bundle.putString("password1", passwordInput)

        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }
}
