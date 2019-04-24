package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice08SetTextSkewXView
 * Author: nanzong
 * Date: 2019/4/22 1:26 PM
 * Description:绘制斜体文字
 * History:
 */
public class Practice08SetTextSkewXView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    public Practice08SetTextSkewXView(Context context) {
        this(context,null);
    }

    public Practice08SetTextSkewXView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice08SetTextSkewXView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        使用Paint.setTextSkewX()来让文字倾斜


//        里边参数值为正数，向左倾斜，参数值为负数，向右倾斜
        paint.setTextSkewX(-0.4f);
        canvas.drawText(text,50,100,paint);

    }
}
