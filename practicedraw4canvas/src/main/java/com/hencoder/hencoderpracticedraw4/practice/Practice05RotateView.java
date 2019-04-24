package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

/**
 * FileName: Practice05RotateView
 * Author: nanzong
 * Date: 2019/4/23 9:20 AM
 * Description:几何变换-旋转
 * History:
 */
public class Practice05RotateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);


    public Practice05RotateView(Context context) {
        this(context, null);
    }

    public Practice05RotateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice05RotateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        Log.e("onDrawSize", "-bitmapHeight----" + bitmapHeight);
        Log.e("onDrawSize", "-bitmapWidth----" + bitmapWidth);

        Log.e("onDrawSize", "-bitmapWidth----" + getHeight());
        Log.e("onDrawSize", "-bitmapWidth----" + getWidth());

        Log.e("onDrawSize", "-bitmapWidth----" + (point1.x + bitmapWidth / 2));
        Log.e("onDrawSize", "-bitmapWidth----" + (point1.y + bitmapHeight / 2));

        Log.e("onDrawSize", "-bitmapWidth----" + (point1.x + getWidth() / 2));
        Log.e("onDrawSize", "-bitmapWidth----" + (point1.y + getHeight() / 2));


        canvas.save();
        //参数里的 degrees 是旋转角度，单位是度（也就是一周有 360° 的那个单位），方向是顺时针为正向；
        //px 和 py 是轴心的位置。
        canvas.rotate(180, point1.x + bitmapWidth / 2, point1.y + bitmapHeight / 2);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.rotate(45, point2.x + bitmapWidth / 2, point2.y + bitmapHeight);
        canvas.drawBitmap(bitmap, point2.x, point1.y, paint);
        canvas.restore();

    }
}
