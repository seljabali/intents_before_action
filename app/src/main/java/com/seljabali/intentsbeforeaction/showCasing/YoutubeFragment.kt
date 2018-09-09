package com.seljabali.intentsbeforeaction.showCasing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import com.seljabali.intentsbeforeaction.intents.getPlayYouTubeIdIntent
import com.seljabali.intentsbeforeaction.intents.getPlayYouTubeQueryIntent
import kotlinx.android.synthetic.main.fragment_youtube.*

class YoutubeFragment: Fragment() {

    companion object {
        fun getTag(): String {
            return YoutubeFragment::class.java.simpleName
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_youtube, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnClearYoutube.setOnClickListener { onClearYoutubeClickListener() }
        btnYoutubeId.setOnClickListener { onYoutubeIdClickListener() }
        btnYoutubeName.setOnClickListener { onYoutubeNameClickListener() }
    }

    private fun onYoutubeIdClickListener() {
        context!!.startActivity(getPlayYouTubeIdIntent(context!!, getYoutubeText()))
    }

    private fun onYoutubeNameClickListener() {
        context!!.startActivity(getPlayYouTubeQueryIntent(context!!, getYoutubeText()))
    }

    private fun onClearYoutubeClickListener() {
        etYoutube.setText("")
    }

    private fun getYoutubeText(): String {
        return etYoutube.text.toString()
    }
}