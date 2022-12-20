package com.dose_calculator.x_ray_total_dose.data.repository.repositoryCoefficient

import com.dose_calculator.x_ray_total_dose.data.coefficient.CoefficientInterface
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientArrayDoubleModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientArrayListModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientByteModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.EditArrayModelStorage
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientArrayDoubleModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.StringModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.EditTextStringArrayModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.StDInterface

class ChangeDataReposImpl(private val coefficientInterface: CoefficientInterface):StDInterface {

    override fun coeff(coefficient: CoefficientModelDomain): CoefficientArrayDoubleModelDomain {

        val cAgeInput = CoefficientByteModelStorage(coefficient = coefficient.coefficientAge)
        val cAgeInputInt = cAgeInput.coefficient.toString().toInt()

        var headNeck = 1.0
        var head = 1.0
        var neck = 1.0
        var chest = 1.0
        var abdomenPelvis = 1.0
        var trunk = 1.0

        when (cAgeInputInt) {
            0 -> { headNeck = 1.0
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

        val coefficientArrayList: ArrayList<Double> = ArrayList()
        coefficientArrayList.add(0, headNeck)
        coefficientArrayList.add(1, head)
        coefficientArrayList.add(2, neck)
        coefficientArrayList.add(3, chest)
        coefficientArrayList.add(4, abdomenPelvis)
        coefficientArrayList.add(5, trunk)

        val coefficientArrayListModelStorage =
            CoefficientArrayListModelStorage(coefficientArray = coefficientArrayList)

        val resultCoeff = coefficientInterface.coefficientAge(coefficientArrayListModelStorage = coefficientArrayListModelStorage)
        return CoefficientArrayDoubleModelDomain(coefficientArrayDouble = resultCoeff.coefficientArrayDouble)
    }

    override fun change(edit: EditTextStringArrayModelDomain, coef: CoefficientArrayDoubleModelDomain): StringModelDomain {

        val coefArray = CoefficientArrayDoubleModelStorage(coefficientArrayDouble = coef.coefficientArrayDouble)
        val editArray = EditArrayModelStorage(editArray = edit.arrayString)
        val resultEditArray = coefficientInterface.change(editArrayModelStorage = editArray, coef = coefArray)
        return StringModelDomain(summa = resultEditArray.doseSumma)
    }
}