package com.seljabali.library.intents.googleMaps

enum class MapViewType(val key: String, val description: String) {
    NORMAL("roadmap", "NORMAL"),
    SATELLITE("satellite", "SATELLITE"),
    TERRAIN("terrain", "TERRAIN")
}

enum class MapViewTypeDesktop(val key: String, val description: String) {
    NORMAL("!3m1!1e3", "NORMAL"),
    TERRAIN("!5m1!1e4", "TERRAIN"),
    STREET("!5m1!1e5", "STREET")
}