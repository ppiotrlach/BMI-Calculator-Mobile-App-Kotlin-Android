package com.szpaklach.bmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.set
import android.util.Log
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ageText: EditText = findViewById(R.id.age_editTextNumber)
        val heightText: EditText = findViewById(R.id.height_editTextNumber)
        val weightText: EditText = findViewById(R.id.weight_editTextNumber)

        val maleRadio: RadioButton = findViewById(R.id.male_radioButton)

        val button: Button = findViewById(R.id.calculateBMIButton)
        button.setOnClickListener {
            // your code to perform when the user clicks on the button

            if(ageText.text.toString() == "" || heightText.text.toString() == "" || weightText.text.toString() == "")
            {
                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }
            else{
                var age : Number =  Integer.parseInt(ageText.text.toString())
                var height : Number =  Integer.parseInt(ageText.text.toString())
                var weight : Number =  Integer.parseInt(ageText.text.toString())

                var isMan : Boolean = maleRadio.isChecked()

                var calculatedBMI = weight.toDouble()/Math.pow((height.toDouble()/100),2.0)


                var result : String = calculatedBMI.toString()


                Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()

            }
//                Toast.makeText(this@MainActivity, "RADIO", Toast.LENGTH_SHORT).show()

        }
    }
}