package com.dose_calculator.x_ray_total_dose.domain.useCase.CoefficientCalculate

import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.EditTextModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.StringModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.AgeCalculateInterface

class CalculateUseCase(private var ageCalculateInterface: AgeCalculateInterface) {
    fun execute(edit: EditTextModelDomain, coefficient: CoefficientModelDomain): StringModelDomain {
        return ageCalculateInterface.calculate(edit=edit, coefficient = coefficient)
    }
}