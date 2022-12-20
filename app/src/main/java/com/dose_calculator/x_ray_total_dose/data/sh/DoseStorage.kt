package com.dose_calculator.x_ray_total_dose.data.sh

import com.dose_calculator.x_ray_total_dose.data.models.GetAndClearStorageModels.GetDoseModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.GetAndClearStorageModels.SaveDoseModelStorage

interface DoseStorage {

    fun save(doseModelStorage: SaveDoseModelStorage): GetDoseModelStorage

    fun clear(): GetDoseModelStorage

}