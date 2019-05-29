package com.seljabali.intentsbeforeaction.showCasing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import com.seljabali.library.intents.Intents
import com.seljabali.library.intents.googleMaps.showInStreetView
import com.seljabali.library.intents.googleMaps.showLocationInMaps
import com.seljabali.library.intents.googleMaps.showLocationInNavigation
import kotlinx.android.synthetic.main.fragment_google_maps_app.*

class GoogleMapsAppFragment : Fragment() {

    companion object {
        fun getTag(): String = GoogleMapsAppFragment::class.java.simpleName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_google_maps_app, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnShowAddressInMaps.setOnClickListener { onShowAddressInMapsClickListener() }
        btnShowAddressInNavigation.setOnClickListener { onShowAddressInNavigationClickListener() }
        btnShowAddressInStreetView.setOnClickListener { onShowAddressInStreetViewClickListener() }
        btnShowLatAndLongInNavigation.setOnClickListener { onShowLatAndLongInNavigationViewClickListener() }
    }

    private fun onShowAddressInMapsClickListener() {
        activity?.startActivity(Intents.showLocationInMaps(etAddress.text.toString()))
    }

    private fun onShowAddressInNavigationClickListener() {
        activity?.startActivity(Intents.showLocationInNavigation(etAddress.text.toString()))
    }

    private fun onShowAddressInStreetViewClickListener() {
        activity?.startActivity(Intents.showInStreetView(etLatitude.text.toString().toFloat(),
                etLongitude.text.toString().toFloat()))
    }

    private fun onShowLatAndLongInNavigationViewClickListener() {
        activity?.startActivity(Intents.showLocationInNavigation(etLatitude.text.toString().toFloat(),
                etLongitude.text.toString().toFloat()))
    }
}