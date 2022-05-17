package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping.*


class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val thisIntent = intent.getStringExtra("user")
        textViewUsername.text = "Welcome $thisIntent"
    }

    fun imageClicked(view: View) {
        var msg = "You have chosen the category of"

        when(view.getId()){
            R.id.imageViewBeauty -> {msg = "$msg beauty"}
            R.id.imageViewClothing -> {msg = "$msg clothing"}
            R.id.imageViewFood -> {msg = "$msg food"}
            R.id.imageViewElectronics ->{msg = "$msg electronics"}
            else -> {msg = "No image selected"}
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}