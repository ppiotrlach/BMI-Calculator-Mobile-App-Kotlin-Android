package com.szpaklach.bmicalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.*


class MainActivity : AppCompatActivity() {
    private val BMITableGirl = mapOf(
        2 to arrayOf(14.15, 18.02, 19.11),
        5 to arrayOf(13.34, 16.8, 18.26),
        8 to arrayOf(13.3, 18.32, 29.7),
        11 to arrayOf(14.08, 20.87, 24.14),
        14 to arrayOf(15.44, 23.35, 27.26),
        17 to arrayOf(16.84, 25.2, 29.63),
        20 to arrayOf(17.43, 26.48, 31.76)
    );

    private val BMITableBoy = mapOf(
        2 to arrayOf(14.74, 18.16, 19.34),
        5 to arrayOf(13.84, 16.84, 17.94),
        8 to arrayOf(13.8, 17.96, 20.07),
        11 to arrayOf(14.56, 20.2, 23.21),
        14 to arrayOf(15.99, 22.66, 26.05),
        17 to arrayOf(17.7, 24.94, 28.26),
        20 to arrayOf(19.12, 27.05, 30.59)
    );

    private var age : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val ageText: EditText = findViewById(R.id.age_editTextNumber)
        val heightText: EditText = findViewById(R.id.height_editTextNumber)
        val weightText: EditText = findViewById(R.id.weight_editTextNumber)

//        ageText.addTextChangedListener(object : TextWatcher{
//
//        })

        ageText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                hideResults()
            }
        })

        heightText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                hideResults()
            }
        })

        weightText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                hideResults()
            }
        })




        val maleRadio: RadioButton = findViewById(R.id.male_radioButton)

        val button: Button = findViewById(R.id.calculateBMIButton)
        button.setOnClickListener {
            // your code to perform when the user clicks on the button

            if (ageText.text.toString() == "" || heightText.text.toString() == "" || weightText.text.toString() == "") {
                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            } else {
                age = Integer.parseInt(ageText.text.toString())
                var height: Float = heightText.text.toString().toFloat() / 100
                var weight: Float = weightText.text.toString().toFloat()

                var isMan: Boolean = maleRadio.isChecked

                calculateBMI(height, weight, isMan)
            }
        }

        val resultsButton: Button = findViewById(R.id.inspectResultsButton)
        resultsButton.setOnClickListener {
            //ROUTING
        }


    }



    private fun calculateBMI(height: Float, weight: Float, isMan : Boolean) {
        val BMI: Float = weight / (height * height)
        var bmiInterpretation: String = ""


        if (age <= 20) {
            if (isMan) {
                bmiInterpretation = checkKidBoyBMI(BMI)
            } else {
                bmiInterpretation = checkKidGirlBMI(BMI)
            }
            } else {
                if (BMI < 16) {
                    bmiInterpretation = "Severe Thinness"
                } else if (BMI < 17) {
                    bmiInterpretation = "Moderate Thinness"
                } else if (BMI < 18.5) {
                    bmiInterpretation = "Mild Thinness"
                } else if (BMI < 25) {
                    bmiInterpretation = "Normal"
                } else if (BMI < 30) {
                    bmiInterpretation = "Overweight"
                } else if (BMI < 35) {
                    bmiInterpretation = "Obese Class I"
                } else if (BMI < 40) {
                    bmiInterpretation = "Obese Class II"
                } else {
                    bmiInterpretation = "Obese Class III"
                }
            }




            val textView: TextView = findViewById(R.id.resultTextView)
            textView.text = "YOUR BMI: $BMI - $bmiInterpretation"
            textView.visibility = View.VISIBLE

            val resultsButton: Button = findViewById(R.id.inspectResultsButton)
            resultsButton.visibility = View.VISIBLE
//        Toast.makeText(this@MainActivity, bmi.toString(), Toast.LENGTH_SHORT).show()
        }



    //on change text fieldow
    private fun hideResults(){
        val textView: TextView = findViewById(R.id.resultTextView)
        textView.visibility = View.INVISIBLE

        val resultsButton: Button = findViewById(R.id.inspectResultsButton)
        resultsButton.visibility = View.INVISIBLE
    }

    private fun checkKidBoyBMI(BMI: Float): String {
        return if (age <= 2) {
            checkBodyTypeBasedOnTable(2, BMI, BMITableBoy);
        } else if (age <= 5) {
            checkBodyTypeBasedOnTable(5, BMI, BMITableBoy);
        } else if (age <= 8) {
            checkBodyTypeBasedOnTable(8, BMI, BMITableBoy);
        } else if (age <= 11) {
            checkBodyTypeBasedOnTable(11, BMI, BMITableBoy);
        } else if (age <= 14) {
            checkBodyTypeBasedOnTable(14, BMI, BMITableBoy);
        } else if (age <= 17) {
            checkBodyTypeBasedOnTable(17, BMI, BMITableBoy);
        } else {
            checkBodyTypeBasedOnTable(20, BMI, BMITableBoy);
        }
    };

    private fun checkKidGirlBMI(BMI: Float): String {
        return if (age <= 2) {
            checkBodyTypeBasedOnTable(2, BMI, BMITableGirl);
        } else if (age <= 5) {
            checkBodyTypeBasedOnTable(5, BMI, BMITableGirl);
        } else if (age <= 8) {
            checkBodyTypeBasedOnTable(8, BMI, BMITableGirl);
        } else if (age <= 11) {
            checkBodyTypeBasedOnTable(11, BMI, BMITableGirl);
        } else if (age <= 14) {
            checkBodyTypeBasedOnTable(14, BMI, BMITableGirl);
        } else if (age <= 17) {
            checkBodyTypeBasedOnTable(17, BMI, BMITableGirl);
        } else {
            checkBodyTypeBasedOnTable(20, BMI, BMITableGirl);
        }
    };




    private fun checkBodyTypeBasedOnTable(
        age: Int,
        BMI: Float,
        BMITable: Map<Int, Array<Double>>
    ): String {
        return if (BMI < BMITable[age]!![0]) {
            "Underweight";
        } else if (BMI < BMITable[age]!![1]) {
            "Healthy weight";
        } else if (BMI < BMITable[age]!![2]) {
            "At risk of overweight";
        } else {
            "Overweight";
        }
    }


}
