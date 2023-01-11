package com.dose_calculator.x_ray_total_dose.domain.useCase.CoefficientCalculate

import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.CoefficientAgeGroupModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.AgeCalculateInterface

class CoefficientUseCase (private val ageCalculateInterface: AgeCalculateInterface) {
    operator fun invoke (coefficientAgeGroup: CoefficientAgeGroupModelDomain):CoefficientModelDomain {
        return ageCalculateInterface.coefficient(coefficient = coefficientAgeGroup)
    }
}