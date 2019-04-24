package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice02BeforeOnDrawView
 * Author: nanzong
 * Date: 2019/4/24 9:35 PM
 * Description:
 * History:
 */
public class Practice02BeforeOnDrawView extends AppCompatTextView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF bounds = new RectF();

    public Practice02BeforeOnDrawView(Context context) {
        this(context, null);
    }

    public Practice02BeforeOnDrawView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice02BeforeOnDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setColor(Color.parseColor("#FFC107"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
