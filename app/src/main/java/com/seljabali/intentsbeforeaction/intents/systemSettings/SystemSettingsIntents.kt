package com.seljabali.intentsbeforeaction.intents.systemSettings

import android.content.Intent
import android.provider.Settings

fun getLocationServicesSettings(): Intent {
    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
    return intent
}