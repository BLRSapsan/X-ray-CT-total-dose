package com.dose_calculator.x_ray_total_dose.domain.repository

import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.CalculateModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetDoseModelDomain

interface RepositoryInterface {

    fun sumDose(calculate: CalculateModelDomain): GetDoseModelDomain

    fun clearDose(): GetDoseModelDomain

}