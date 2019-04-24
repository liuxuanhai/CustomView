package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice01DrawTextView
 * Author: nanzong
 * Date: 2019/4/22 10:06 AM
 * Description: 绘制文字
 * History:
 */
public class Practice01DrawTextView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";
    Paint mPaint;
    Path mPath;

    public Practice01DrawTextView(Context context) {
        this(context, null);
    }

    public Practice01DrawTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice01DrawTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPath = new Path();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);

        mPath = new Path();
    }

    {
        paint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        使用drawText()来绘制文字
        canvas.drawText(text, 50, 100, paint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(100);
        mPath.lineTo(600, 500);
        mPath.lineTo(800, 900);
//        mPath.addArc(100, 100, 300, 300, -90, 90);
        canvas.drawPath(mPath, mPaint);

        canvas.drawTextOnPath("Hello World！Hello World！",mPath,0,0,mPaint);
    }
}
