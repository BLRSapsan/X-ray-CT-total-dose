package com.dose_calculator.x_ray_total_dose.presentation

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientArrayDoubleModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.EditTextStringArrayModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.StringModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.CalculateModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetDoseModelDomain
import com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase.CoefficientYearsUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase.StringToDoubleUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase.CalculateUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase.ClearUseCase

class MainViewModel(private val calculateUseCase: CalculateUseCase,
                    private val clearUseCase: ClearUseCase,
                    private val stringToDoubleUseCase: StringToDoubleUseCase,
                    private val coefficientYearsUseCase: CoefficientYearsUseCase): androidx.lifecycle.ViewModel() {

    // var resultLive private чтобы нельзя было его изменить в MainActivity
    private var resultLive = MutableLiveData<String>()
    var openResultValue: LiveData<String> = resultLive

    fun sum(array: ArrayList<EditText>, coefficientAge: Byte) {

        //Обработка коэффициента
        val coefficientDose = CoefficientModelDomain(coefficientAge = coefficientAge)
        val resultCoefficient:CoefficientArrayDoubleModelDomain = coefficientYearsUseCase.execute(coeff = coefficientDose)

        //обработка array EditText и получить обратно string
        val params = EditTextStringArrayModelDomain(arrayString = array)
        val resultParams: StringModelDomain = stringToDoubleUseCase.execute(edit = params, coef = resultCoefficient)

        //отправить итоговый string и получить конечный результат double
        val calculate = CalculateModelDomain(totalDose = resultParams.summa)
        val result: GetDoseModelDomain = calculateUseCase.execute(calculate = calculate)
        resultLive.value = result.executeString
    }

    fun clear() {
        val result: GetDoseModelDomain = clearUseCase.execute()
        resultLive.value = result.executeString
    }
}