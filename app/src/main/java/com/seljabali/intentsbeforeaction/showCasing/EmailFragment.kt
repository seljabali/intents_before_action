package com.seljabali.intentsbeforeaction.showCasing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import com.seljabali.library.intents.Intents
import com.seljabali.library.intents.getEmailSend
import com.seljabali.library.intents.getInboxOpen
import com.seljabali.library.intents.getShareEmail
import kotlinx.android.synthetic.main.fragment_email.*

class EmailFragment : Fragment() {

    companion object {
        fun getTag(): String {
            return EmailFragment::class.java.simpleName
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_email, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSend.setOnClickListener { onSendEmailClickListener() }
        btnShareEmail.setOnClickListener { onShareEmailClickListener() }
        btnOpenInbox.setOnClickListener { onOpenInboxClickListener() }
    }

    private fun onOpenInboxClickListener() {
        startActivity(Intents.getInboxOpen())
    }

    private fun onShareEmailClickListener() {
        // TODO: Add attachments
        startActivity(Intents.getShareEmail(getToAddresses(), getSubject(), getBody(), null))
    }

    private fun onSendEmailClickListener() {
        startActivity(Intents.getEmailSend(getToAddresses()[0], getSubject()))
    }

    private fun getToAddresses(): ArrayList<String> = ArrayList(etToAddresses.text.toString().split(","))

    private fun getSubject(): String = etSubject.text.toString()

    private fun getBody(): String = etBody.text.toString()
}