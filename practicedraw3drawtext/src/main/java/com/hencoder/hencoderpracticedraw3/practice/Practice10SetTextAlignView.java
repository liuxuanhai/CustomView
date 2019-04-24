package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * FileName: Practice10SetTextAlignView
 * Author: nanzong
 * Date: 2019/4/22 2:40 PM
 * Description: 设置文字对齐方式
 * History:
 */
public class Practice10SetTextAlignView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    public Practice10SetTextAlignView(Context context) {
        this(context, null);
    }

    public Practice10SetTextAlignView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10SetTextAlignView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setTextAlign() 来调整文字对齐方式

//        第一处使用Paint.Align.LEFT
//        文字显示在绘制起点的右边
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(text, getWidth() / 2, 100, paint);

        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, getWidth() / 2, 200, paint);

        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(text, getWidth() / 2, 300, paint);


        canvas.drawText(getWidth() + "", getWidth() / 2, 500, paint);
        canvas.drawText(getHeight() + "", getWidth() / 2, 700, paint);


    }
}
