package com.seljabali.intentsbeforeaction.showCasing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.IntentsShowCasingActivity
import com.seljabali.intentsbeforeaction.R
import com.seljabali.intentsbeforeaction.intents.createShortCut
import com.seljabali.intentsbeforeaction.intents.getLaunchAppIntent
import kotlinx.android.synthetic.main.fragment_app.*

class AppFragment: Fragment() {

    companion object {
        fun getTag(): String {
            return AppFragment::class.java.simpleName
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_app, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnClearPackageName.setOnClickListener { onClearPackageNameClickListener() }
        btnLaunchApp.setOnClickListener { onLaunchAppClickListener() }
        btnCreateShortcut.setOnClickListener { onCreateShortcutClickListener() }
    }

    private fun onClearPackageNameClickListener() {
        etAppPackage.setText("")
    }

    private fun onCreateShortcutClickListener() {
        createShortCut(context!!, activity as IntentsShowCasingActivity, null, null)
    }

    private fun onLaunchAppClickListener() {
        context!!.startActivity(getLaunchAppIntent(context!!, getAppPackageName()))
    }

    private fun getAppPackageName(): String {
        return etAppPackage.text.toString()
    }
}