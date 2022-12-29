package com.dose_calculator.x_ray_total_dose.data.SharedPref

import com.dose_calculator.x_ray_total_dose.data.models.SaveDeleteStorageModels.GetDoseModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.SaveDeleteStorageModels.SaveDoseModelStorage

interface DoseShPrStorageInterface {
    fun save(saveDoseModelStorage: SaveDoseModelStorage): GetDoseModelStorage
    fun delete(): GetDoseModelStorage
}