package com.seljabali.intentsbeforeaction.intents

import android.content.Intent
import android.net.Uri
import java.net.URL

fun getOpenWebBrowserIntent(urlParam: String): Intent {
    var url = urlParam
    if (!url.startsWith("https://") && !url.startsWith("http://")) {
        url = "http://$url"
    }
    return Intent(Intent.ACTION_VIEW, Uri.parse(url))
}

fun getOpenWebBrowserIntent(url: URL): Intent {
    return getOpenWebBrowserIntent(url.toString())
}
