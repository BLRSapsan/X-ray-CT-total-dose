package com.dose_calculator.x_ray_total_dose.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.dose_calculator.x_ray_total_dose.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()

    private var selectedItemAge: Byte = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val headNeck = findViewById<EditText>(R.id.headNeck)
        val head = findViewById<EditText>(R.id.head)
        val neck = findViewById<EditText>(R.id.neck)
        val chest = findViewById<EditText>(R.id.chest)
        val abdomenPelvis = findViewById<EditText>(R.id.abdomenPelvis)
        val trunk = findViewById<EditText>(R.id.trunk)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val totalDose = findViewById<TextView>(R.id.total_Dose)
        val calculateDoseButton = findViewById<Button>(R.id.sum_dose)
        val cleanDoseButton = findViewById<Button>(R.id.clean_dose)

        val arrayEditText: ArrayList<EditText> = ArrayList()
        arrayEditText.add(0, headNeck)
        arrayEditText.add(1, head)
        arrayEditText.add(2, neck)
        arrayEditText.add(3, chest)
        arrayEditText.add(4, abdomenPelvis)
        arrayEditText.add(5, trunk)

        ArrayAdapter.createFromResource(
            this,
            R.array.adult_or_child,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> selectedItemAge = 0
                    1 -> selectedItemAge = 1
                    2 -> selectedItemAge = 2
                    3 -> selectedItemAge = 3
                    4 -> selectedItemAge = 4
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        //подписка на изменение данных. Как только resultLive изменяется, сразу вызывает код totalDose.text
        vm.openResultValue.observe(this) {
            totalDose.text = it
        }

        //для скрытия клавиатуры при нажатии на кнопку calculateDoseButton
        fun View.hideKeyboard() {
            val inputManager =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(windowToken, 0)
        }

        calculateDoseButton.setOnClickListener {
            it.hideKeyboard()
            vm.sum(array = arrayEditText, coefficientAge = selectedItemAge)
        }

        cleanDoseButton.setOnClickListener {
            for (clearEditText in arrayEditText) {
                clearEditText.text.clear()
                vm.clear()
            }
        }
    }
}