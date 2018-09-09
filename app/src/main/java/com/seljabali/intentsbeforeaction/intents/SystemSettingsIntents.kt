package com.seljabali.intentsbeforeaction.intents

import android.annotation.TargetApi
import android.content.Intent
import android.provider.Settings

private const val DEFAULT_FLAG = Intent.FLAG_ACTIVITY_NO_HISTORY

fun getLocationServicesSettings(): Intent {
    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
    intent.addFlags(DEFAULT_FLAG)
    return intent
}

fun getSettings(): Intent {
    val intent = Intent(Settings.ACTION_SETTINGS)
    intent.addFlags(DEFAULT_FLAG)
    return intent
}

fun getApnSettings(): Intent {
    val intent = Intent(Settings.ACTION_APN_SETTINGS)
    intent.addFlags(DEFAULT_FLAG)
    return intent
}

fun getWirelessSettings(): Intent {
    val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
    intent.addFlags(DEFAULT_FLAG)
    return intent
}

fun getAirplaneModeSettings(): Intent {
    val intent = Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS)
    intent.addFlags(DEFAULT_FLAG)
    return intent
}

fun getAccessibilitySettings(): Intent {
    val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
    intent.addFlags(DEFAULT_FLAG)
    return intent
}

@TargetApi(21)
fun getUsageSettings(): Intent {
    val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
    intent.addFlags(DEFAULT_FLAG)
    return intent
}

fun getSecuritySettings(): Intent {
    val intent = Intent(Settings.ACTION_SECURITY_SETTINGS)
    intent.addFlags(DEFAULT_FLAG)
    return intent
}

fun getPrivacySettings(): Intent {
    val intent = Intent(Settings.ACTION_PRIVACY_SETTINGS)
    intent.addFlags(DEFAULT_FLAG)
    return intent
}