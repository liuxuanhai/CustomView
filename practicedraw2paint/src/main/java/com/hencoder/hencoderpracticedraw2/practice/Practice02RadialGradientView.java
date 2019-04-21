package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice02RadialGradientView
 * Author: nanzong
 * Date: 2019/4/19 2:02 PM
 * Description: RadialGradient 辐射渐变
 * History:
 */
public class Practice02RadialGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);


    public Practice02RadialGradientView(Context context) {
        this(context,null);
    }

    public Practice02RadialGradientView(Context context,AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice02RadialGradientView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RadialGradient shader = new RadialGradient(300, 300, 200,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);
    }
}
