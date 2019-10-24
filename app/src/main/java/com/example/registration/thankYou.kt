package com.example.registration

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_thank_you.*

class thankYou : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)

        val myDatabase = this.openOrCreateDatabase("User", Context.MODE_PRIVATE, null)
        val c = myDatabase.rawQuery("select * from user", null)
        val nameIndex = c.getColumnIndex("name")

        c.moveToFirst()

        var message = ("User List \n\n")

        val txt =  findViewById<TextView>(R.id.rsltTxt)
        txt.setText(message)
        var i = 0
        while (i<=10) {
            Log.i("name", c.getString(nameIndex))
            message = message +(c.getString(nameIndex)+" \n")
            c.moveToNext()
            i++
        }

        txt.setText(message)



    }

}
