package com.example.administrator.mycontrol.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.mycontrol.R;

/**
 * Created by phantom on 2017/6/29.
 */

public class MyLoadingView extends View {


    private Path mPath;
    private Bitmap bgBitmap;
    //绘制波纹
    private Paint mWavePaint;
    //图形混合模式
    private PorterDuffXfermode mMode = new PorterDuffXfermode(PorterDuff.Mode.XOR);//设置mode 为XOR
    private Canvas mCanvas;
    private Paint mCirclePaint;
    private int mWidth;
    private int mHeight;
    private Bitmap mBitmap;
    //绘制圆
    int x, y;
    boolean isLeft = true;
    private int mPercent;
    private Paint mTextPaint;
    private Paint mPaint;
    private Paint mSRCPaint;

    public MyLoadingView(Context context) {
        super(context, null);
    }

    public MyLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        //设置画笔粗细
        mPaint.setStrokeWidth(10);
        //设置背景bit
        bgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background_main);

        mPath = new Path();
        //抗锯齿
        mPaint.setAntiAlias(false);
        //画笔颜色
        mPaint.setColor(Color.parseColor("#8800ff66"));

        mSRCPaint = new Paint();
        mSRCPaint.setAntiAlias(true);

        mBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        //设置画布大小
        mCanvas = new Canvas(mBitmap);
        mSRCPaint.setColor(Color.parseColor("#88dddddd"));
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mPaint = new Paint();
        //设置画笔粗细
        mPaint.setStrokeWidth(10);
        //设置背景bit
        bgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background_main);

        mPath = new Path();
        //抗锯齿
        mPaint.setAntiAlias(false);
        //画笔颜色
        mPaint.setColor(Color.parseColor("#8800ff66"));

        mSRCPaint = new Paint();
        mSRCPaint.setAntiAlias(true);

        mBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        //设置画布大小
        mCanvas = new Canvas(mBitmap);
        mSRCPaint.setColor(Color.parseColor("#88dddddd"));
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
        }


        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
        }
        y = mHeight;
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (x > 50) {
            isLeft = true;
        } else if (x < 0) {
            isLeft = false;
        }

        if (isLeft) {
            x = x - 1;
        } else {
            x = x + 1;
        }
        Path mPath = new Path();
        mPath.reset();
        y = (int) ((1 - mPercent / 10f) * mHeight);
        mPath.moveTo(0, y);
        mPath.cubicTo(100 + x * 2, 50 + y, 100 + x * 2, y - 50, mWidth, y);//前两个参数是辅助点
        mPath.lineTo(mWidth, mHeight);//充满整个画布
        mPath.lineTo(0, mHeight);//充满整个画布
        mPath.close();

        mBitmap.eraseColor(Color.parseColor("#00000000"));

        mCanvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2, mSRCPaint);

        mPaint.setXfermode(mMode);
        //src
        mCanvas.drawPath(mPath, mPaint);
        mPaint.setXfermode(null);


        canvas.drawBitmap(mBitmap, 0, 0, null);

        String str = mPercent + "";

        mTextPaint.setTextSize(80);
        float txtLength = mTextPaint.measureText(str);

        canvas.drawText(str, mWidth / 2 - txtLength / 2, mHeight / 2 + 15, mTextPaint);

        mTextPaint.setTextSize(40);
        canvas.drawText("%", mWidth / 2 + 50, mHeight / 2 - 20, mTextPaint);
        //刷新界面
        postInvalidateDelayed(10);
    }

    public void setPercent(int percent) {
        mPercent = percent;
    }
}
