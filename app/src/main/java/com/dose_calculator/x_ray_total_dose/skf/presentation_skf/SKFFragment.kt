package com.dose_calculator.x_ray_total_dose.skf.presentation_skf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.dose_calculator.x_ray_total_dose.R
import com.dose_calculator.x_ray_total_dose.databinding.SkfBinding
import com.dose_calculator.x_ray_total_dose.presentation.hideKeyboard
import org.koin.androidx.viewmodel.ext.android.viewModel

class SKFFragment:Fragment() {

    private var sexWM: Int = 0
    private lateinit var bindingSKF: SkfBinding
    private val skfViewModel by viewModel<SKFViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingSKF = SkfBinding.inflate(inflater, container, false)
        return bindingSKF.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingSKF.radioGroupSex.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.man -> sexWM = 0
                R.id.woman -> sexWM = 1
            }
        }

        val writeNewValues: String = resources.getString(R.string.write_new_values)

        val arraySKF: ArrayList<EditText> = ArrayList<EditText>().apply {
            add(0, bindingSKF.age)
            add(1, bindingSKF.creatinine)
            add(2, bindingSKF.height)
        }

        skfViewModel.skf_value_open.observe(viewLifecycleOwner) {
            bindingSKF.valueSkf.text = it
        }

        bindingSKF.calculateSkf.setOnClickListener {
            it.hideKeyboard()
            skfViewModel.calculate_skf(sexWM = sexWM, array = arraySKF)
        }

        bindingSKF.deleteSkf.setOnClickListener {
            it.hideKeyboard()
            for (clear in arraySKF) {
                clear.text.clear()
            }
            bindingSKF.valueSkf.text = writeNewValues
        }
    }
}