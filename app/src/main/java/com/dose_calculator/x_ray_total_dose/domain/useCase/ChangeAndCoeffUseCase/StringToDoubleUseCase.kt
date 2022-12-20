package com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase

import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientArrayDoubleModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.EditTextStringArrayModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.StringModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.StDInterface

class StringToDoubleUseCase(private var stDInterface: StDInterface) {
    fun execute(edit: EditTextStringArrayModelDomain, coef: CoefficientArrayDoubleModelDomain): StringModelDomain {
        return stDInterface.change(edit=edit, coef = coef)
    }
}