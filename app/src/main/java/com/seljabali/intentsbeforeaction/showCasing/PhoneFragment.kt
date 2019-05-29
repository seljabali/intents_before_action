package com.seljabali.intentsbeforeaction.showCasing

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seljabali.intentsbeforeaction.R
import kotlinx.android.synthetic.main.fragment_phone.*
import android.provider.ContactsContract.CommonDataKinds.Phone
import com.seljabali.library.intents.Intents
import com.seljabali.library.intents.getDialNumber
import com.seljabali.library.intents.getPickContactWithPhone
import com.seljabali.library.intents.getSms

class PhoneFragment: Fragment() {

    companion object {
        fun getTag(): String {
            return PhoneFragment::class.java.simpleName
        }
    }

    private val pickContactRequestCode = 123

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_phone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnCallNumber.setOnClickListener { onCallNumberClickListener() }
        btnSendSms.setOnClickListener { onSendSmsClickListener() }
        btnPickContact.setOnClickListener { onPickContactClickListener() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickContactRequestCode && data != null) {
            onPickContactResult(data.data)
            return
        }
    }

    private fun onPickContactResult(data: Uri) {
        val projection = arrayOf(Phone.NUMBER, Phone.DISPLAY_NAME)
        val cursor = context!!.contentResolver.query(data, projection, null, null, null)
        cursor.moveToFirst()
        val numberColumnIndex = cursor.getColumnIndex(Phone.NUMBER)
        val number = cursor.getString(numberColumnIndex)
        val nameColumnIndex = cursor.getColumnIndex(Phone.DISPLAY_NAME)
        val name = cursor.getString(nameColumnIndex)
        etPhoneNumbers.setText(number)
        etBodyText.setText("Hi $name")
    }

    private fun onPickContactClickListener() {
        startActivityForResult(Intents.getPickContactWithPhone(), pickContactRequestCode)
    }

    private fun onSendSmsClickListener() {
        context!!.startActivity(Intents.getSms(getBody(), getPhoneNumbers()))
    }

    private fun onCallNumberClickListener() {
        context!!.startActivity(Intents.getDialNumber(getPhoneNumbers()[0]))
    }

    private fun getPhoneNumbers(): ArrayList<String> {
        return ArrayList(etPhoneNumbers.text.toString().split(","))
    }

    private fun getBody(): String {
        return etBodyText.text.toString()
    }

}