package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice09SetTextScaleXView
 * Author: nanzong
 * Date: 2019/4/22 2:37 PM
 * Description:绘制文字宽度缩放
 * History:
 */
public class Practice09SetTextScaleXView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    public Practice09SetTextScaleXView(Context context) {
        this(context,null);
    }

    public Practice09SetTextScaleXView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice09SetTextScaleXView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setTextScaleX() 来改变文字宽度

        canvas.save();

        canvas.drawText(text, 50, 100, paint);

        //该方法不会改变文字高度
        paint.setTextScaleX(2.0f);
        canvas.drawText(text, 50, 300, paint);
        canvas.restore();
    }
}
