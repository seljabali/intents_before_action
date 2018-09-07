package com.seljabali.intentsbeforeaction.intents

import android.content.Intent
import android.net.Uri

fun getNumberDial(phoneNumber: String): Intent {
    return if (phoneNumber.isEmpty() || phoneNumber.trim { it <= ' ' }.isEmpty()) {
        Intent(Intent.ACTION_DIAL, Uri.parse("tel:"))
    } else {
        Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phoneNumber.replace(" ", "")))
    }
}