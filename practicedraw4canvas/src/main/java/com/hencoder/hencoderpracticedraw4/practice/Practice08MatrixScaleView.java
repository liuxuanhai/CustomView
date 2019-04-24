package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

/**
 * FileName: Practice08MatrixScaleView
 * Author: nanzong
 * Date: 2019/4/24 9:29 AM
 * Description: 使用 Matrix 来做自定义变换-缩放
 * History:
 */
public class Practice08MatrixScaleView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice08MatrixScaleView(Context context) {
        this(context,null);
    }

    public Practice08MatrixScaleView(Context context,  AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice08MatrixScaleView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        Matrix matrix = new Matrix();
        matrix.postScale(1.3f, 1.3f, point1.x + bitmapWidth / 2, point1.y + bitmapHeight / 2);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        matrix.reset();
        matrix.postScale(0.3f, 1.3f, point2.x + bitmapWidth / 2, point2.y + bitmapHeight / 2);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

    }
}
