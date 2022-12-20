package com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase

import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetDoseModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.RepositoryInterface

class ClearUseCase(private var repositoryInterface: RepositoryInterface) {
    fun execute(): GetDoseModelDomain {
        return repositoryInterface.clearDose()
    }
}