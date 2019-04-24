package com.hencoder.hencoderpracticedraw4.practice;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.hencoder.hencoderpracticedraw4.R;

/**
 * FileName: Practice14FlipboardView
 * Author: nanzong
 * Date: 2019/4/24 2:58 PM
 * Description: 翻页效果
 * History:
 */
public class Practice14FlipboardView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Camera camera = new Camera();
    int degree;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 180);


    public Practice14FlipboardView(Context context) {
        this(context,null);
    }

    public Practice14FlipboardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice14FlipboardView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        animator.setDuration(2500);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float newZ = -displayMetrics.density * 6;
        camera.setLocation(0, 0,newZ);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    @SuppressWarnings("unused")
    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;
        // 第一遍绘制：上半部分
        canvas.save();
        canvas.clipRect(0,0,getWidth(),centerY);
        canvas.drawBitmap(bitmap, x,y,paint);

        canvas.restore();
        // 第二遍绘制：下半部分
        canvas.save();
        // 判断旋转角度
        if (degree < 90) {
            canvas.clipRect(0,centerY,getWidth(),getHeight());
        } else {
            canvas.clipRect(0,0,getWidth(),centerY);
        }


        camera.save();
        camera.rotateX(degree);
        canvas.translate(centerX, centerY);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        camera.restore();

        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();
    }
}
