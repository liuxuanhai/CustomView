package com.hencoder.hencoderpracticedraw4.practice;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.hencoder.hencoderpracticedraw4.R;

/**
 * FileName: Practice13CameraRotateHittingFaceView
 * Author: nanzong
 * Date: 2019/4/24 2:40 PM
 * Description:
 * History:
 */
public class Practice13CameraRotateHittingFaceView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point = new Point(200, 50);
    Camera camera = new Camera();
    Matrix matrix = new Matrix();
    int degree;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 360);



    public Practice13CameraRotateHittingFaceView(Context context) {
        this(context,null);
    }

    public Practice13CameraRotateHittingFaceView(Context context,  AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice13CameraRotateHittingFaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * 2, bitmap.getHeight() * 3, true);
        bitmap.recycle();
        bitmap=scaledBitmap;

        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float newZ = -displayMetrics.density * 60;
        camera.setLocation(0, 0, newZ);
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
        Log.e("RotateHittingFaceView", "---degree-------"+degree);
        this.degree = degree;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = point.x + bitmapWidth / 2;
        int centerY = point.y + bitmapHeight / 2;
        Log.e("RotateHittingFaceView", "---onDraw-------"+degree);

        camera.save();
        matrix.reset();
        camera.rotateX(degree);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point.x, point.y, paint);
        canvas.restore();

    }
}
