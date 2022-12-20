package com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase

import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientArrayDoubleModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.StDInterface

class CoefficientYearsUseCase (private val stDInterface: StDInterface) {
    fun execute(coeff: CoefficientModelDomain):CoefficientArrayDoubleModelDomain {
        return stDInterface.coeff(coefficient = coeff)
    }
}