package com.dose_calculator.x_ray_total_dose.presentation

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.dose_calculator.x_ray_total_dose.R
import com.dose_calculator.x_ray_total_dose.databinding.ActivityMainBinding
import com.dose_calculator.x_ray_total_dose.theme.KEY_THEME
import com.dose_calculator.x_ray_total_dose.theme.PREFS_NAME
import com.dose_calculator.x_ray_total_dose.theme.THEME_DARK
import com.dose_calculator.x_ray_total_dose.theme.THEME_LIGHT
import com.dose_calculator.x_ray_total_dose.theme.THEME_UNDEFINED
import com.dose_calculator.x_ray_total_dose.theme.ThemeChange
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity: AppCompatActivity() {
    private val sharedPrefs by lazy { getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = ViewPager(this)
        TabLayoutMediator(binding.tabMode, binding.pager) { tab, position ->
            when (position) {
                0 -> tab.setText(R.string.mSv)
                1 -> tab.setText(R.string.skf)
            }
        }.attach()

        themeMainActivity()
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

        when (sharedPrefs.getInt(KEY_THEME, THEME_UNDEFINED)) {
            THEME_LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            THEME_DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
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