package com.seljabali.library.util

import android.content.Context
import android.net.Uri
import android.support.annotation.AnyRes

fun getResourceIdentifier(context: Context, @AnyRes id: Int): String? = context.resources.getResourceEntryName(id)

fun getPathForResource(context: Context, resFolder: String, resourceId: Int): String = "android.resource://" + context.packageName + "/$resFolder/" + getResourceIdentifier(context, resourceId)

fun getPathUriForResource(context: Context, resFolder: String, resourceId: Int): Uri = Uri.parse(getPathForResource(context, resFolder, resourceId))