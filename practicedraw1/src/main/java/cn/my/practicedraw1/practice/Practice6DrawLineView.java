package cn.my.practicedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice6DrawLineView
 * Author: nanzong
 * Date: 2019/4/12 11:13 AM
 * Description:
 * History:
 */
public class Practice6DrawLineView extends View {
    Paint mPaint;

    public Practice6DrawLineView(Context context) {
        this(context, null);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //练习内容：使用 canvas.drawLine() 方法画直线
        mPaint.setStrokeWidth(10);
        //开始横纵坐标，结束横纵坐标
        canvas.drawLine(100, 100, 600, 600, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(900, 900, 200, 100, mPaint);

        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(15);
        canvas.drawLine(100, 900, 700, 100, mPaint);

    }
}
