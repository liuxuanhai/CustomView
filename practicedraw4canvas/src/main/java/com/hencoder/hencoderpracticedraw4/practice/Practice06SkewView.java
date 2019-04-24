package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

/**
 * FileName: Practice06SkewView
 * Author: nanzong
 * Date: 2019/4/24 9:03 AM
 * Description: 几何变换-错切
 * History:
 */
public class Practice06SkewView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);


    public Practice06SkewView(Context context) {
        this(context,null);
    }

    public Practice06SkewView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice06SkewView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
//        参数里的 sx 和 sy 是 x 方向和 y 方向的错切系数。
        canvas.skew(0f, 0.5f);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.skew(-0.5f, 0f);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();


    }
}
