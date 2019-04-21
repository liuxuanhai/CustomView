package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * LinearGradient 线性渐变
 */
public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //着色器
        Shader shader = new LinearGradient(100, 100, 500, 500,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        // 设置两个点和两种颜色，以这两个点作为端点，使用两种颜色的渐变来绘制颜色

        //TileMode 一共有 3 个值可选： CLAMP, MIRROR 和 REPEAT.CLAMP  会在端点之外延续端点处的颜色；
        // MIRROR 是镜像模式
        // REPEAT 是重复模式。

        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);

        Shader shader1 = new LinearGradient(100, 100, 500, 500,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);

        paint.setShader(shader1);
        paint.setTextSize(120);
        canvas.drawText("Helllo  World", 300, 700, paint);
    }
}
