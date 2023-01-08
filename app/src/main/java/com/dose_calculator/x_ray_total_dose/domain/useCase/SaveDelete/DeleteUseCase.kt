package com.dose_calculator.x_ray_total_dose.domain.useCase.SaveDelete

import com.dose_calculator.x_ray_total_dose.domain.models.SaveDeleteDomainModels.GetResultModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.SaveDeleteInterface

class DeleteUseCase(private var saveDeleteInterface: SaveDeleteInterface) {
    fun execute(): GetResultModelDomain {
        return saveDeleteInterface.deleteDose()
    }
}