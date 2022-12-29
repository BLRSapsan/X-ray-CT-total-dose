package com.dose_calculator.x_ray_total_dose.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dose_calculator.x_ray_total_dose.R

class Information: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information)

        val information = findViewById<TextView>(R.id.informationText)
        val tableS:String = resources.getString(R.string.text_information)
        information.text = tableS
    }
}