package com.dose_calculator.x_ray_total_dose.domain.useCase.CoefficientCalculate

import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.EditTextModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.StringModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.AgeCalculateInterface

class CalculateUseCase(private var ageCalculateInterface: AgeCalculateInterface) {
    operator fun invoke (edit: EditTextModelDomain, coefficient: CoefficientModelDomain): StringModelDomain {
        return ageCalculateInterface.calculate(edit=edit, coefficient = coefficient)
    }
}