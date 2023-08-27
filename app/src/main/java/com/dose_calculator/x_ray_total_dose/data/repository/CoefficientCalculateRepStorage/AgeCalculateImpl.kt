package com.dose_calculator.x_ray_total_dose.data.repository.CoefficientCalculateRepStorage

import com.dose_calculator.x_ray_total_dose.data.Calculate.CoefficientCalculateInterface
import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.CoefficientModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.CoefficientListModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.CoefficientAgeGroupModelStorage
import com.dose_calculator.x_ray_total_dose.data.models.CoefficientCalculateStorageModels.EditTextModelStorage
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.CoefficientAgeGroupModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.StringModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.EditTextModelDomain
import com.dose_calculator.x_ray_total_dose.domain.repository.AgeCalculateInterface

class AgeCalculateImpl(private val coefficientCalculateInterface: CoefficientCalculateInterface):AgeCalculateInterface {

    override fun coefficient(coefficient: CoefficientAgeGroupModelDomain): CoefficientModelDomain {

        val ageGroupByte = CoefficientAgeGroupModelStorage(coefficient = coefficient.coefficient)
        val ageGroupInt = ageGroupByte.coefficient.toString().toInt()

        val bodyCoefficient: List<Pair<Int, BodyCoefficient>> = listOf( //BodyCoefficient-data-class с параметрами
            0 to BodyCoefficient(
                headNeck = 1.0,
                head = 1.0,
                neck = 1.0,
                chest = 1.0,
                abdomenPelvis = 1.0,
                trunk = 1.0,
                coxae = 1.0,
                knee = 1.0,
                crus = 1.0
            ),

            1 to BodyCoefficient(
                headNeck = 1.35484,
                head = 1.523809,
                neck = 1.338983,
                chest = 0.9285714,
                abdomenPelvis = 1.0,
                trunk = 0.9333333,
                coxae = 1.1818181818,
                knee = 1.25,
                crus = 1.5
            ),
            2 to BodyCoefficient(
                headNeck = 1.8387,
                head = 1.90476,
                neck = 1.864406,
                chest = 1.2857142,
                abdomenPelvis = 1.333333,
                trunk = 1.2666666,
                coxae = 2.0,
                knee = 2.0,
                crus = 1.5
            ),
            3 to BodyCoefficient(
                headNeck = 2.741935,
                head = 3.190476,
                neck = 2.033898,
                chest = 1.8571428,
                abdomenPelvis = 2.0,
                trunk = 1.86666666,
                coxae = 2.5454545454,
                knee = 3.0,
                crus = 2.0
            ),
            4 to BodyCoefficient(
                headNeck = 4.1935483,
                head = 5.238095,
                neck = 2.8813559,
                chest = 2.7857142,
                abdomenPelvis = 3.2666666,
                trunk = 2.9333333,
                coxae = 3.72727272,
                knee = 5.5,
                crus = 4.5
            )
        )

        val getBodyCoefficient: BodyCoefficient = bodyCoefficient[ageGroupInt].second
        //second используется при создании списка с помощью Pair, означает обращение ко 2 параметру
        val bodyList: ArrayList<Double> = ArrayList<Double>().apply {
            add(getBodyCoefficient.headNeck)
            add(getBodyCoefficient.head)
            add(getBodyCoefficient.neck)
            add(getBodyCoefficient.chest)
            add(getBodyCoefficient.abdomenPelvis)
            add(getBodyCoefficient.trunk)
            add(getBodyCoefficient.coxae)
            add(getBodyCoefficient.knee)
            add(getBodyCoefficient.crus)
        }

        val coefficientListModelStorage = //закидываю созданный список с параметрами в модель папки storage
            CoefficientListModelStorage(coefficientDoubleList = bodyList)
        val coefficientStorage =
            coefficientCalculateInterface.coefficientAge(coefficientListModelStorage = coefficientListModelStorage)
        return CoefficientModelDomain(coefficientDouble = coefficientStorage.coefficientDouble)
    }

    override fun calculate( //переключение с domain на storage
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