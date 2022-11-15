package com.example.x_ray_total_dose.data.repository.repositoryCoefficient

import com.example.x_ray_total_dose.data.coefficient.CoefficientInterface
import com.example.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientArrayDoubleModelStorage
import com.example.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientArrayListModelStorage
import com.example.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.CoefficientByteModelStorage
import com.example.x_ray_total_dose.data.models.ChangeAndCoeffStorageModels.EditArrayModelStorage
import com.example.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientArrayDoubleModelDomain
import com.example.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.example.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.StringModelDomain
import com.example.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.EditTextStringArrayModelDomain
import com.example.x_ray_total_dose.domain.repository.StDInterface

class ChangeDataReposImpl(private val coefficientInterface: CoefficientInterface):StDInterface {

    override fun coeff(coefficient: CoefficientModelDomain): CoefficientArrayDoubleModelDomain {

        val cAgeInput = CoefficientByteModelStorage(coefficient = coefficient.coefficientAge)
        val cAgeInputInt = cAgeInput.coefficient.toString().toInt()

        var headNeck = 1.0
        var chest = 1.0
        var abdomenPelvis = 1.0

        when (cAgeInputInt) {
            0 -> { headNeck = 1.0
                chest = 1.0
                abdomenPelvis = 1.0
            }

            1 -> {
                headNeck = 1.1
                chest = 1.1
                abdomenPelvis = 1.1
            }
            2 -> {
                headNeck = 1.2
                chest = 1.2
                abdomenPelvis = 1.4
            }
            3 -> {
                headNeck = 1.6
                chest = 1.4
                abdomenPelvis = 1.4
            }
            4 -> {
                headNeck = 2.2
                chest = 1.5
                abdomenPelvis = 1.6
            }
            5 -> {
                headNeck = 2.4
                chest = 1.8
                abdomenPelvis = 2.0
            }
        }

        val coefficientArrayList: ArrayList<Double> = ArrayList()
        coefficientArrayList.add(0, headNeck)
        coefficientArrayList.add(1, chest)
        coefficientArrayList.add(2, abdomenPelvis)

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