package com.dose_calculator.x_ray_total_dose.data.Calculate

import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.CoefficientModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.CoefficientListModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.EditTextModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.StringModelStorage
import com.dose_calculator.x_ray_total_dose.data.repository.CoefficientCalculateRepStorage.EditTextToDouble
import java.text.DecimalFormat

class CoefficientCalculateImpl:CoefficientCalculateInterface {

    override fun coefficientAge(coefficientListModelStorage: CoefficientListModelStorage): CoefficientModelStorage {
        return CoefficientModelStorage(coefficientDouble = coefficientListModelStorage.coefficientDoubleList)
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
        val coCoxae = coefficient.coefficientDouble[6]
        val coKnee = coefficient.coefficientDouble[7]
        val coCrus = coefficient.coefficientDouble[8]

        val editTextToDouble = EditTextToDouble()
        val massiveDouble = editTextToDouble.modify(editTexts = editTextModelStorage.editTexts)
        val headNeck: Double = massiveDouble[0] * 0.0031 * coHeadNeck
        val head: Double = massiveDouble[1] * 0.0021 * coHead
        val neck: Double = massiveDouble[2] * 0.0059 * coNeck
        val chest: Double = massiveDouble[3] * 0.014 * coChest
        val abdomenPelvis: Double = massiveDouble[4] * 0.015 * coAbdomenPelvis
        val trunk: Double = massiveDouble[5] * 0.015 * coTrunk
        val coxae: Double = massiveDouble[6] * 0.011 * coCoxae
        val knee: Double = massiveDouble[7] * 0.0004 * coKnee
        val crus: Double = massiveDouble[8] * 0.0002 * coCrus
        val sumDoseDouble = headNeck + head + neck + chest + abdomenPelvis + trunk + coxae + knee + crus
        val format = DecimalFormat("#.###").format(sumDoseDouble)
        val sumDoseSting = format.toString()
        return StringModelStorage(sumDoseSting)
    }
}