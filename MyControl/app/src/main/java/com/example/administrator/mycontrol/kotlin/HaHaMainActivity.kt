package com.example.administrator.mycontrol.kotlin

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MotionEvent
import android.widget.LinearLayout
import com.example.administrator.mycontrol.R
import com.example.administrator.mycontrol.weight.CustomPopWindow
import kotlinx.android.synthetic.main.activity_maain.*
import java.util.*
import kotlin.concurrent.timerTask

class HaHaMainActivity : AppCompatActivity() {


    var thread: Thread? = null
    var c = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maain)
        asdasdasdasd.setOnClickListener { showPop() }
        asdasdasdasd.text = "asdasd"
        asdasdasdasd.width = 100
        asdasdasdasd.width = 200
        xxx.setOnClickListener { showPop() }
        val list: List<Drawable> = arrayListOf(resources.getDrawable(R.drawable.ic_launcher)
                , resources.getDrawable(R.drawable.locus_round_click))
        bubb.setDrawableList(list)
        timerTask { kotlin.run { } }
    }

    private fun myThread() {
        thread = Thread(Runnable { kotlin.run { showBubb() } })
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        showBubb()
        return super.onTouchEvent(event)
    }

    private fun showPop() {
        myThread()
        thread?.start()
        CustomPopWindow.Builder()
                .setContext(this)
                .setContentviewid(R.layout.dfghjk)
                .setWidth(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setHeight(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setOutsidecancer(true)
                .builder()
                .showAtlocation(xxx, Gravity.CENTER, 0, 0)

        showBubb()
        val timer: Timer = Timer(true)
        timer.schedule(task, 1000, 1000)
    }

    private fun showBubb() {
        bubb.startAnimation(bubb.width, bubb.height)
    }

    var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            if (msg?.what == 1) {
                showBubb()
            }
        }
    }

    val task = timerTask {
        run {
            val msg = Message()

            msg.what = c
            handler.sendMessage(msg)
        }
    }

}
