package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

/**
 * FileName: Practice04ScaleView
 * Author: nanzong
 * Date: 2019/4/23 9:06 AM
 * Description: 几何变换-放缩
 * History:
 */
public class Practice04ScaleView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice04ScaleView(Context context) {
        this(context,null);
    }

    public Practice04ScaleView(Context context,AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice04ScaleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
//        sx sy 是横向和纵向的放缩倍数； px py 是放缩的轴心。
        canvas.scale(1.3f, 1.3f, point1.x + bitmap.getWidth() / 2, point1.y + bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.scale(0.6f, 0.6f, point2.x + bitmap.getWidth() / 2, point2.y + bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

    }
}
