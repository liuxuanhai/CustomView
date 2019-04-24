package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

/**
 * FileName: Practice02ClipPathView
 * Author: nanzong
 * Date: 2019/4/22 8:27 PM
 * Description:范围裁切
 * History:
 */
public class Practice02ClipPathView extends View {
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Path mPath1 = new Path();
    Path mPath2 = new Path();

    public Practice02ClipPathView(Context context) {
        this(context, null);
    }

    public Practice02ClipPathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice02ClipPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mPath1.addCircle(point1.x + 200, point1.y + 200, 150, Path.Direction.CW);

//        设置
        mPath2.setFillType(Path.FillType.INVERSE_WINDING);
        mPath2.addCircle(point2.x + 200, point2.y + 200, 150, Path.Direction.CW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.clipPath(mPath1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.clipPath(mPath2);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();


    }
}
