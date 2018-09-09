package com.seljabali.intentsbeforeaction.showCasing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import com.seljabali.intentsbeforeaction.intents.googleMaps.getMapInWeb
import kotlinx.android.synthetic.main.fragment_google_maps_web.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.seljabali.intentsbeforeaction.intents.googleMaps.MapViewType
import android.widget.AdapterView.OnItemSelectedListener
import com.seljabali.intentsbeforeaction.intents.googleMaps.getQueryMapInWeb

class GoogleMapsWebFragment : Fragment() {

    companion object {
        fun getTag(): String {
            return GoogleMapsWebFragment::class.java.simpleName
        }
    }

    private val minZoomValue = 1
    private val maxZoomValue = 20
    private val defaultZoomValue = 10
    var selectedMapViewType: MapViewType? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_google_maps_web, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnShowAddressInMapsWeb.setOnClickListener { onShowAddressInMapsWebClickListener() }
        btnShowLatAndLongInNavigation.setOnClickListener { onShowLatLongInMapsWebClickListener() }
        setupMapViewTypes()
    }

    private fun setupMapViewTypes() {
        spMapViewTypes.adapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, MapViewType.values().map { it.description })
        spMapViewTypes.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(arg0: AdapterView<*>, view1: View, pos: Int, id: Long) {
                    selectedMapViewType = MapViewType.values()[pos]
            }

            override fun onNothingSelected(arg0: AdapterView<*>) {
            }
        }
    }

    private fun onShowAddressInMapsWebClickListener() {
        activity!!.startActivity(getQueryMapInWeb(etAddressForWeb.text.toString()))
    }

    private fun onShowLatLongInMapsWebClickListener() {
        activity!!.startActivity(getMapInWeb(etLatitude.text.toString().toFloat(), etLongitude.text.toString().toFloat(), getZoomValue(), selectedMapViewType))
    }

    private fun getZoomValue(): Int {
        val enteredZoomValue = etZoomValue.text.toString()
        val usedZoomValue: Int =
        when {
            enteredZoomValue.isEmpty() -> defaultZoomValue
            enteredZoomValue.toInt() < minZoomValue -> minZoomValue
            enteredZoomValue.toInt() > maxZoomValue -> maxZoomValue
            else -> defaultZoomValue
        }
        etZoomValue.setText(usedZoomValue.toString())
        return usedZoomValue
    }
}