package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice14GetFontMetricsView
 * Author: nanzong
 * Date: 2019/4/22 3:51 PM
 * Description: 通过getFontMetrics方法获取文字显示区域
 * History:
 */
public class Practice14GetFontMetricsView extends View {

    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String[] texts = {"A", "a", "J", "j", "Â", "â"};
    int top = 200;
    int bottom = 400;

    Paint.FontMetrics fontMetrics = new Paint.FontMetrics();

    public Practice14GetFontMetricsView(Context context) {
        this(context,null);
    }

    public Practice14GetFontMetricsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice14GetFontMetricsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);

        //获取文字显示区域（使用该方法只能整体设置所有文字显示区域并取最大值，不能单独设置每个文字显示区域）
        paint2.getFontMetrics(fontMetrics);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getFontMetrics() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐

        int middle = (top + bottom) / 2;
//        float offsetY = (fontMetrics.top + fontMetrics.bottom) / 2;
        float offsetY = (fontMetrics.ascent + fontMetrics.descent) / 2;
        canvas.drawText(texts[0], 100, middle - offsetY, paint2);
        canvas.drawText(texts[1], 200, middle - offsetY, paint2);
        canvas.drawText(texts[2], 300, middle - offsetY, paint2);
        canvas.drawText(texts[3], 400, middle - offsetY, paint2);
        canvas.drawText(texts[4], 500, middle - offsetY, paint2);
        canvas.drawText(texts[5], 600, middle - offsetY, paint2);
    }
}
