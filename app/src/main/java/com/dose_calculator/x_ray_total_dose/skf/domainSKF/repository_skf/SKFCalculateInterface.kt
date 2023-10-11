package com.dose_calculator.x_ray_total_dose.skf.domainSKF.repository_skf

import android.widget.EditText

interface
SKFCalculateInterface {
    fun calculate (sexWM:Int, arrayEditText:ArrayList<EditText>): String
}