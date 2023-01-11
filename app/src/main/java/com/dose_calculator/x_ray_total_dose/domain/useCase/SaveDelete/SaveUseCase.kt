package com.dose_calculator.x_ray_total_dose.domain.useCase.SaveDelete

import com.dose_calculator.x_ray_total_dose.domain.models.SaveDeleteDomainModels.SaveModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.SaveDeleteDomainModels.GetResultModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.SaveDeleteInterface

class SaveUseCase (private var saveDeleteInterface:SaveDeleteInterface) {
    operator fun invoke (saveResult: SaveModelDomain): GetResultModelDomain {
        return saveDeleteInterface.saveDose(saveDose = saveResult)
    }
}