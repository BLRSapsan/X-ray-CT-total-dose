package com.dose_calculator.x_ray_total_dose.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dose_calculator.x_ray_total_dose.skf.presentation_skf.SKFFragment

class ViewPager (fa:FragmentActivity):FragmentStateAdapter (fa) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DoseFragment()
            else -> SKFFragment()
        }
    }
}