package com.seljabali.intentsbeforeaction.intents.googleMaps

import android.content.Intent
import android.net.Uri

// Api Documentation from:
// https://developers.google.com/maps/documentation/urls/guide

const val querySearchMapsApi1 = "https://www.google.com/maps/search/?api=1"
const val locationInMapApi1 = "https://www.google.com/maps/@?api=1"

fun getQueryMapInWeb(query: String): Intent {
    return getQueryMapInWeb(query, null)
}

fun getQueryMapInWeb(query: String, locationId: String?): Intent {
    val builder = StringBuilder(querySearchMapsApi1)
    builder.append("&query=" + Uri.encode(query))
    if (locationId != null) {
        builder.append("&query_place_id=$locationId")
    }
    return Intent(Intent.ACTION_VIEW, Uri.parse(builder.toString()))
}

fun getMapInWeb(latitude: Float, longitude: Float): Intent {
    return getMapInWeb(latitude, longitude, null, null)
}

fun getMapInWeb(latitude: Float, longitude: Float, type: MapViewType?): Intent {
    return getMapInWeb(latitude, longitude, type)
}

fun getMapInWeb(latitude: Float, longitude: Float, zoom: Int?): Intent {
    return getMapInWeb(latitude, longitude, zoom, null)
}

fun getMapInWeb(latitude: Float, longitude: Float, zoom: Int?, type: MapViewType?): Intent {
    val builder = StringBuilder(locationInMapApi1)
    builder.append("&map_action=map")
    builder.append("&center=$latitude,$longitude")
    if (zoom != null) {
        builder.append("&zoom=$zoom")
    }
    if (type != null) {
        builder.append("&basemap=${type.key}")
    }
    return Intent(Intent.ACTION_VIEW, Uri.parse(builder.toString()))
}
