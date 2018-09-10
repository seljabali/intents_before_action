package com.seljabali.intentsbeforeaction.showCasing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import com.seljabali.library.intents.getAmazonForPackageIntent
import com.seljabali.library.intents.getAmazonForQueryIntent
import com.seljabali.library.intents.getGooglePlayForPackageIntent
import com.seljabali.library.intents.getGooglePlayForQueryIntent
import kotlinx.android.synthetic.main.fragment_store.*

class StoreFragment: Fragment() {

    companion object {
        fun getTag(): String {
            return StoreFragment::class.java.simpleName
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnGooglePlay.setOnClickListener { onGooglePlayClickListener() }
        btnGooglePlaySearch.setOnClickListener { onGooglePlaySearchClickListener() }
        btnAmazon.setOnClickListener { onAmazonClickListener() }
        btnAmazonSearch.setOnClickListener { onAmazonSearchClickListener() }
    }

    private fun onGooglePlaySearchClickListener() {
        context!!.startActivity(getGooglePlayForQueryIntent(context!!, getEnteredAppName()))
    }

    private fun onGooglePlayClickListener() {
        context!!.startActivity(getGooglePlayForPackageIntent(context!!, getEnteredAppName()))
    }

    private fun onAmazonSearchClickListener() {
        context!!.startActivity(getAmazonForQueryIntent(context!!, getEnteredAppName()))
    }

    private fun onAmazonClickListener() {
        context!!.startActivity(getAmazonForPackageIntent(context!!, getEnteredAppName()))
    }

    private fun getEnteredAppName(): String {
        return etAppName.text.toString()
    }
}