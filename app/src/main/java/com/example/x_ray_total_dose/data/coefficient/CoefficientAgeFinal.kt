package com.example.x_ray_total_dose.data.coefficient

import com.example.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientArrayDoubleModelStorage
import com.example.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientArrayListModelStorage
import com.example.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.EditArrayModelStorage
import com.example.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.StringModelStorage
import com.example.x_ray_total_dose.data.repository.repositoryCoefficient.EditTextToDoubleTrans
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
        val coChest = coef.coefficientArrayDouble[1]
        val coAbdomenPelvis = coef.coefficientArrayDouble[2]

        val editTextToDoubleTrans = EditTextToDoubleTrans()
        val massiveDouble = editTextToDoubleTrans.modify(e = editArrayModelStorage.editArray)
        val head: Double = massiveDouble[0] * 0.0023 * coHeadNeck
        val neck: Double = massiveDouble[1] * 0.0054 * coHeadNeck
        val chest: Double = massiveDouble[2] * 0.017 * coChest
        val abdomen: Double = massiveDouble[3] * 0.015 * coAbdomenPelvis
        val pelvis: Double = massiveDouble[4] * 0.019 * coAbdomenPelvis
        val sumDoseDouble = head + neck + chest + abdomen + pelvis
        val format = DecimalFormat("#.###").format(sumDoseDouble)
        val sumDoseSting = format.toString()
        return StringModelStorage(sumDoseSting)
    }
}