package com.dose_calculator.x_ray_total_dose.data.repository.repositoryGetAndClear

import com.dose_calculator.x_ray_total_dose.data.sh.DoseShPrStorageInterface
import com.dose_calculator.x_ray_total_dose.data.models.GetAndClearStorageModels.SaveDoseModelStorage
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.SaveModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetResultModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.SaveDeleteInterface

class SaveDeleteImpl (private val doseShPrStorageInterface: DoseShPrStorageInterface):SaveDeleteInterface {

    override fun saveDose(saveDose: SaveModelDomain): GetResultModelDomain {
        val saveDoseModelStorage = SaveDoseModelStorage(saveDose = saveDose.saveResult)
        val resultSave = doseShPrStorageInterface.save(saveDoseModelStorage = saveDoseModelStorage)
        return GetResultModelDomain(getResultSave = resultSave.getDose)
    }

    override fun deleteDose(): GetResultModelDomain {
        val clearDose = doseShPrStorageInterface.delete()
        return GetResultModelDomain(getResultSave = clearDose.getDose)
    }
}