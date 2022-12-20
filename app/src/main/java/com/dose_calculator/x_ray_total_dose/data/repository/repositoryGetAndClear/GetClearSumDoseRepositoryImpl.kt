package com.dose_calculator.x_ray_total_dose.data.repository.repositoryGetAndClear

import com.dose_calculator.x_ray_total_dose.data.sh.DoseStorage
import com.dose_calculator.x_ray_total_dose.data.models.GetAndClearStorageModels.SaveDoseModelStorage
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.CalculateModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetDoseModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.RepositoryInterface

class GetClearSumDoseRepositoryImpl (private val doseStorage: DoseStorage):RepositoryInterface {

    override fun sumDose(calculate: CalculateModelDomain): GetDoseModelDomain {
        val doseSave = SaveDoseModelStorage(saveDose = calculate.totalDose)
        val resultSave = doseStorage.save(doseModelStorage = doseSave)
        val doseGet = GetDoseModelDomain(executeString = resultSave.getDose)
        return doseGet
    }

    override fun clearDose(): GetDoseModelDomain {
        val clearDose = doseStorage.clear()
        return GetDoseModelDomain(executeString = clearDose.getDose)
    }
}