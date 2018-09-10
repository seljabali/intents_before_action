package com.seljabali.library.intents

import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract
import android.text.TextUtils

// Pick Contact
fun getPickContactIntent(): Intent {
    return getPickContactIntent(null)
}

fun getPickContactWithPhoneIntent(): Intent {
    return getPickContactIntent(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE)
}

fun getPickContactWithEmailIntent(): Intent {
    return getPickContactIntent(ContactsContract.CommonDataKinds.Email.CONTENT_TYPE)
}

fun getPickContactIntent(scope: String?): Intent {
    val intent = Intent(Intent.ACTION_PICK, Uri.parse("content://com.android.contacts/contacts"))
    if (!scope.isNullOrBlank()) {
        intent.type = scope
    }
    return intent
}

// Dial
fun getDialNumberIntent(phoneNumber: String?): Intent {
    return if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
        Intent(Intent.ACTION_DIAL, Uri.parse("tel:"))
    } else {
        Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phoneNumber.replace(" ", "")))
    }
}

// SMS
fun getSmsIntent(): Intent {
    return getSmsIntent(null, null as Array<String>?)
}

fun getSmsIntent(phoneNumber: String): Intent {
    return getSmsIntent(null, arrayOf(phoneNumber))
}

fun getSmsIntent(phoneNumbers: Array<String>): Intent {
    return getSmsIntent(null, phoneNumbers)
}

fun getSmsWithBodyIntent(body: String): Intent {
    return getSmsIntent(body, null as Array<String>?)
}

fun getSmsIntent(body: String, phoneNumber: String): Intent {
    return getSmsIntent(body, arrayOf(phoneNumber))
}

fun getSmsIntent(body: String?, phoneNumbers: ArrayList<String>?): Intent {
    return getSmsIntent(body, phoneNumbers?.toTypedArray())
}

fun getSmsIntent(body: String?, phoneNumbers: Array<String>?): Intent {
    val smsUri: Uri = if (phoneNumbers == null || phoneNumbers.isEmpty()) {
        Uri.parse("smsto:")
    } else {
        Uri.parse("smsto:" + Uri.encode(TextUtils.join(",", phoneNumbers)))
    }
    val intent = Intent(Intent.ACTION_VIEW, smsUri)
    if (body != null) {
        intent.putExtra("sms_body", body)
    }
    return intent
}