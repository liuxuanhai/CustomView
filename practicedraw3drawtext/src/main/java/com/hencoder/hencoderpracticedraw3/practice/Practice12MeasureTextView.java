package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice12MeasureTextView
 * Author: nanzong
 * Date: 2019/4/22 2:56 PM
 * Description:  测量文字绘制时所占用的宽度
 * History:
 */
public class Practice12MeasureTextView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "三个月内你胖了";
    String text2 = "4.5";
    String text3 = "公斤";

    public Practice12MeasureTextView(Context context) {
        this(context, null);
    }

    public Practice12MeasureTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice12MeasureTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint1.setTextSize(60);
        paint2.setTextSize(120);
        paint2.setColor(Color.parseColor("#E91E63"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //使用Paint.measureText 测量出文字宽度 让文字可以相邻绘制
        canvas.drawText(text1, 50, 200, paint1);
        canvas.drawText(text2, 50 + 100, 200, paint2);
        canvas.drawText(text3, 50 + 200, 200, paint1);

        //获取文字宽度
        float text1Width = paint1.measureText(text1);
        float text2Width = paint2.measureText(text2);

        canvas.drawText(text1, 50, 400, paint1);
        canvas.drawText(text2, 50 + text1Width, 400, paint2);
        canvas.drawText(text3, 50 + text1Width + text2Width, 400, paint1);

    }
}
