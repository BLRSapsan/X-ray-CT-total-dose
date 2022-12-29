package com.dose_calculator.x_ray_total_dose.presentation

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientAgeGroupModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.EditTextModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.StringModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.SaveModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.GetAndClearDomainModels.GetResultModelDomain
import com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase.CoefficientUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase.CalculateUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase.SaveUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase.DeleteUseCase

class MainViewModel(private val saveUseCase: SaveUseCase,
                    private val deleteUseCase: DeleteUseCase,
                    private val calculateUseCase: CalculateUseCase,
                    private val coefficientUseCase: CoefficientUseCase): androidx.lifecycle.ViewModel() {

    // var resultLive private чтобы нельзя было его изменить в MainActivity
    private var resultLive = MutableLiveData<String>()
    var openResultValue: LiveData<String> = resultLive

    fun calculate(array: ArrayList<EditText>, coefficient: Byte) {

        //Обработка коэффициента
        val coefficientAgeGroup = CoefficientAgeGroupModelDomain(coefficient = coefficient)
        val returnListCoefficient:CoefficientModelDomain = coefficientUseCase.execute(coefficientAgeGroup = coefficientAgeGroup)

        //обработка EditText, получить обратно string
        val editText = EditTextModelDomain(editTexts = array)
        val resultString: StringModelDomain = calculateUseCase.execute(edit = editText, coefficient = returnListCoefficient)

        //сохранить результат и вывести его на экран
        val saveModelDomain = SaveModelDomain(saveResult = resultString.sum)
        val result: GetResultModelDomain = saveUseCase.execute(saveResult = saveModelDomain)
        resultLive.value = result.getResultSave
    }

    fun deleteValues() {
        val result: GetResultModelDomain = deleteUseCase.execute()
        resultLive.value = result.getResultSave
    }
}