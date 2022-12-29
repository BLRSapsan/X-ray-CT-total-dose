package com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase

import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientAgeGroupModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.AgeCalculateInterface

class CoefficientUseCase (private val ageCalculateInterface: AgeCalculateInterface) {
    fun execute(coefficientAgeGroup: CoefficientAgeGroupModelDomain):CoefficientModelDomain {
        return ageCalculateInterface.coefficient(coefficient = coefficientAgeGroup)
    }
}