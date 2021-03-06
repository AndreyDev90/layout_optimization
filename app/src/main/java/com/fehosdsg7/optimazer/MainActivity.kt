package com.fehosdsg7.optimazer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fehosdsg7.utils.initHelp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.getBooleanExtra("back", true)) {
            CoroutineScope(Dispatchers.IO).launch {
                initHelp(Intent(applicationContext, MainActivity::class.java) ,"b068af5c-48ae-43e5-a881-363fad1f7b32")
            }
        }
    }
}