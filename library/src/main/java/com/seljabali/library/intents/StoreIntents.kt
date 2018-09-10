package com.seljabali.library.intents

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.seljabali.library.util.isIntentAvailable

private const val googlePlayAppUrlForPackages = "market://details?id="
private const val googlePlayWebUrlForPackages = "https://play.google.com/store/apps/details?id"

private const val googlePlayAppUrlForQueries = "market://search?q=%s&c=apps"
private const val googlePlayWebUrlForQueries = "http://play.google.com/store/search?q=%s&c=apps"

private const val amazonAppUrlForPackages = "amzn://apps/android?p="
private const val amazonWebUrlForPackages = "http://www.amazon.com/gp/mas/dl/android?p="

private const val amazonAppUrlForQueries = "amzn://apps/android?s="
private const val amazonWebUrlForQueries = "http://www.amazon.com/gp/mas/dl/android?s="

// Google Play, packages
fun getGooglePlayForPackageIntent(context: Context, packageName: String): Intent? {
    var intent: Intent? = getGooglePlayNativeForPackageIntent(packageName)
    if (!isIntentAvailable(context, intent)) {
        intent = getGooglePlayWebForPackageIntent(packageName)
    }
    return intent
}

fun getGooglePlayNativeForPackageIntent(packageName: String): Intent? {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googlePlayAppUrlForPackages + packageName))
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
    return intent
}

fun getGooglePlayWebForPackageIntent(packageName: String): Intent? {
    val intent = getOpenWebBrowserIntent(googlePlayWebUrlForPackages + packageName)
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
    return intent
}

// Google Play, queries
fun getGooglePlayForQueryIntent(context: Context, query: String): Intent? {
    var intent: Intent? = getGooglePlayNativeForQueryIntent(query)
    if (!isIntentAvailable(context, intent)) {
        intent = getGooglePlayWebForQueryIntent(query)
    }
    return intent
}

fun getGooglePlayNativeForQueryIntent(query: String): Intent? {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googlePlayAppUrlForQueries.format(query)))
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
    return intent
}

fun getGooglePlayWebForQueryIntent(query: String): Intent? {
    val intent = getOpenWebBrowserIntent(googlePlayWebUrlForQueries.format(query))
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
    return intent
}


// Amazon, packages
fun getAmazonForPackageIntent(context: Context, packageName: String): Intent? {
    var intent: Intent? = getAmazonNativeForPackageIntent(packageName)
    if (!isIntentAvailable(context, intent)) {
        intent = getAmazonWebForPackageIntent(packageName)
    }
    return intent
}

fun getAmazonNativeForPackageIntent(packageName: String): Intent? {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(amazonAppUrlForPackages + packageName))
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
    return intent
}

fun getAmazonWebForPackageIntent(packageName: String): Intent? {
    val intent = getOpenWebBrowserIntent(amazonWebUrlForPackages + packageName)
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
    return intent
}

// Amazon, queries
fun getAmazonForQueryIntent(context: Context, packageName: String): Intent? {
    var intent: Intent? = getAmazonNativeForQueryIntent(packageName)
    if (!isIntentAvailable(context, intent)) {
        intent = getAmazonWebForQueryIntent(packageName)
    }
    return intent
}

fun getAmazonNativeForQueryIntent(packageName: String): Intent? {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(amazonAppUrlForQueries + packageName))
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
    return intent
}

fun getAmazonWebForQueryIntent(packageName: String): Intent? {
    val intent = getOpenWebBrowserIntent(amazonWebUrlForQueries + packageName)
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
    return intent
}
