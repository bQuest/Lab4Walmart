package com.example.walmart

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var userList = ArrayList<User>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userList.add(User("Brian", "Onyango", "bonyango@miu.edu", "123"))

        var res = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result -> {
            if(result.resultCode == Activity.RESULT_OK) {
                //add object to arraylist
//                var inte = intent.getSerializableExtra("userObj") as User
                //var newuser  = in
                //Toast.makeText(this, inte.toString(), Toast.LENGTH_LONG ).show()
                textViewMessage.text = result.data?.data.toString()

            }
            else
                textViewMessage.text = "No user account added"
            }

        }
        
        buttonCreateAccount.setOnClickListener{
            var newUserIntent = Intent(this, CreateAccountActivity::class.java)
//            res.launch(newUserIntent)
            startActivity(newUserIntent)

        }

        buttonSignIn.setOnClickListener{
            var categoryIntent = Intent(this, ShoppingActivity::class.java)

            var username = editTextTextEmailAddress.text.toString()
            var password = editTextTextPassword.text.toString()

            if (validateUserlogin(username, password)){
                categoryIntent.putExtra("user", username )
                startActivity(categoryIntent)
            }else
                Toast.makeText(this, "user does not exist", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateUserlogin(username: String, password: String) : Boolean {
        for (user in userList){
            if (user.username == username && user.password == password)
                return true;
        }
        return false;
    }

    fun forgotPasswordClicked(view: View) {
        var emailContent = editTextTextEmailAddress.text.toString()
        ShareCompat.IntentBuilder
            .from(this)
            .setType("text/plain")
            .setText(emailContent)
            .setChooserTitle("Emailing this to: ")
            .startChooser()
    }


}