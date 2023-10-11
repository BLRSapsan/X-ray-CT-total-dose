package com.dose_calculator.x_ray_total_dose.skf.domainSKF.useCase_skf

import android.widget.EditText
import com.dose_calculator.x_ray_total_dose.skf.domainSKF.repository_skf.SKFCalculateInterface

class CalculateSkfUseCase (private var skfCalculateInterface: SKFCalculateInterface) {
    operator fun invoke (sexWM:Int, array:ArrayList<EditText>): String {
        return skfCalculateInterface.calculate (sexWM = sexWM, arrayEditText = array)
    }
}