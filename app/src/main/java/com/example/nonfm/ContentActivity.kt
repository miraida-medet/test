package com.example.nonfm

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity:AppCompatActivity() {
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        setContentView(R.layout.content_layout)

        val tvTitle= findViewById<TextView>(R.id.textView2)
        tvTitle.text = intent.getStringExtra("title")

        val tvContent= findViewById<TextView>(R.id.textView3)
        tvContent.text = intent.getStringExtra("content")

        val im=findViewById<ImageView>(R.id.imageView2)
        im.setImageResource(intent.getIntExtra("image",R.drawable.icon))
    }
}