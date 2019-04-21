package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice03SweepGradientView
 * Author: nanzong
 * Date: 2019/4/19 2:20 PM
 * Description:SweepGradient 扫描渐变
 * History:
 */
public class Practice03SweepGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice03SweepGradientView(Context context) {
        this(context,null);
    }

    public Practice03SweepGradientView(Context context,AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice03SweepGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Shader shader = new SweepGradient(300, 300,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);
    }
}
