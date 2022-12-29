package com.dose_calculator.x_ray_total_dose.domain.repository

import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientAgeGroupModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.EditTextModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.StringModelDomain

interface AgeCalculateInterface {
    fun coefficient(coefficient: CoefficientAgeGroupModelDomain): CoefficientModelDomain
    fun calculate(edit: EditTextModelDomain, coefficient: CoefficientModelDomain): StringModelDomain
}