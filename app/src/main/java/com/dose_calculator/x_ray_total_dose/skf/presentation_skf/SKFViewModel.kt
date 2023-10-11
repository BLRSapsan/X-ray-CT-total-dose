package com.dose_calculator.x_ray_total_dose.skf.presentation_skf

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dose_calculator.x_ray_total_dose.skf.domainSKF.useCase_skf.CalculateSkfUseCase

class SKFViewModel (private val calculateSkfUseCase: CalculateSkfUseCase): androidx.lifecycle.ViewModel() {


    private var skf_value_lock= MutableLiveData<String>()
    var skf_value_open:LiveData<String> = skf_value_lock

    fun calculate_skf (sexWM:Int, array:ArrayList<EditText>) {
        val result: String = calculateSkfUseCase(sexWM = sexWM, array = array)
        skf_value_lock.value = result
    }
}