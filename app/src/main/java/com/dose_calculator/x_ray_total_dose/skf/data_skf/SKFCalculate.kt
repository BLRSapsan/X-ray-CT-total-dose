package com.dose_calculator.x_ray_total_dose.skf.data_skf

import android.content.Context
import android.widget.EditText
import com.dose_calculator.x_ray_total_dose.R
import com.dose_calculator.x_ray_total_dose.skf.domainSKF.repository_skf.SKFCalculateInterface
import java.text.DecimalFormat
import kotlin.math.pow
class SKFCalculate(context:Context): SKFCalculateInterface {

    private val enterCreatinine:String = context.resources.getString(R.string.enter_creatinine)
    private val enterHeight = context.resources.getString(R.string.enter_height)
    private val enterAge = context.resources.getString(R.string.enter_age)

    override fun calculate(sexWM: Int, arrayEditText: ArrayList<EditText>): String {
        var skf = 0.0
        val massiveDouble = SKFEditTextToDouble().mod(arrayEditText)
        val age: Double = massiveDouble[0]
        val creatinine: Double = massiveDouble[1]
        val height: Double = massiveDouble[2]
        val answerSKF: String

        when {
            age == 0.0 -> {
                return enterAge
            }

            age > 18 -> {
                if (creatinine == 0.0) return enterCreatinine
                if (sexWM == 0) {
                    skf = if (creatinine <= 80) {
                        141.0 * ((creatinine / 80.0).pow(-0.411)) * (0.993.pow(age))
                    } else 141.0 * ((creatinine / 80.0).pow(-1.209)) * (0.993.pow(age))
                } else if (sexWM == 1) {
                    skf = if (creatinine <= 62) {
                        144.0 * ((creatinine / 62.0).pow(-0.329)) * (0.993.pow(age))
                    } else 144.0 * ((creatinine / 62.0).pow(-1.209)) * (0.993.pow(age))
                }
            }

            age < 18 -> if (height == 0.0) return enterHeight else if (creatinine == 0.0) return enterCreatinine else skf =
                36.5 * height / creatinine
        }
        val format = DecimalFormat("#.##").format(skf)
        answerSKF = format.toString()
        return answerSKF
    }
}