package com.example.x_ray_total_dose.data.sh

import android.content.Context
import com.example.x_ray_total_dose.R
import com.example.x_ray_total_dose.data.models.GetAndClearStorageModels.SaveDoseModelStorage
import com.example.x_ray_total_dose.data.models.GetAndClearStorageModels.GetDoseModelStorage

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_TOTAL_DOSE = "calculate_dose"

class SharedPrefDose (context:Context): DoseStorage {

    private val DEFAULT_DOSE:String = context.resources.getString(R.string.writing_dose)
    private val mSv:String = context.resources.getString(R.string.mSv)

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(doseModelStorage: SaveDoseModelStorage): GetDoseModelStorage {
        sharedPreferences.edit().putString(KEY_TOTAL_DOSE, doseModelStorage.saveDose).apply()
        val totalDose =sharedPreferences.getString(KEY_TOTAL_DOSE, DEFAULT_DOSE)?: DEFAULT_DOSE
        val msvTotalDose = "$totalDose $mSv"
        return GetDoseModelStorage(getDose = msvTotalDose)
    }

    override fun clear(): GetDoseModelStorage {
        sharedPreferences.edit().clear().apply()
        val clearDose =sharedPreferences.getString(KEY_TOTAL_DOSE, DEFAULT_DOSE)?: DEFAULT_DOSE
        return GetDoseModelStorage(getDose = clearDose)
    }
}