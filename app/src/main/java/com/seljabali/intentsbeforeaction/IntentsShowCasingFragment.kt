package com.seljabali.intentsbeforeaction

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.showCasing.*
import kotlinx.android.synthetic.main.fragment_intents_show_casing.*

class IntentsShowCasingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_intents_show_casing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnApp.setOnClickListener { onAppsClickListener() }
        btnGoogleMapsApp.setOnClickListener { onGoogleMapsAppClickListener() }
        btnGoogleMapsWeb.setOnClickListener { onGoogleMapsWebClickListener() }
        btnSystemSettings.setOnClickListener { onSystemSettingsClickListener() }
        btnMedia.setOnClickListener { onMediaClickListener() }
        btnEmail.setOnClickListener { onEmailClickListener() }
        btnStore.setOnClickListener { onStoreClickListener() }
        btnPhone.setOnClickListener { onPhoneClickListener() }
        btnYoutube.setOnClickListener { onYoutubeClickListener() }
    }

    private fun startFragment(fragment: Fragment, tag: String) {
        activity!!.supportFragmentManager
                .beginTransaction()
                .add(R.id.fl_main, fragment, tag)
                .addToBackStack(null)
                .commit()
    }

    private fun onAppsClickListener() {
        startFragment(AppFragment(), AppFragment.getTag())
    }

    private fun onGoogleMapsAppClickListener() {
        startFragment(GoogleMapsAppFragment(), GoogleMapsAppFragment.getTag())
    }

    private fun onGoogleMapsWebClickListener() {
        startFragment(GoogleMapsWebFragment(), GoogleMapsWebFragment.getTag())
    }

    private fun onSystemSettingsClickListener() {
        startFragment(SystemSettingsFragment(), SystemSettingsFragment.getTag())
    }

    private fun onMediaClickListener() {
        startFragment(MediaFragment(), MediaFragment.getTag())
    }

    private fun onEmailClickListener() {
        startFragment(EmailFragment(), EmailFragment.getTag())
    }

    private fun onStoreClickListener() {
        startFragment(StoreFragment(), StoreFragment.getTag())
    }

    private fun onPhoneClickListener() {
        startFragment(PhoneFragment(), PhoneFragment.getTag())
    }

    private fun onYoutubeClickListener() {
        startFragment(YoutubeFragment(), YoutubeFragment.getTag())
    }
}
