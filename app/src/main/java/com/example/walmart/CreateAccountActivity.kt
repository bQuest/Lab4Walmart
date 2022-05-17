package com.example.walmart

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        buttonCreate.setOnClickListener{
            var fname = editTextTextFirstName.text.toString()
            var lname = editTextTextLastName.text.toString()
            var username = editTextTextUsername.text.toString()
            var password = editTextTextPassword2.text.toString()

            val newUserAccount = User(fname, lname, username, password)

            var rint = intent

            //rint.data = Uri.(newUserAccount)
            rint.putExtra("userObj", newUserAccount)

            setResult(Activity.RESULT_OK, rint)
            finish()
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

}