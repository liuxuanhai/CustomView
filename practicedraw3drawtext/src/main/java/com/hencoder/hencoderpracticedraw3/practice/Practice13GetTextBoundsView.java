package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice13GetTextBoundsView
 * Author: nanzong
 * Date: 2019/4/22 3:07 PM
 * Description: 通过getTextBounds方法获取文字显示区域
 * History:
 */
public class Practice13GetTextBoundsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    int top = 200;
    int bottom = 400;

    String[] text = {"A", "a", "J", "j", "Â", "â"};
    float[] offsetY = new float[text.length];

    Rect rect = new Rect();

    public Practice13GetTextBoundsView(Context context) {
        this(context,null);
    }

    public Practice13GetTextBoundsView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice13GetTextBoundsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差
        // 哪个paint负责绘制文字，则由那个paint获取文字显示区域
        paint2.getTextBounds(text[0], 0, text[0].length(), rect);
        offsetY[0] = (rect.top + rect.bottom) / 2;
        paint2.getTextBounds(text[1], 0, text[1].length(), rect);
        offsetY[1] = (rect.top + rect.bottom) / 2;
        paint2.getTextBounds(text[2], 0, text[2].length(), rect);
        offsetY[2] = (rect.top + rect.bottom) / 2;
        paint2.getTextBounds(text[3], 0, text[3].length(), rect);
        offsetY[3] = (rect.top + rect.bottom) / 2;
        paint2.getTextBounds(text[4], 0, text[4].length(), rect);
        offsetY[4] = (rect.top + rect.bottom) / 2;
        paint2.getTextBounds(text[5], 0, text[5].length(), rect);
        offsetY[5] = (rect.top + rect.bottom) / 2;

        int middle = (top + bottom) / 2;
        canvas.drawText(text[0], 100, middle - offsetY[0], paint2);
        canvas.drawText(text[1], 200, middle - offsetY[1], paint2);
        canvas.drawText(text[2], 300, middle - offsetY[2], paint2);
        canvas.drawText(text[3], 400, middle - offsetY[3], paint2);
        canvas.drawText(text[4], 500, middle - offsetY[4], paint2);
        canvas.drawText(text[5], 600, middle - offsetY[5], paint2);

        canvas.restore();
    }
}




