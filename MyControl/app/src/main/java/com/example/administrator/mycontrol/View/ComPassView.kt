package com.example.administrator.mycontrol.View

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


/**
 * Created by phantom on 2017/7/24.
 */

class ComPassView : View {

    var mPaint: Paint? = Paint()
    var mCenterX: Int = 0
    var mCenterY: Int = 0
    var mMatrix: Matrix? = Matrix()
    var mCamera: Camera? = Camera()
    var mBgColor: Int? = null
    var mPath: Path? = Path()
    val mAlpha: Int = 200
    var mTouchX: Float = 0F
    var mTouchY: Float = 0F
    private var alpha: Double = 0.toDouble()
    private var mCanvasRotateX = 0f
    private var mCanvasRotateY = 0f
    private var mCanvasMaxRotateDegree = 20f

    constructor(mContext: Context) : super(mContext) {
        val context = mContext
    }

    constructor(mContext: Context, mAttributeSet: AttributeSet) : super(mContext, mAttributeSet) {
        val context = mContext
        initPaint()
    }

    private fun initPaint() {
        mPaint = Paint()
        (mPaint as Paint).setAntiAlias(true)
        mCanvasMaxRotateDegree = 20F
        mBgColor = Color.parseColor("#227BAE")
        mPath = Path()

    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawColor(mBgColor as Int)
        mCenterX = width / 2
        mCenterY = height / 2

        //进行画布的旋转，主要用于小圆点跟随手指移动。
        canvas?.rotate(alpha.toFloat(), mCenterX.toFloat(), mCenterY.toFloat())

        alpha = Math.atan(((mTouchX - mCenterX) / (mCenterY - mTouchY)).toDouble())
        alpha = Math.toDegrees(alpha)
        if (mTouchY > mCenterY) {
            alpha = alpha + 180
        }

        rotateCanvas(canvas as Canvas)
        mPaint?.setTextSize(30F)
        mPaint?.setColor(Color.WHITE)
        mPaint?.setStrokeWidth(2F)
        canvas?.drawText("N", mCenterX.toFloat(), 150F, mPaint)
        drawArc(canvas as Canvas)

        drawCircle(canvas as Canvas)

        drawPath(canvas)
    }

    private fun rotateCanvas(canvas: Canvas) {
        mMatrix?.reset()
        mCamera?.save()
        mCamera?.rotateX(mCanvasRotateX)
        mCamera?.rotateY(mCanvasRotateY)
        mCamera?.getMatrix(mMatrix)
        mCamera?.restore()
        mMatrix?.preTranslate((-mCenterX).toFloat(), (-mCenterY).toFloat())
        mMatrix?.postTranslate(mCenterX.toFloat(), mCenterY.toFloat())

        canvas.concat(mMatrix)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val xx: Float? = event?.getX()
        val yy: Float? = event?.getY()
        when (event?.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                rotateCanvasWhenMove(xx as Float, yy as Float)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                rotateCanvasWhenMove(xx as Float, yy as Float)
                invalidate()
                return true
            }
            MotionEvent.ACTION_UP -> {
                mCanvasRotateX = 0F
                mCanvasRotateY = 0F
                invalidate()
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    private fun rotateCanvasWhenMove(x: Float, y: Float) {
        val dx = x - mCenterX
        val dy = y - mCenterY

        var percentX = dx / mCenterX
        var percentY = dy / mCenterY

        if (percentX > 1f) {
            percentX = 1f
        } else if (percentX < -1f) {
            percentX = -1f
        }
        if (percentY > 1f) {
            percentY = 1f
        } else if (percentY < -1f) {
            percentY = -1f
        }

        mCanvasRotateY = mCanvasMaxRotateDegree * percentX
        mCanvasRotateX = -(mCanvasMaxRotateDegree * percentY)
    }


    private fun drawPath(canvas: Canvas) {
        //        mPaint.setColor(Color.parseColor("#FF3366"));
        mPath?.moveTo(mCenterX.toFloat(), 293F)
        mPath?.lineTo((mCenterX - 30).toFloat(), mCenterY.toFloat())
        mPath?.lineTo(mCenterX.toFloat(), (2 * mCenterY - 293).toFloat())
        mPath?.lineTo((mCenterX + 30).toFloat(), mCenterY.toFloat())
        mPath?.lineTo(mCenterX.toFloat(), 293F)
        mPath?.close()

        canvas.drawPath(mPath, mPaint)
        mPaint?.setColor(Color.parseColor("#55227BAE"))
        canvas.drawCircle(mCenterX.toFloat(), mCenterY.toFloat(), 20f, mPaint)
    }

    private fun drawCircle(canvas: Canvas) {
        mPaint?.setAlpha(255)
        canvas.drawCircle(mCenterX.toFloat(), 290f, 10f, mPaint)
    }

    private fun drawArc(canvas: Canvas) {
        canvas.save()
        for (i in 0..119) {

            mPaint?.setAlpha(255 - mAlpha * i / 120)
            canvas.drawLine(mCenterX.toFloat(), 250f, mCenterX.toFloat(), 270f, mPaint)
            canvas.rotate(3f, mCenterX.toFloat(), mCenterY.toFloat())
        }
        canvas.restore()
    }
}