package com.seljabali.intentsbeforeaction.showCasing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import com.seljabali.library.intents.*
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
        activity?.startActivity(Intents.getSettings())
    }

    private fun onShowApnSettingsClickListener() {
        activity?.startActivity(Intents.getApnSettings())
    }

    private fun onShowWirelessSettingsClickListener() {
        activity?.startActivity(Intents.getWirelessSettings())
    }

    private fun onShowAirplaneModeSettingsClickListener() {
        activity?.startActivity(Intents.getAirplaneModeSettings())
    }

    private fun onShowAccessibilitySettingsClickListener() {
        activity?.startActivity(Intents.getAccessibilitySettings())
    }

    private fun onShowUsageSettingsClickListener() {
        activity?.startActivity(Intents.getUsageSettings())
    }

    private fun onShowSecuritySettingsClickListener() {
        activity?.startActivity(Intents.getSecuritySettings())
    }

    private fun onShowPrivacySettingsClickListener() {
        activity?.startActivity(Intents.getPrivacySettings())
    }

    private fun onShowLocationServicesClickListener() {
        activity?.startActivity(Intents.getLocationServicesSettings())
    }
}