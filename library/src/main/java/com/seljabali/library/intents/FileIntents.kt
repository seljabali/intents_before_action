@file:JvmName("IntentsUtil")
@file:JvmMultifileClass

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
fun Intents.Companion.getViewFile(fileUri: Uri, fileType: String): Intent =
        Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(fileUri, fileType)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

fun Intents.Companion.getPickFile(): Intent =
        Intent(Intent.ACTION_GET_CONTENT).apply {
            type = ANY_TYPE
        }

fun Intents.Companion.getGalleryForPhotos(): Intent =
        Intent(Intent.ACTION_GET_CONTENT).apply {
            type = IMAGE_TYPE
        }

fun Intents.Companion.getGalleryForPhotosAndPdfs(): Intent =
        Intent(Intent.ACTION_GET_CONTENT).apply {
            type = ANY_TYPE
            putExtra(Intent.EXTRA_MIME_TYPES, arrayOf(IMAGE_TYPE, PDF_TYPE))
        }

// Text
fun Intents.Companion.getOpenText(file: String): Intent = getOpenText(File(file))

fun Intents.Companion.getOpenText(file: File): Intent = getOpenText(Uri.fromFile(file))

fun Intents.Companion.getOpenText(uri: Uri): Intent = getPlayMedia(uri, TEXT_TYPE)

// Audio
fun Intents.Companion.getPlayAudioFile(uri: Uri): Intent = getPlayMedia(uri, AUDIO_TYPE)

fun Intents.Companion.getPlayAudioFile(file: File): Intent = getPlayMediaFile(file, AUDIO_TYPE)

fun Intents.Companion.getPlayAudioFile(path: String): Intent = getPlayMediaFile(path, AUDIO_TYPE)

fun Intents.Companion.getPlayAudioIntent(url: String): Intent = getPlayMedia(url, AUDIO_TYPE)

// Image
fun Intents.Companion.getPlayImageFile(uri: Uri): Intent = getPlayMedia(uri, IMAGE_TYPE)

fun Intents.Companion.getPlayImageFile(file: File): Intent = getPlayMediaFile(file, IMAGE_TYPE)

fun Intents.Companion.getPlayImageFile(path: String): Intent = getPlayMediaFile(path, IMAGE_TYPE)

fun Intents.Companion.getPlayImage(url: String): Intent = getPlayMedia(url, IMAGE_TYPE)

// Video
fun Intents.Companion.getPlayVideoFile(uri: Uri): Intent = getPlayMedia(uri, VIDEO_TYPE)

fun Intents.Companion.getPlayVideoFile(file: File): Intent = getPlayMediaFile(file, VIDEO_TYPE)

fun Intents.Companion.getPlayVideoFile(path: String): Intent = getPlayMediaFile(path, VIDEO_TYPE)

fun Intents.Companion.getPlayVideo(url: String): Intent = getPlayMedia(url, VIDEO_TYPE)

// Media
fun Intents.Companion.getPlayMedia(url: String, type: String): Intent = getPlayMedia(Uri.parse(url), type)

fun Intents.Companion.getPlayMediaFile(file: File, type: String): Intent = getPlayMedia(Uri.fromFile(file), type)

fun Intents.Companion.getPlayMediaFile(path: String, type: String): Intent = getPlayMedia(Uri.fromFile(File(path)), type)

fun Intents.Companion.getPlayMedia(uri: Uri, type: String): Intent =
        Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, type)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

// Picture
fun Intents.Companion.getTakePicture(tempFile: File): Intent =
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile))
        }

fun Intents.Companion.getTakePicture(tempFile: String): Intent =
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(File(tempFile)))
        }

fun Intents.Companion.getSelectPicture(): Intent =
        Intent(Intent.ACTION_PICK).apply {
            type = IMAGE_TYPE
        }

fun Intents.Companion.isCropAvailable(context: Context): Boolean {
    val intent = Intent("com.android.camera.action.CROP")
    intent.type = IMAGE_TYPE
    return isIntentAvailable(context, intent)
}

fun Intents.Companion.getCropImage(context: Context, image: File, outputX: Int, outputY: Int, aspectX: Int, aspectY: Int, scale: Boolean): Intent {
    val intent = Intent("com.android.camera.action.CROP")
    val list = context.packageManager.queryIntentActivities(intent, 0)
    val res = list[0]
    return intent.apply {
        type = IMAGE_TYPE
        putExtra("outputX", outputX)
        putExtra("outputY", outputY)
        putExtra("aspectX", aspectX)
        putExtra("aspectY", aspectY)
        putExtra("scale", scale)
        putExtra("return-data", true)
        data = Uri.fromFile(image)
        component = ComponentName(res.activityInfo.packageName, res.activityInfo.name)
    }
}