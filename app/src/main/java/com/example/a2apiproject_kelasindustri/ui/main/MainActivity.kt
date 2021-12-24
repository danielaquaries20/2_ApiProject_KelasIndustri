package com.example.a2apiproject_kelasindustri.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.a2apiproject_kelasindustri.R
import com.example.a2apiproject_kelasindustri.ui.paging.PagingActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonPaging: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button
        buttonPaging = findViewById(R.id.btnPaging)

        buttonPaging.setOnClickListener {
            val maju = Intent(this, PagingActivity::class.java)
            startActivity(maju)
        }

    }
}