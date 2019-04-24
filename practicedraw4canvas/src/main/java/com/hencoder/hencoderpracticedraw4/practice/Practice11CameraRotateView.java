package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

/**
 * FileName: Practice11CameraRotateView
 * Author: nanzong
 * Date: 2019/4/24 11:47 AM
 * Description: Camera 变换- 三维旋转
 * History:
 */
public class Practice11CameraRotateView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice11CameraRotateView(Context context) {
        this(context,null);
    }

    public Practice11CameraRotateView(Context context,  AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11CameraRotateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Camera.rotate*() 一共有四个方法：
//        rotateX(deg) rotateY(deg) rotateZ(deg) rotate(x, y, z)

        Camera camera = new Camera();
        canvas.save();//保存canvas的状态
        camera.save();// 保存 Camera 的三维空间
        camera.rotateX(30); //旋转 Camera 的三维空间
        camera.applyToCanvas(canvas);  //把旋转投影到Canvas
        camera.restore(); //恢复Camera 的状态
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        camera.save();
        camera.rotateY(30);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

    }
}
