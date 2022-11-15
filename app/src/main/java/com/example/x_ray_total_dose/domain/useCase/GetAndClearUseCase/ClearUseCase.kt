package com.example.x_ray_total_dose.domain.useCase.GetAndClearUseCase

import com.example.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetDoseModelDomain
import com.example.x_ray_total_dose.domain.repository.RepositoryInterface

class ClearUseCase(private var repositoryInterface: RepositoryInterface) {
    fun execute(): GetDoseModelDomain {
        return repositoryInterface.clearDose()
    }
}