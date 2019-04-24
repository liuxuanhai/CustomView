package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

/**
 * FileName: Practice03TranslateView
 * Author: nanzong
 * Date: 2019/4/22 8:39 PM
 * Description: 几何变换-平移
 * History:
 */
public class Practice03TranslateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);


    public Practice03TranslateView(Context context) {
        this(context,null);
    }

    public Practice03TranslateView(Context context,  AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice03TranslateView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate(-100, -100);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        canvas.save();
        canvas.translate(200, -50);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

    }
}
