package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.view.View
import android.widget.EditText
const val EXTRA_MESSAGE = "com.example.registration.MESSAGE"



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun sendMessage(view: View) {

        try {
            val myDatabase =
                this.openOrCreateDatabase("User", AppCompatActivity.MODE_PRIVATE, null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS user (name VARCHAR, batch VARCHAR, email VARCHAR)")

            val nameText = findViewById<EditText>(R.id.nameText)
            val batch = findViewById<EditText>(R.id.batchText)
            val email = findViewById<EditText>(R.id.emailText)

            val name = nameText.text.toString()
            val batchT = batch.text.toString()
            val ema = email.text.toString()

            val intent = Intent(this@MainActivity, homeScreen::class.java)
            val query = "INSERT INTO user (name,batch,email) VALUES('"+name+"','"+batchT+"','"+ema+"')"

            myDatabase.execSQL(query)
            val c = myDatabase.rawQuery("select * from user", null)
            startActivity(intent)
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
