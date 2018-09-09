package com.seljabali.intentsbeforeaction.showCasing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import com.seljabali.intentsbeforeaction.intents.*
import kotlinx.android.synthetic.main.fragment_system_settings.*

class SystemSettingsFragment: Fragment() {

    companion object {
        fun getTag(): String {
            return SystemSettingsFragment::class.java.simpleName
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_system_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnShowLocationServices.setOnClickListener { onShowLocationServicesClickListener() }
        btnShowPrivacySettings.setOnClickListener { onShowPrivacySettingsClickListener() }
        btnShowSecuritySettings.setOnClickListener { onShowSecuritySettingsClickListener() }
        btnShowUsageSettings.setOnClickListener { onShowUsageSettingsClickListener() }
        btnShowAccessibilitySettings.setOnClickListener { onShowAccessibilitySettingsClickListener() }
        btnShowAirplaneModeSettings.setOnClickListener { onShowAirplaneModeSettingsClickListener() }
        btnShowWirelessSettings.setOnClickListener { onShowWirelessSettingsClickListener() }
        btnShowApnSettings.setOnClickListener { onShowApnSettingsClickListener() }
        btnShowSettings.setOnClickListener { onShowSettingsClickListener() }
    }

    private fun onShowSettingsClickListener() {
        activity?.startActivity(getSettings())
    }

    private fun onShowApnSettingsClickListener() {
        activity?.startActivity(getApnSettings())
    }

    private fun onShowWirelessSettingsClickListener() {
        activity?.startActivity(getWirelessSettings())
    }

    private fun onShowAirplaneModeSettingsClickListener() {
        activity?.startActivity(getAirplaneModeSettings())
    }

    private fun onShowAccessibilitySettingsClickListener() {
        activity?.startActivity(getAccessibilitySettings())
    }

    private fun onShowUsageSettingsClickListener() {
        activity?.startActivity(getUsageSettings())
    }

    private fun onShowSecuritySettingsClickListener() {
        activity?.startActivity(getSecuritySettings())
    }

    private fun onShowPrivacySettingsClickListener() {
        activity?.startActivity(getPrivacySettings())
    }

    private fun onShowLocationServicesClickListener() {
        activity?.startActivity(getLocationServicesSettings())
    }
}