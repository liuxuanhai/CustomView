package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice16TextPathView
 * Author: nanzong
 * Date: 2019/4/22 12:42 AM
 * Description: getTextPath() 方法，获取的就是目标文字所对应的 Path 。这个就是所谓「文字的 Path」。
 * History:
 */
public class Practice16TextPathView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path textPath = new Path();
    String text = "Hello HenCoder";

    public Practice16TextPathView(Context context) {
        this(context,null);
    }

    public Practice16TextPathView(Context context,AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice16TextPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    {
        paint.setTextSize(120);

        // 使用 Paint.getTextPath() 来获取文字的 Path
        paint.getTextPath(text, 0, text.length(), 50, 400, textPath);

        pathPaint.setStyle(Paint.Style.STROKE);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(text, 50, 200, paint);

        canvas.drawPath(textPath, pathPaint);
    }

}
