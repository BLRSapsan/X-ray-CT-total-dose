package com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase

import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.CalculateModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetDoseModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.RepositoryInterface

class CalculateUseCase (private var repositoryInterface:RepositoryInterface) {
    fun execute(calculate: CalculateModelDomain): GetDoseModelDomain {
        return repositoryInterface.sumDose(calculate = calculate)
    }
}