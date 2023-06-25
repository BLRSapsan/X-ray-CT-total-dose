package com.dose_calculator.x_ray_total_dose.presentation

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatDelegate
import com.dose_calculator.x_ray_total_dose.R
import com.dose_calculator.x_ray_total_dose.databinding.ActivityMainBinding
import com.dose_calculator.x_ray_total_dose.theme.KEY_THEME
import com.dose_calculator.x_ray_total_dose.theme.PREFS_NAME
import com.dose_calculator.x_ray_total_dose.theme.THEME_BATTERY
import com.dose_calculator.x_ray_total_dose.theme.THEME_DARK
import com.dose_calculator.x_ray_total_dose.theme.THEME_LIGHT
import com.dose_calculator.x_ray_total_dose.theme.THEME_SYSTEM
import com.dose_calculator.x_ray_total_dose.theme.THEME_UNDEFINED
import com.dose_calculator.x_ray_total_dose.theme.ThemeChange
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

    private val sharedPrefs by lazy { getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        themeMainActivity()

        val arrayEditText: ArrayList<EditText> = ArrayList<EditText>().apply {
            add(0, binding.headNeck)
            add(1, binding.head)
            add(2, binding.neck)
            add(3, binding.chest)
            add(4, binding.abdomenPelvis)
            add(5, binding.trunk)
            add(6, binding.coxae)
            add(7, binding.knee)
            add(8, binding.crus)
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
            R.id.theme -> {
                val intentTheme = Intent(this, ThemeChange::class.java)
                startActivity(intentTheme)
                return true
            }

            R.id.info_menu_icon -> {
                val intentInfo = Intent(this, Information::class.java)
                startActivity(intentInfo)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun themeMainActivity() {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())

        val getTheme = sharedPrefs.getInt(KEY_THEME, THEME_UNDEFINED)

        when (getTheme) {
            THEME_LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            THEME_DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            THEME_SYSTEM -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
            THEME_BATTERY -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            THEME_UNDEFINED ->
                when (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
                    Configuration.UI_MODE_NIGHT_NO -> AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO
                    )

                    Configuration.UI_MODE_NIGHT_YES -> AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_YES
                    )

                    Configuration.UI_MODE_NIGHT_UNDEFINED -> AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO
                    )
                }
        }

    }
}