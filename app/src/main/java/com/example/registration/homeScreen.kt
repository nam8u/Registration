package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class homeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

    }
    fun navigateMain(view: View){
        val intent = Intent(this@homeScreen,MainActivity::class.java)
        startActivity(intent)
    }

}
