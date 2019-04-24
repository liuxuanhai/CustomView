package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice04SetTypefaceView
 * Author: nanzong
 * Date: 2019/4/22 10:42 AM
 * Description: 设置字体样式
 * History:
 */
public class Practice04SetTypefaceView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";
    Typeface typeface;

    public Practice04SetTypefaceView(Context context) {
        this(context, null);
    }

    public Practice04SetTypefaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice04SetTypefaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setTextSize(60);
        typeface = Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        使用Paint.setTypeface()来设置不同的字体

//        第一处：填入null来设置默认字体
        paint.setTypeface(null);
        paint.setTextSize(40);
        canvas.drawText(text, 50, 100, paint);

        //第二处：填入Typeface.SERIF 来设置衬线字体（宋体）
        paint.setTypeface(Typeface.SERIF);
        paint.setTextSize(60);
        canvas.drawText(text, 50, 200, paint);

        //第三处：填入typeface 对象来使用 assets 目录下的 "Satisfy-Regular.ttf" 文件
        paint.setTypeface(typeface);
        paint.setTextSize(80);
        canvas.drawText(text, 50, 300, paint);


    }
}
