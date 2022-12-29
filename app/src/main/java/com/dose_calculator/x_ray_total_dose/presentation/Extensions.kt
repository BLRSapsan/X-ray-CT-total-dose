package com.dose_calculator.x_ray_total_dose.presentation

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

//для скрытия клавиатуры при нажатии на кнопку calculateDoseButton
fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}