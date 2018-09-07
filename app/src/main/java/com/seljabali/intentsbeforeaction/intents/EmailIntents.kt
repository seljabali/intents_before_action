package com.seljabali.intentsbeforeaction.intents

import android.content.Intent
import android.net.Uri

private const val MIME_TYPE_EMAIL = "message/rfc822"

fun getInboxOpen(): Intent {
    val intent = Intent(Intent.ACTION_MAIN)
    intent.addCategory(Intent.CATEGORY_APP_EMAIL)
    return intent
}

fun getEmailSend(address: String, subject: String): Intent? {
    if (address.isEmpty()) {
        return null
    }
    var url = "mailto: $address"
    if (subject.isNotEmpty()) {
        url += "?subject=" + Uri.encode(subject)
    }
    return getEmailSend(url)
}

fun getEmailSend(url: String): Intent {
    val uri = Uri.parse(url)
    val emailIntent = Intent(Intent.ACTION_SENDTO)
    emailIntent.data = uri
    return emailIntent
}

fun getNewEmail(address: String, subject: String, body: String): Intent {
    return getNewEmail(address, subject, body, null)
}

fun getNewEmail(address: String?, subject: String, body: String, attachment: Uri?): Intent {
    return getNewEmail(if (address == null) null else arrayOf(address), subject, body, attachment)
}

fun getNewEmail(addresses: Array<String>?, subject: String?, body: String?, attachment: Uri?): Intent {
    val intent = Intent(Intent.ACTION_SEND)
    if (addresses != null) intent.putExtra(Intent.EXTRA_EMAIL, addresses)
    if (body != null) intent.putExtra(Intent.EXTRA_TEXT, body)
    if (subject != null) intent.putExtra(Intent.EXTRA_SUBJECT, subject)
    if (attachment != null) intent.putExtra(Intent.EXTRA_STREAM, attachment)
    intent.type = MIME_TYPE_EMAIL
    return intent
}