package com.dose_calculator.x_ray_total_dose.data.coefficient

import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientArrayDoubleModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientArrayListModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.EditArrayModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.StringModelStorage
import com.dose_calculator.x_ray_total_dose.data.repository.repositoryCoefficient.EditTextToDoubleTrans
import java.text.DecimalFormat

class CoefficientAgeFinal:CoefficientInterface {

    override fun coefficientAge(coefficientArrayListModelStorage: CoefficientArrayListModelStorage): CoefficientArrayDoubleModelStorage {
        return CoefficientArrayDoubleModelStorage(coefficientArrayDouble = coefficientArrayListModelStorage.coefficientArray)
    }

    override fun change(
        editArrayModelStorage: EditArrayModelStorage,
        coef: CoefficientArrayDoubleModelStorage
    ): StringModelStorage {

        val coHeadNeck = coef.coefficientArrayDouble[0]
        val coHead = coef.coefficientArrayDouble[1]
        val coNeck = coef.coefficientArrayDouble[2]
        val coChest = coef.coefficientArrayDouble[3]
        val coAbdomenPelvis = coef.coefficientArrayDouble[4]
        val coTrunk = coef.coefficientArrayDouble[5]

        val editTextToDoubleTrans = EditTextToDoubleTrans()
        val massiveDouble = editTextToDoubleTrans.modify(e = editArrayModelStorage.editArray)
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