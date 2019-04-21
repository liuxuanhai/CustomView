package cn.my.practicedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice7DrawRoundRectView
 * Author: nanzong
 * Date: 2019/4/12 11:23 AM
 * Description:
 * History:
 */
public class Practice7DrawRoundRectView extends View {
    private Paint mPaint;
    private RectF mRectF;

    public Practice7DrawRoundRectView(Context context) {
        this(context, null);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);

        mRectF = new RectF(100, 100, 600, 200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        canvas.drawRoundRect(mRectF, 50, 50, mPaint);

        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mRectF = new RectF(300, 500, 800, 700);
        canvas.drawRoundRect(mRectF, 120, 120, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mRectF = new RectF(200, 300, 900, 800);
        canvas.drawRoundRect(mRectF, 70, 70, mPaint);
    }
}
