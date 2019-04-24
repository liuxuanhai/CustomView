package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw4.R;

/**
 * FileName: Practice07MatrixTranslateView
 * Author: nanzong
 * Date: 2019/4/24 9:10 AM
 * Description: 使用 Matrix 来做自定义变换-平移
 * History:
 */
public class Practice07MatrixTranslateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);


    public Practice07MatrixTranslateView(Context context) {
        this(context,null);
    }

    public Practice07MatrixTranslateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice07MatrixTranslateView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        把 Matrix 应用到 Canvas 有两个方法： Canvas.setMatrix(matrix) 和 Canvas.concat(matrix)。
//        Canvas.setMatrix(matrix)：用 Matrix 直接替换 Canvas 当前的变换矩阵，
//        即抛弃 Canvas 当前的变换，改用 Matrix 的变换（注：根据下面评论里以及我在微信公众号中收到的反馈，
//        不同的系统中 setMatrix(matrix) 的行为可能不一致，所以还是尽量用 concat(matrix) 吧）；
//        Canvas.concat(matrix)：用 Canvas 当前的变换矩阵和 Matrix 相乘，即基于 Canvas 当前的变换，
//        叠加上 Matrix 中的变换。

        Matrix matrix = new Matrix();

        matrix.postTranslate(-100, -100);

        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        matrix.reset();
        matrix.postTranslate(200, 0);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

    }
}
