package com.seljabali.intentsbeforeaction.showCasing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import com.seljabali.intentsbeforeaction.intents.systemSettings.getLocationServicesSettings
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
    }

    private fun onShowLocationServicesClickListener() {
        activity?.startActivity(getLocationServicesSettings())
    }
}