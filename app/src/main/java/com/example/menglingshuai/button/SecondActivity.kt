package com.example.menglingshuai.button

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import org.greenrobot.eventbus.EventBus

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        childactivity_button.setOnClickListener {
//            val messageEvent = MessageEvent().let { it.message = "白色的" }
//            messageEvent.message = "白色的是"

            EventBus.getDefault().post(MessageEvent().let { it.message = "白色的" })
        }
    }
}