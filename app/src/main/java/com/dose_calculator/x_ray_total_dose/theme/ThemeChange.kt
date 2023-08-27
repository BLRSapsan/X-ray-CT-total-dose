package com.dose_calculator.x_ray_total_dose.theme

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.dose_calculator.x_ray_total_dose.R

const val PREFS_NAME = "theme_prefs"
const val KEY_THEME = "prefs.theme"
const val THEME_UNDEFINED = -1
const val THEME_LIGHT = 0
const val THEME_DARK = 1
const val THEME_SYSTEM = 2
const val THEME_BATTERY = 3

class ThemeChange: AppCompatActivity() {

    private val sharedPrefs by lazy { getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.theme_change)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())

        initThemeListener()
        initTheme()
    }

    //установка темы
    private fun initThemeListener() {
        val themeGroup = findViewById<RadioGroup>(R.id.themeGroup)
        themeGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.themeLight -> setTheme(AppCompatDelegate.MODE_NIGHT_NO, THEME_LIGHT)
                R.id.themeDark -> setTheme(AppCompatDelegate.MODE_NIGHT_YES, THEME_DARK)
               // R.id.themeBattery -> setTheme(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY, THEME_BATTERY)
               // R.id.themeSystem -> setTheme(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM, THEME_SYSTEM)
            }
        }
    }

    private fun setTheme(themeMode: Int, prefsMode: Int) {
        AppCompatDelegate.setDefaultNightMode(themeMode)
        saveTheme(prefsMode)
    }

    //Проверка текущей темы системы
    private fun initTheme() {
       // val themeSystem = findViewById<RadioButton>(R.id.themeSystem)
        val themeLight = findViewById<RadioButton>(R.id.themeLight)
        val themeDark = findViewById<RadioButton>(R.id.themeDark)
      //  val themeBattery = findViewById<RadioButton>(R.id.themeBattery)

      //  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
      //      themeSystem.visibility = View.VISIBLE
      //  } else {
      //      themeSystem.visibility = View.GONE
      //  }

        when (getSavedTheme()) {
            THEME_LIGHT -> themeLight.isChecked = true
            THEME_DARK -> themeDark.isChecked = true
          //  THEME_SYSTEM -> themeSystem.isChecked = true
          //  THEME_BATTERY -> themeBattery.isChecked = true
            THEME_UNDEFINED -> {   // по умолчанию
                when (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
                    Configuration.UI_MODE_NIGHT_NO -> themeLight.isChecked = true
                    Configuration.UI_MODE_NIGHT_YES -> themeDark.isChecked = true
                    Configuration.UI_MODE_NIGHT_UNDEFINED -> themeLight.isChecked = true
                }
            }
        }
    }

    private fun saveTheme(theme: Int) = sharedPrefs.edit().putInt(KEY_THEME, theme).apply()
    private fun getSavedTheme() = sharedPrefs.getInt(KEY_THEME, THEME_UNDEFINED)
}