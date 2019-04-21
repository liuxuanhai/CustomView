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
 * FileName: Practice5DrawOvalView
 * Author: nanzong
 * Date: 2019/4/12 10:54 AM
 * Description:
 * History:
 */
public class Practice5DrawOvalView extends View {

   private Paint mPaint;

    public Practice5DrawOvalView(Context context) {
        this(context,null);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //练习内容：使用 canvas.drawOval() 方法画椭圆
        mPaint.setColor(Color.YELLOW);
        canvas.drawOval(100,200,300,500,mPaint);

        RectF mRectf = new RectF(300,300,900,600);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.RED);
        canvas.drawOval(mRectf,mPaint);


        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.RED);
        mPaint.setColor(Color.BLUE);
        canvas.drawOval(100,200,1000,900,mPaint);

        //最后画的在最上层
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.YELLOW);
        canvas.drawOval(100,200,300,500,mPaint);
    }
}
