package com.seljabali.intentsbeforeaction.showCasing

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import com.seljabali.library.intents.getEmailSendIntent
import com.seljabali.library.intents.getInboxOpenIntent
import com.seljabali.library.intents.getShareEmailIntent
import kotlinx.android.synthetic.main.fragment_email.*

class EmailFragment: Fragment() {

    private var fileUri: Uri? = null

    companion object {
        fun getTag(): String {
            return EmailFragment::class.java.simpleName
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSend.setOnClickListener { onSendEmailClickListener() }
        btnShareEmail.setOnClickListener { onShareEmailClickListener() }
        btnOpenInbox.setOnClickListener { onOpenInboxClickListener() }
    }

    private fun onOpenInboxClickListener() {
        startActivity(getInboxOpenIntent())
    }

    private fun onShareEmailClickListener() {
        // TODO: Add attachments
        startActivity(getShareEmailIntent(getToAddresses(), getSubject(), getBody(), null))
    }

    private fun onSendEmailClickListener() {
        startActivity(getEmailSendIntent(getToAddresses()[0], getSubject()))
    }

    private fun getToAddresses(): ArrayList<String> {
        return ArrayList(etToAddresses.text.toString().split(","))
    }

    private fun getSubject(): String {
        return etSubject.text.toString()
    }

    private fun getBody(): String {
        return etBody.text.toString()
    }
}