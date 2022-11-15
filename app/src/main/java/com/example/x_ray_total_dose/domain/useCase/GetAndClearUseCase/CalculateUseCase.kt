package com.example.x_ray_total_dose.domain.useCase.GetAndClearUseCase

import com.example.x_ray_total_dose.domain.models.GetAndClearDomainModels.CalculateModelDomain
import com.example.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetDoseModelDomain
import com.example.x_ray_total_dose.domain.repository.RepositoryInterface

class CalculateUseCase (private var repositoryInterface:RepositoryInterface) {
    fun execute(calculate: CalculateModelDomain): GetDoseModelDomain {
        return repositoryInterface.sumDose(calculate = calculate)
    }
}