package cn.my.practicedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice3DrawRectView
 * Author: nanzong
 * Date: 2019/4/11 5:17 PM
 * Description:
 * History:
 */
public class Practice3DrawRectView extends View {

    private Paint mPaint;
    private Rect mRect;

    public Practice3DrawRectView(Context context) {
        this(context, null);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mRect = new Rect(100, 100, 500, 500);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //练习内容：使用 canvas.drawRect() 方法画矩形
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(mRect, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(600, 100, 800, 500, mPaint);


        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        canvas.drawRect(400, 700, 800, 900, mPaint);

    }
}
