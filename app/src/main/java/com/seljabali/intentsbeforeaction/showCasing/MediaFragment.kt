package com.seljabali.intentsbeforeaction.showCasing

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import com.seljabali.library.intents.getPickFile
import com.seljabali.library.intents.getPlayAudioFileIntent
import com.seljabali.library.intents.getPlayImageFileIntent
import com.seljabali.library.intents.getPlayVideoFileIntent
import com.seljabali.library.util.getPath
import kotlinx.android.synthetic.main.fragment_media.*

class MediaFragment: Fragment() {

    private val pickFileRequestCode: Int = 1337
    private var fileUri: Uri? = null

    companion object {
        fun getTag(): String {
            return MediaFragment::class.java.simpleName
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_media, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnClear.setOnClickListener { onClearClickListener() }
        btnFromFile.setOnClickListener { onFilePickClickListener() }
        btnViewImage.setOnClickListener { onViewImagePickClickListener() }
        btnPlayVideo.setOnClickListener { onPlayVideoClickListener() }
        btnPlayAudio.setOnClickListener { onPlayAudioClickListener() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickFileRequestCode && data != null) {
            onPickFileResult(data.data)
            return
        }
    }

    private fun onPlayAudioClickListener() {
        startActivity(getPlayAudioFileIntent(getPathText()))
    }

    private fun onPlayVideoClickListener() {
        startActivity(getPlayVideoFileIntent(getPathText()))
    }

    private fun onViewImagePickClickListener() {
        startActivity(getPlayImageFileIntent(fileUri!!))
    }

    private fun onPickFileResult(fileUri: Uri) {
        this.fileUri = fileUri
        etPath.setText(getPathText())
    }

    private fun onClearClickListener() {
        etPath.setText("")
    }

    private fun onFilePickClickListener() {
        startActivityForResult(getPickFile(), pickFileRequestCode)
    }

    private fun getPathText(): String {
        val fileUriUnecoded = fileUri!!.path
        val fileUriDecoded = Uri.decode(fileUriUnecoded)
        val fileUriEncoded = Uri.encode(fileUriUnecoded)
        val filePath = getPath(context!!, fileUri!!)
        Log.d("Media", "File Uri Unencoded: $fileUriUnecoded")
        Log.d("Media", "File Uri Decoded: $fileUriDecoded")
        Log.d("Media", "File Uri Encoded: $fileUriEncoded")
        Log.d("Media", "File Path: $filePath")
        return fileUriUnecoded
    }
}