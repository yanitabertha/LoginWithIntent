package com.stmm.loginapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hello.*

class Hello : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        ambilNama()
    }

    private fun ambilNama() {
        val bundle = intent.extras
        val username = bundle?.getString("usernameLog")
        txtUsername.text = username
    }
}
