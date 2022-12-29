package com.dose_calculator.x_ray_total_dose.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.EditText
import com.dose_calculator.x_ray_total_dose.R
import com.dose_calculator.x_ray_total_dose.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private var ageGroup: Byte = 1
    private lateinit var binding: ActivityMainBinding

    private var coefficient = object : OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when (p2) {
                0 -> ageGroup = 0
                1 -> ageGroup = 1
                2 -> ageGroup = 2
                3 -> ageGroup = 3
                4 -> ageGroup = 4
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayEditText: ArrayList<EditText> = ArrayList<EditText>().apply {
            add(0, binding.headNeck)
            add(1, binding.head)
            add(2, binding.neck)
            add(3, binding.chest)
            add(4, binding.abdomenPelvis)
            add(5, binding.trunk)
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.adult_or_child,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
            binding.spinner.adapter = adapter
        }

        binding.spinner.onItemSelectedListener = coefficient

        //подписка на изменение данных.
        viewModel.openResultValue.observe(this) {
            binding.effectiveDose.text = it
        }

        binding.calculateDose.setOnClickListener {
            it.hideKeyboard()
            viewModel.calculate(array = arrayEditText, coefficient = ageGroup)
        }

        binding.deleteDose.setOnClickListener {
            it.hideKeyboard()
            for (clearEditText in arrayEditText) {
                clearEditText.text.clear()
                viewModel.deleteValues()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.info_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.info_menu_icon -> {
                val intentInfo = Intent(this, Information::class.java)
                startActivity(intentInfo)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}