package com.seljabali.intentsbeforeaction.intents

import android.content.Intent
import android.net.Uri

private const val MIME_TYPE_EMAIL = "message/rfc822"

fun getInboxOpenIntent(): Intent {
    val intent = Intent(Intent.ACTION_MAIN)
    intent.addCategory(Intent.CATEGORY_APP_EMAIL)
    return intent
}

fun getEmailSendIntent(address: String, subject: String?): Intent? {
    if (address.isEmpty()) {
        return null
    }
    var url = "mailto: $address"
    if (subject != null && subject.isNotEmpty()) {
        url += "?subject=" + Uri.encode(subject)
    }
    return getEmailSendIntent(url)
}

fun getEmailSendIntent(url: String): Intent {
    val uri = Uri.parse(url)
    val emailIntent = Intent(Intent.ACTION_SENDTO)
    emailIntent.data = uri
    return emailIntent
}

fun getShareEmailIntent(address: String?, subject: String?, body: String?): Intent {
    return getShareEmailIntent(address, subject, body, null)
}

fun getShareEmailIntent(address: String?, subject: String?, body: String?, attachment: Uri?): Intent {
    return getShareEmailIntent(if (address == null) null else arrayOf(address), subject, body, attachment)
}

fun getShareEmailIntent(addresses: ArrayList<String>?, subject: String?, body: String?, attachment: Uri?): Intent {
    return getShareEmailIntent(addresses!!.toTypedArray(), subject, body, attachment)
}

fun getShareEmailIntent(addresses: Array<String>?, subject: String?, body: String?, attachment: Uri?): Intent {
    return ShareIntentBuilder()
            .withAddresses(addresses)
            .withSubject(subject)
            .withText(body)
            .withAttachment(attachment)
            .withExplicitMimeType(MIME_TYPE_EMAIL)
            .build()
}