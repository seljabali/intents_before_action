package com.seljabali.intentsbeforeaction

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.showCasing.GoogleMapsAppFragment
import com.seljabali.intentsbeforeaction.showCasing.GoogleMapsWebFragment
import com.seljabali.intentsbeforeaction.showCasing.SystemSettingsFragment
import kotlinx.android.synthetic.main.fragment_intents_show_casing.*

class IntentsShowCasingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_intents_show_casing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnGoogleMapsApp.setOnClickListener(onGoogleMapsAppClickListener())
        btnGoogleMapsWeb.setOnClickListener(onGoogleMapsWebClickListener())
        btnSystemSettings.setOnClickListener(onSystemSettingsClickListener())
    }

    private fun startFragment(fragment: Fragment, tag: String) {
        activity!!.supportFragmentManager
                .beginTransaction()
                .add(R.id.fl_main, fragment, tag)
                .addToBackStack(null)
                .commit()
    }

    private fun onGoogleMapsAppClickListener(): View.OnClickListener? {
        return View.OnClickListener { startFragment(GoogleMapsAppFragment(), GoogleMapsAppFragment.getTag()) }
    }

    private fun onGoogleMapsWebClickListener(): View.OnClickListener? {
        return View.OnClickListener { startFragment(GoogleMapsWebFragment(), GoogleMapsWebFragment.getTag()) }
    }

    private fun onSystemSettingsClickListener(): View.OnClickListener? {
        return View.OnClickListener { startFragment(SystemSettingsFragment(), SystemSettingsFragment.getTag()) }
    }
}
