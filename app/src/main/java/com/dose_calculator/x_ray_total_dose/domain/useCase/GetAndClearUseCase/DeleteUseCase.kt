package com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase

import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetResultModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.SaveDeleteInterface

class DeleteUseCase(private var repositoryInterface: SaveDeleteInterface) {
    fun execute(): GetResultModelDomain {
        return repositoryInterface.deleteDose()
    }
}