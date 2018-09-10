package com.seljabali.library.intents

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.seljabali.library.util.isIntentAvailable

private const val youtubePackage = "com.google.android.youtube"
private const val youtubeUrl = "https://www.youtube.com/"

private const val youtubeNativeId = "vnd.youtube:"
private const val youtubeWebId = youtubeUrl + "watch?v="

private const val youtubeWebQuery = youtubeUrl + "results?search_query="

// Youtube, Id
fun getPlayYouTubeIdIntent(context: Context, videoId: String): Intent {
    if (isIntentAvailable(context, youtubePackage)) {
        return getPlayYouTubeIdNativeIntent(videoId)
    }
    return getPlayYouTubeIdWebIntent(videoId)
}

fun getPlayYouTubeIdNativeIntent(videoId: String): Intent {
    return Intent(Intent.ACTION_VIEW, Uri.parse(youtubeNativeId + videoId))
}

fun getPlayYouTubeIdWebIntent(videoId: String): Intent {
    return Intent(Intent.ACTION_VIEW, Uri.parse(youtubeWebId + videoId))
}

// Youtube, Query
fun getPlayYouTubeQueryIntent(context: Context, videoId: String): Intent {
    if (isIntentAvailable(context, youtubePackage)) {
        return getPlayYouTubeQueryNativeIntent(videoId)
    }
    return getPlayYouTubeQueryWebIntent(videoId)
}

fun getPlayYouTubeQueryNativeIntent(videoQuery: String): Intent {
    val intent = Intent(Intent.ACTION_SEARCH)
    intent.setPackage(youtubePackage)
    intent.putExtra("query", videoQuery)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    return intent
}

fun getPlayYouTubeQueryWebIntent(videoQuery: String): Intent {
    return Intent(Intent.ACTION_VIEW, Uri.parse(youtubeWebQuery + videoQuery))
}