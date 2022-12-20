package com.dose_calculator.x_ray_total_dose.data.coefficient

import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientArrayDoubleModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientArrayListModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.EditArrayModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.StringModelStorage

interface CoefficientInterface {

    fun coefficientAge(coefficientArrayListModelStorage: CoefficientArrayListModelStorage): CoefficientArrayDoubleModelStorage

    fun change(editArrayModelStorage: EditArrayModelStorage, coef:CoefficientArrayDoubleModelStorage): StringModelStorage

}