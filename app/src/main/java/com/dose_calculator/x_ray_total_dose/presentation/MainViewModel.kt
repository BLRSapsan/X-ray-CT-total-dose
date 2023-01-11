package com.dose_calculator.x_ray_total_dose.presentation

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.CoefficientModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.CoefficientAgeGroupModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.EditTextModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.CoefficientCalculateDomainModels.StringModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.SaveDeleteDomainModels.SaveModelDomain
import com.dose_calculator.x_ray_total_dose.domain.models.SaveDeleteDomainModels.GetResultModelDomain
import com.dose_calculator.x_ray_total_dose.domain.useCase.CoefficientCalculate.CoefficientUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.CoefficientCalculate.CalculateUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.SaveDelete.SaveUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.SaveDelete.DeleteUseCase

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
        val returnListCoefficient:CoefficientModelDomain = coefficientUseCase(coefficientAgeGroup = coefficientAgeGroup)

        //обработка EditText, получить обратно string
        val editText = EditTextModelDomain(editTexts = array)
        val resultString: StringModelDomain = calculateUseCase(edit = editText, coefficient = returnListCoefficient)

        //сохранить результат и вывести его на экран
        val saveModelDomain = SaveModelDomain(saveResult = resultString.sum)
        val result: GetResultModelDomain = saveUseCase(saveResult = saveModelDomain)
        resultLive.value = result.getResultSave
    }

    fun deleteValues() {
        val result: GetResultModelDomain = deleteUseCase()
        resultLive.value = result.getResultSave
    }
}