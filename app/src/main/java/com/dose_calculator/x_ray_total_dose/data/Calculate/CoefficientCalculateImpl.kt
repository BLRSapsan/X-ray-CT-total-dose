package com.dose_calculator.x_ray_total_dose.data.Calculate

import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.CoefficientModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.CoefficientDoubleListModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.EditTextModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.StringModelStorage
import com.dose_calculator.x_ray_total_dose.data.repository.CoefficientCalculateRepStorage.EditTextToDouble
import java.text.DecimalFormat

class CoefficientCalculateImpl:CoefficientCalculateInterface {

    override fun coefficientAge(coefficientArrayListModelStorage: CoefficientDoubleListModelStorage): CoefficientModelStorage {
        return CoefficientModelStorage(coefficientDouble = coefficientArrayListModelStorage.coefficientDoubleList)
    }

    override fun calculate(
        editTextModelStorage: EditTextModelStorage,
        coefficient: CoefficientModelStorage
    ): StringModelStorage {

        val coHeadNeck = coefficient.coefficientDouble[0]
        val coHead = coefficient.coefficientDouble[1]
        val coNeck = coefficient.coefficientDouble[2]
        val coChest = coefficient.coefficientDouble[3]
        val coAbdomenPelvis = coefficient.coefficientDouble[4]
        val coTrunk = coefficient.coefficientDouble[5]

        val editTextToDouble = EditTextToDouble()
        val massiveDouble = editTextToDouble.modify(editTexts = editTextModelStorage.editTexts)
        val headNeck: Double = massiveDouble[0] * 0.0031 * coHeadNeck
        val head: Double = massiveDouble[1] * 0.0021 * coHead
        val neck: Double = massiveDouble[2] * 0.0059 * coNeck
        val chest: Double = massiveDouble[3] * 0.014 * coChest
        val abdomenPelvis: Double = massiveDouble[4] * 0.015 * coAbdomenPelvis
        val trunk: Double = massiveDouble[5] * 0.015 * coTrunk
        val sumDoseDouble = headNeck + head + neck + chest + abdomenPelvis + trunk
        val format = DecimalFormat("#.###").format(sumDoseDouble)
        val sumDoseSting = format.toString()
        return StringModelStorage(sumDoseSting)
    }
}