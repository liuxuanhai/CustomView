package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * FileName: Sample06BeforeOnDrawForegroundView
 * Author: nanzong
 * Date: 2019/4/29 10:04 AM
 * Description:
 * History:
 */
public class Practice06BeforeOnDrawForegroundView extends AppCompatImageView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice06BeforeOnDrawForegroundView(Context context) {
        super(context);
    }

    public Practice06BeforeOnDrawForegroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06BeforeOnDrawForegroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {

        //在super.onDrawForeground() 的上方插入绘制代码，让绘制内容被前景色盖住
        //由于这期的重点是绘制代码的位置，而不是绘制代码本身，所以直接给出绘制代码
        paint.setColor(Color.parseColor("#f44336"));
        canvas.drawRect(0, 40, 200, 120, paint);
        paint.setTextSize(60);
        paint.setColor(Color.WHITE);
        canvas.drawText("New", 20, 100, paint);
        super.onDrawForeground(canvas);
    }
}
