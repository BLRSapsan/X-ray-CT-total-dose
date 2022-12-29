package com.dose_calculator.x_ray_total_dose.domain.repository

import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.CoefficientAgeGroupModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.EditTextModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.StringModelDomain

interface AgeCalculateInterface {
    fun coefficient(coefficient: CoefficientAgeGroupModelDomain): CoefficientModelDomain
    fun calculate(edit: EditTextModelDomain, coefficient: CoefficientModelDomain): StringModelDomain
}