package com.example.luckynumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val text1: TextView = findViewById(R.id.txt1)
        val luckyText: TextView = findViewById(R.id.luckyNumTxt)
        val shareBtn: Button = findViewById(R.id.shareBtn)

        var user_name = recieveUserName()
       // Toast.makeText(this, ""+user_name, Toast.LENGTH_LONG).show()

        var random_num = genrateRandomNum()

        luckyText.setText(""+ random_num)

        shareBtn.setOnClickListener(){
            shareData(user_name, random_num)
        }


    }

    fun recieveUserName():String{
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("name").toString()
        return username
    }

    //Random number Gnerator
    fun genrateRandomNum(): Int{
        val random = Random.nextInt(until = 1000)
        return random

    }

    //sharing the username &number

    fun shareData(username: String, num: Int) {

        //Implicit Intent
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today")
        i.putExtra(Intent.ACTION_PROCESS_TEXT, "His lucky number is $num")
        startActivity(i)
    }
}