package com.example.x_ray_total_dose.domain.repository

import com.example.x_ray_total_dose.domain.models.GetAndClearDomainModels.CalculateModelDomain
import com.example.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetDoseModelDomain

interface RepositoryInterface {

    fun sumDose(calculate: CalculateModelDomain): GetDoseModelDomain

    fun clearDose(): GetDoseModelDomain

}