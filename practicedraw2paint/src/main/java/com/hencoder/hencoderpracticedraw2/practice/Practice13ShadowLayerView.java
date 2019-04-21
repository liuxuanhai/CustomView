package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice13ShadowLayerView
 * Author: nanzong
 * Date: 2019/4/22 12:31 AM
 * Description: 在之后的绘制内容下面加一层阴影。
 * History:
 */
public class Practice13ShadowLayerView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice13ShadowLayerView(Context context) {
        this(context,null);
    }

    public Practice13ShadowLayerView(Context context,AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice13ShadowLayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 使用 Paint.setShadowLayer() 设置阴影
        paint.setShadowLayer(10, -5, 0, Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextSize(120);
        canvas.drawText("Hello HenCoder", 50, 200, paint);
    }
}
