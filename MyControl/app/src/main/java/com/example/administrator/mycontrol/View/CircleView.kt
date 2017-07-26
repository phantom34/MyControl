package com.example.administrator.mycontrol.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import java.util.*

/**
 * Created by phantom on 2017/7/6.
 */
class CircleView : View {


    var mColors = ArrayList<Int>(4)
    val mint: IntArray = intArrayOf(-1, 1)
    var mPaint: Paint = Paint()
    var x: Int = 0
    var m_iCenterPt: Int = 0

    constructor(mContext: Context) : super(mContext) {
        val context = mContext
    }

    constructor(mContext: Context, mAttributeSet: AttributeSet) : super(mContext, mAttributeSet) {
        val context = mContext
        initPaint()
    }

    private fun initPaint() {
        for (i in 0..3)
            mColors.add((0xff44b391 + 1000 * i * mint[i % 2]).toInt())
        mPaint.isAntiAlias = false
        mPaint.style = Paint.Style.STROKE
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec)
        val heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec)
        val mLayoutSize = Math.min(heightSpecSize, widthSpecSize)

        m_iCenterPt = widthSpecSize / 2
        setMeasuredDimension(mLayoutSize, mLayoutSize)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var mPath: Path = Path()
        x++
//        mPath.addCircle(width / 2f, height / 2f, width / 2f / (x % 4), Path.Direction.CW)
//        mPath.close()
//        canvas?.clipPath(mPath, Region.Op.XOR)
        mPaint.color = 0xff44b391.toInt()
        mPaint.color = mColors.get(x % 4)
//        canvas?.drawPaint(mPaint);
        for (k in 1..80) {
            for (i in 1..k) {
                val angle = 2 * Math.PI / 80 * i
                val x = m_iCenterPt - 16 * (Math.sin(angle) * Math.sin(angle) * Math.sin(angle)) * 20
                val y = m_iCenterPt - (13 * Math.cos(angle) - 5 * Math.cos(2 * angle) - 2 * Math.cos(3 * angle) - Math.cos(4 * angle)) * 20
//            canvas?.drawPoint(x.toFloat(),y.toFloat(),mPaint)

                if (k == 1 && i == 1)
                    mPath.moveTo(x.toFloat(), y.toFloat())
                else
                    mPath.lineTo(x.toFloat(), y.toFloat())
            }
        }
        canvas?.drawPath(mPath, mPaint)

        postInvalidateDelayed(1000)
    }

    fun sDraw(canvas: Canvas?) {

    }
}