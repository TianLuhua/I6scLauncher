package com.boyue.boyuelauncher.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.boyue.boyuelauncher.R;

/**
 * 中间带有字体的 ProgressBar
 * Created by Tianluhua on 2018\7\4 0004.
 */
public class TextProgressBar extends ProgressBar {

    //基本属性
    private String mText;
    private int mTextColor;
    private int mTextSize;

    //画笔、文本绘制范围
    private Rect mBound;
    private Paint mPaint;

    public TextProgressBar(Context context) {
        super(context);
    }

    public TextProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TextProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        //读取自定义的属性
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextProgressBar);
        mText = a.getString(R.styleable.TextProgressBar_text);
        mTextColor = a.getColor(R.styleable.TextProgressBar_textColor, Color.BLACK);
        mTextSize = a.getDimensionPixelSize(R.styleable.TextProgressBar_textSize, 20);
        a.recycle();

        //初始化画笔
        mBound = new Rect();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(mTextSize);
        mPaint.getTextBounds(mText, 0, mText.length(), mBound);

    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制文字
        mPaint.setColor(mTextColor);
        float startX = getWidth() / 2 - mBound.centerX();
        float startY = getHeight() / 2 - mBound.centerY();
        canvas.drawText(mText, startX, startY, mPaint);
    }

}
