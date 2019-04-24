package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice11GetFontSpacingView
 * Author: nanzong
 * Date: 2019/4/22 2:50 PM
 * Description: 设置文字行距
 * History:
 */
public class Practice11GetFontSpacingView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    public Practice11GetFontSpacingView(Context context) {
        this(context, null);
    }

    public Practice11GetFontSpacingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11GetFontSpacingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(60);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        使用 Paint.getFontSpacing()来获取推荐的行距
        float spacing = 20;

        float spacing2 = paint.getFontSpacing();

        canvas.drawText(text, 50, 100, paint);

        canvas.drawText(text, 50, 100 + spacing2, paint);

        canvas.drawText(text, 50, 100 + spacing2 * 2, paint);
    }
}
