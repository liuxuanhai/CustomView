package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice07SetUnderlineTextView
 * Author: nanzong
 * Date: 2019/4/22 11:08 AM
 * Description: 绘制下划线
 * History:
 */
public class Practice07SetUnderlineTextView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    public Practice07SetUnderlineTextView(Context context) {
        this(context,null);
    }

    public Practice07SetUnderlineTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice07SetUnderlineTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 Paint.setUnderlineText() 来设置下划线

        paint.setUnderlineText(true);
        canvas.drawText(text, 50, 100, paint);
    }
}
