package com.dose_calculator.x_ray_total_dose.data.repository.repositoryCoefficient

import com.dose_calculator.x_ray_total_dose.data.coefficient.CoefficientCalculateInterface
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientDoubleListModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientAgeGroupModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.EditTextModelStorage
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientAgeGroupModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.StringModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.EditTextModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.AgeCalculateInterface

class AgeCalculateImpl(private val coefficientCalculateInterface: CoefficientCalculateInterface):AgeCalculateInterface {

    override fun coefficient(coefficient: CoefficientAgeGroupModelDomain): CoefficientModelDomain {

        val ageGroupByte = CoefficientAgeGroupModelStorage(coefficient = coefficient.coefficient)
        val ageGroupInt = ageGroupByte.coefficient.toString().toInt()

        var headNeck = 1.0
        var head = 1.0
        var neck = 1.0
        var chest = 1.0
        var abdomenPelvis = 1.0
        var trunk = 1.0

        when (ageGroupInt) {
            0 -> {
                headNeck = 1.0
                head = 1.0
                neck = 1.0
                chest = 1.0
                abdomenPelvis = 1.0
                trunk = 1.0
            }

            1 -> {
                headNeck = 1.35484
                head = 1.523809
                neck = 1.338983
                chest = 0.9285714
                abdomenPelvis = 1.0
                trunk = 0.9333333
            }
            2 -> {
                headNeck = 1.8387
                head = 1.90476
                neck = 1.864406
                chest = 1.2857142
                abdomenPelvis = 1.333333
                trunk = 1.2666666
            }
            3 -> {
                headNeck = 2.741935
                head = 3.190476
                neck = 2.033898
                chest = 1.8571428
                abdomenPelvis = 2.0
                trunk = 1.86666666
            }
            4 -> {
                headNeck = 4.1935483
                head = 5.238095
                neck = 2.8813559
                chest = 2.7857142
                abdomenPelvis = 3.2666666
                trunk = 2.9333333
            }
        }

        val coefficientListDouble: ArrayList<Double> = ArrayList<Double>().apply {
            add(0, headNeck)
            add(1, head)
            add(2, neck)
            add(3, chest)
            add(4, abdomenPelvis)
            add(5, trunk)
        }

        val coefficientListModelStorage =
            CoefficientDoubleListModelStorage(coefficientDoubleList = coefficientListDouble)

        val coefficientStorage =
            coefficientCalculateInterface.coefficientAge(coefficientArrayListModelStorage = coefficientListModelStorage)
        return CoefficientModelDomain(coefficientDouble = coefficientStorage.coefficientDouble)
    }

    override fun calculate(
        edit: EditTextModelDomain,
        coefficient: CoefficientModelDomain
    ): StringModelDomain {

        val coefficientList =
            CoefficientModelStorage(coefficientDouble = coefficient.coefficientDouble)
        val editList = EditTextModelStorage(editTexts = edit.editTexts)
        val resultEditArray =
            coefficientCalculateInterface.calculate(
                editTextModelStorage = editList,
                coefficient = coefficientList
            )
        return StringModelDomain(sum = resultEditArray.sum)
    }
}