package com.seljabali.library.util

import android.content.Context
import android.net.Uri
import android.support.annotation.AnyRes
import android.util.Log

fun getResourceIdentifier(context: Context, @AnyRes id: Int): String? {
    return context.resources.getResourceEntryName(id)
}

fun getPathForResource(context: Context, resFolder: String, resourceId: Int): String {
    val path = "android.resource://" + context.packageName + "/$resFolder/" + getResourceIdentifier(context, resourceId)
    Log.d("Res:", "getPathForResource: $path")
    return path
}

fun getPathUriForResource(context: Context, resFolder: String, resourceId: Int): Uri {
    val path = Uri.parse(getPathForResource(context, resFolder, resourceId))
    Log.d("Res:", "getPathUriForResource: $path")
    return path
}