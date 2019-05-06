package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
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

        // 把下面的绘制代码移到 super.onDraw() 的上面，就可以让原主体内容盖住你的绘制代码了
        /*先画背景  再绘制主题的TextView*/

        Layout layout = getLayout();
        bounds.left = layout.getLineLeft(1);
        bounds.right = layout.getLineRight(1);
        bounds.top = layout.getLineTop(1);
        bounds.bottom = layout.getLineBottom(1);
        canvas.drawRect(bounds, paint);
        Log.e("BeforeOnDrawView", "---" + layout.getLineCount());
        bounds.left = layout.getLineLeft(layout.getLineCount() - 3);
        bounds.right = layout.getLineRight(layout.getLineCount() - 3);
        bounds.top = layout.getLineTop(layout.getLineCount() - 3);
        bounds.bottom = layout.getLineBottom(layout.getLineCount() - 3);
        canvas.drawRect(bounds, paint);
        super.onDraw(canvas);


    }
}
