package com.seljabali.intentsbeforeaction.intents

import android.content.Intent
import android.net.Uri

fun getViewFile(fileUri: Uri, fileType: String): Intent {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.setDataAndType(fileUri, fileType)
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    return intent
}

fun getPickFile(): Intent {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "file/*"
    return intent
}

fun getGalleryForPhotos(): Intent {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "image/*"
    return intent
}

fun getGalleryForPhotosAndPdfs(): Intent {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "*/*"
    val mimeTypes = arrayOf("image/*", "application/pdf")
    intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
    return intent
}