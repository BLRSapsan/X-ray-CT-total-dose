package com.dose_calculator.x_ray_total_dose.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dose_calculator.x_ray_total_dose.R

class InfoDose: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_dose)

        val textInfoTable = findViewById<TextView>(R.id.infoText)
        val tableS:String = resources.getString(R.string.table_dose)
        textInfoTable.text = tableS

    }
}