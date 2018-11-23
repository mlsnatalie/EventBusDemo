package com.example.menglingshuai.button

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.ThreadMode
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)//注册EventBus
        mBtn.setOnClickListener {
            val intent = Intent()
            intent.setClass(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }

        val hashMap: HashMap<String,String> = hashMapOf()
        hashMap.put("1","25884545464654654")
        Log.e("aaaddd","sssss"+hashMap.get("1"))

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: MessageEvent) {/* Do something */
        Log.e("assdf", "aaaasss" + event.message!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}
