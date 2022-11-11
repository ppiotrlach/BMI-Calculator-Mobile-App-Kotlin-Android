package com.szpaklach.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val BMI = intent.getStringExtra("BMI")
        val interpretation = intent.getStringExtra("interpretation")
        val bodyType = intent.getStringExtra("type")


        val textView: TextView = findViewById(R.id.passedResultTextView)
        textView.text = "BMI = $BMI - $interpretation"

        val imageView: ImageView = findViewById(R.id.graphImageView)


        if(bodyType == "GIRL"){
            imageView.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/graph_girls", null, packageName)))
        }else if (bodyType == "BOY"){
            imageView.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/graph_boys", null, packageName)))
        }else //ADULT
        {
            imageView.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/graph_adults", null, packageName)))
        }


        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}