package com.seljabali.intentsbeforeaction

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_intents_show_casing.*

class IntentsShowCasingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents_show_casing)
        setSupportActionBar(toolbar)
        supportFragmentManager.addOnBackStackChangedListener { getBackStackListener() }
        supportFragmentManager.beginTransaction()
                .add(R.id.fl_main, IntentsShowCasingFragment())
                .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getBackStackListener(): FragmentManager.OnBackStackChangedListener {
        return FragmentManager.OnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                this.setTitle(R.string.app_name)
            }
        }
    }

}
