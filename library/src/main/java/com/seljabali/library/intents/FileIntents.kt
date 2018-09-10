package com.seljabali.library.intents

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import com.seljabali.library.util.isIntentAvailable
import java.io.File

const val ANY_TYPE = "*/*"
const val AUDIO_TYPE = "audio/*"
const val VIDEO_TYPE = "video/*"
const val IMAGE_TYPE = "image/*"
const val PDF_TYPE = "application/pdf"
const val TEXT_TYPE = "text/plain"

// Regular Files
fun getViewFile(fileUri: Uri, fileType: String): Intent {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.setDataAndType(fileUri, fileType)
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    return intent
}

fun getPickFile(): Intent {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = ANY_TYPE
    return intent
}

fun getGalleryForPhotos(): Intent {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = IMAGE_TYPE
    return intent
}

fun getGalleryForPhotosAndPdfs(): Intent {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = ANY_TYPE
    val mimeTypes = arrayOf(IMAGE_TYPE, PDF_TYPE)
    intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
    return intent
}

// Text
fun getOpenTextIntent(file: String): Intent {
    return getOpenTextIntent(File(file))
}

fun getOpenTextIntent(file: File): Intent {
    return getOpenTextIntent(Uri.fromFile(file))
}

fun getOpenTextIntent(uri: Uri): Intent {
    return getPlayMediaIntent(uri, TEXT_TYPE)
}

// Audio
fun getPlayAudioFileIntent(uri: Uri): Intent {
    return getPlayMediaIntent(uri, AUDIO_TYPE)
}

fun getPlayAudioFileIntent(file: File): Intent {
    return getPlayMediaFileIntent(file, AUDIO_TYPE)
}

fun getPlayAudioFileIntent(path: String): Intent {
    return getPlayMediaFileIntent(path, AUDIO_TYPE)
}

fun getPlayAudioIntent(url: String): Intent {
    return getPlayMediaIntent(url, AUDIO_TYPE)
}

// Image
fun getPlayImageFileIntent(uri: Uri): Intent {
    return getPlayMediaIntent(uri, IMAGE_TYPE)
}

fun getPlayImageFileIntent(file: File): Intent {
    return getPlayMediaFileIntent(file, IMAGE_TYPE)
}

fun getPlayImageFileIntent(path: String): Intent {
    return getPlayMediaFileIntent(path, IMAGE_TYPE)
}

fun getPlayImageIntent(url: String): Intent {
    return getPlayMediaIntent(url, IMAGE_TYPE)
}

// Video
fun getPlayVideoFileIntent(uri: Uri): Intent {
    return getPlayMediaIntent(uri, VIDEO_TYPE)
}

fun getPlayVideoFileIntent(file: File): Intent {
    return getPlayMediaFileIntent(file, VIDEO_TYPE)
}

fun getPlayVideoFileIntent(path: String): Intent {
    return getPlayMediaFileIntent(path, VIDEO_TYPE)
}

fun getPlayVideoIntent(url: String): Intent {
    return getPlayMediaIntent(url, VIDEO_TYPE)
}

// Media
fun getPlayMediaIntent(url: String, type: String): Intent {
    return getPlayMediaIntent(Uri.parse(url), type)
}

fun getPlayMediaFileIntent(file: File, type: String): Intent {
    return getPlayMediaIntent(Uri.fromFile(file), type)
}

fun getPlayMediaFileIntent(path: String, type: String): Intent {
    return getPlayMediaIntent(Uri.fromFile(File(path)), type)
}

fun getPlayMediaIntent(uri: Uri, type: String): Intent {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.setDataAndType(uri, type)
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    return intent
}

// Picture
fun getTakePictureIntent(tempFile: File): Intent {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile))
    return intent
}

fun getTakePictureIntent(tempFile: String): Intent {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(File(tempFile)))
    return intent
}

fun getSelectPictureIntent(): Intent {
    val intent = Intent(Intent.ACTION_PICK)
    intent.type = IMAGE_TYPE
    return intent
}

fun isCropAvailable(context: Context): Boolean {
    val intent = Intent("com.android.camera.action.CROP")
    intent.type = IMAGE_TYPE
    return isIntentAvailable(context, intent)
}

fun getCropImageIntent(context: Context, image: File, outputX: Int, outputY: Int, aspectX: Int, aspectY: Int, scale: Boolean): Intent {
    val intent = Intent("com.android.camera.action.CROP")
    intent.type = IMAGE_TYPE
    val list = context.packageManager.queryIntentActivities(intent, 0)
    val res = list[0]
    intent.putExtra("outputX", outputX)
    intent.putExtra("outputY", outputY)
    intent.putExtra("aspectX", aspectX)
    intent.putExtra("aspectY", aspectY)
    intent.putExtra("scale", scale)
    intent.putExtra("return-data", true)
    intent.data = Uri.fromFile(image)
    intent.component = ComponentName(res.activityInfo.packageName, res.activityInfo.name)
    return intent
}


