package com.dose_calculator.x_ray_total_dose.domain.repository

import com.dose_calculator.x_ray_total_dose.domain.models.SaveDeleteDomainModels.SaveModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.SaveDeleteDomainModels.GetResultModelDomain

interface SaveDeleteInterface {
    fun saveDose(saveDose: SaveModelDomain): GetResultModelDomain
    fun deleteDose(): GetResultModelDomain
}