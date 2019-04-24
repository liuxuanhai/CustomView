package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice02StaticLayoutView
 * Author: nanzong
 * Date: 2019/4/22 10:10 AM
 * Description: 设置文字换行  StaticLayout 支持换行，它既可以为文字设置宽度上限来让文字自动换行，也会在 \n 处主动换行。
 * History:
 */
public class Practice02StaticLayoutView extends View {
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello\nHenCoder";

    StaticLayout staticLayout;

    public Practice02StaticLayoutView(Context context) {
        this(context, null);
    }

    public Practice02StaticLayoutView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice02StaticLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        textPaint.setTextSize(60);

//        StaticLayout(CharSequence source, TextPaint paint, int width, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad)，其中参数里：

//        width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
//        align 是文字的对齐方向；
//        spacingmult 是行间距的倍数，通常情况下填 1 就好；
//        spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
//        includepad 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。

//        如果你需要进行多行文字的绘制，并且对文字的排列和样式没有太复杂的花式要求，那么使用  StaticLayout 就好。
        staticLayout = new StaticLayout(text, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
        canvas.drawText(text, 50, 100, textPaint);

        canvas.translate(50, 200);
        staticLayout.draw(canvas);

        canvas.restore();
    }
}
