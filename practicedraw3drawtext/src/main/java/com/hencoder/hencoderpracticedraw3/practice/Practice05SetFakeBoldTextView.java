package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice05SetFakeBoldTextView
 * Author: nanzong
 * Date: 2019/4/22 10:53 AM
 * Description: 设置伪粗体文字
 * History:
 */
public class Practice05SetFakeBoldTextView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    public Practice05SetFakeBoldTextView(Context context) {
        this(context, null);
    }

    public Practice05SetFakeBoldTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice05SetFakeBoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        使用Paint.setFakeBoldText() 来加粗文字

        canvas.save();

        canvas.drawText(text, 50, 100, paint);

        paint.setFakeBoldText(true);
        canvas.drawText(text, 50, 200, paint);

        canvas.restore();
    }
}
