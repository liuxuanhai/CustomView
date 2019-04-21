package cn.my.practicedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice4DrawPointView
 * Author: nanzong
 * Date: 2019/4/11 5:23 PM
 * Description:
 * History:
 */
public class Practice4DrawPointView extends View {
    private Paint mPaint;

    public Practice4DrawPointView(Context context) {
        this(context, null);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        //设置画笔颜色
        mPaint.setColor(Color.GREEN);
        //设置线条宽度
        mPaint.setStrokeWidth(300);
        //设置抗锯齿
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(200, 200, mPaint);

        mPaint.setStrokeWidth(250);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(700, 200, mPaint);

        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(200);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(700, 700, mPaint);

    }
}
