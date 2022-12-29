package com.dose_calculator.x_ray_total_dose.data.repository.SaveDeleteRepStorage

import com.dose_calculator.x_ray_total_dose.data.SharedPref.DoseShPrStorageInterface
import com.dose_calculator.x_ray_total_dose.data.models.SaveDeleteStorageModels.SaveDoseModelStorage
import com.dose_calculator.x_ray_total_dose.domain.models.SaveDeleteDomainModels.SaveModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.SaveDeleteDomainModels.GetResultModelDomain
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