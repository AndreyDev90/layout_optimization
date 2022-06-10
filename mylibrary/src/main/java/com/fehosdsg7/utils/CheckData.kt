package com.fehosdsg7.utils

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.annotation.Keep
import com.fehosdsg7.mylibrary.HelpActivity
import com.fehosdsg7.utils.Daonm.Companion.toApp

@Keep
suspend fun <T : Activity> T.initHelp(intent: Intent) {
    try {
        val a = Networking.greySourceApi.getData(Chupoa(Aps(), Fb()))
        if(a.response == null || a.response=="null"){

        } else {
            startActivity(Intent(this, HelpActivity::class.java).withArguments(a.toApp(), intent))
        }

    } catch (e: Exception) {
        Log.e("Network", e.message.toString())
        return
    }
}


fun Intent.withArguments(app: App, intent: Intent): Intent {
    return this.apply {
        putExtra("app", intent)
        putExtra("link", app.source)
    }
}



