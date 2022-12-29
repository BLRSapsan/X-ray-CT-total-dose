package com.dose_calculator.x_ray_total_dose.domain.useCase.SaveDelete

import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.SaveModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetResultModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.SaveDeleteInterface

class SaveUseCase (private var saveDeleteInterface:SaveDeleteInterface) {
    fun execute(saveResult: SaveModelDomain): GetResultModelDomain {
        return saveDeleteInterface.saveDose(saveDose = saveResult)
    }
}