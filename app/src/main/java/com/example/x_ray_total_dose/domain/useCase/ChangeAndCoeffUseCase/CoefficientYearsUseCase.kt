package com.example.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase

import com.example.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientArrayDoubleModelDomain
import com.example.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.example.x_ray_total_dose.domain.repository.StDInterface

class CoefficientYearsUseCase (private val stDInterface: StDInterface) {
    fun execute(coeff: CoefficientModelDomain):CoefficientArrayDoubleModelDomain {
        return stDInterface.coeff(coefficient = coeff)
    }
}