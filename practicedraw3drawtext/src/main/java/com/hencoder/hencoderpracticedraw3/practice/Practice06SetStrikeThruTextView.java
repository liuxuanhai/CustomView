package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice06SetStrikeThruTextView
 * Author: nanzong
 * Date: 2019/4/22 11:05 AM
 * Description: 绘制删除线
 * History:
 */
public class Practice06SetStrikeThruTextView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    public Practice06SetStrikeThruTextView(Context context) {
        this(context, null);
    }

    public Practice06SetStrikeThruTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice06SetStrikeThruTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrikeThruText(true);
        canvas.drawText(text, 50, 100, paint);
    }
}
