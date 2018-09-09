package com.seljabali.intentsbeforeaction.intents

import android.app.Activity
import android.content.Context
import android.content.Intent

fun getLaunchAppIntent(context: Context, packageName: String): Intent {
    return context.packageManager.getLaunchIntentForPackage(packageName)
}

// TODO: Update to newer implementation
fun createShortCut(context: Context, launcherActivity: Activity, text: String?, drawable: Int?) {
    val shortcutIntent = Intent(context.applicationContext, launcherActivity.javaClass)
    shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

    val addIntent = Intent()
    addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent)
    if (text == null) {
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getApplicationName(context))
    } else {
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, text)
    }
    if (drawable != null) {
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(context.applicationContext, drawable))
    }
    addIntent.putExtra("duplicate", false)
    addIntent.action = "com.android.launcher.action.INSTALL_SHORTCUT"
    context.applicationContext.sendBroadcast(addIntent)
}

private fun getApplicationName(context: Context): String {
    val applicationInfo = context.applicationInfo
    val stringId = applicationInfo.labelRes
    return if (stringId == 0) applicationInfo.nonLocalizedLabel.toString() else context.getString(stringId)
}
