package cn.my.practicedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice9DrawPathView
 * Author: nanzong
 * Date: 2019/4/17 3:04 PM
 * Description:
 * History:
 */
public class Practice9DrawPathView extends View {
    private Paint mPaint;
    private Path mPath;

    public Practice9DrawPathView(Context context) {
        this(context, null);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPath = new Path();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);

        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        练习内容：使用 canvas.drawPath() 方法画心形

        mPath.addArc(300, 200, 500, 400, 135, 225);
//        mPath.lineTo(500, 600);
//        mPath.addArc(500, 200, 700, 400, 180, 220);
//        mPath.lineTo(500, 600);

        //另一种形式
        mPath.arcTo(500, 200, 700, 400, 180, 225, false);
        mPath.lineTo(500, 560);
        canvas.drawPath(mPath, mPaint);


////        mPath.addCircle(500,500,20,Path.Direction.CW);
//        canvas.drawPath(mPath, mPaint);


//        mPath.addCircle(300, 300, 200, Path.Direction.CW);
//        canvas.drawPath(mPath,mPaint);

//        mPaint.setColor(Color.GREEN);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeWidth(5);
////        绝对坐标
//        mPath.lineTo(200, 100);//由当前位置（0，0）向（100，100）画一条直线
//
////        相对坐标
//        mPath.rLineTo(500, 0);//由当前位置(100,100) 向正右方 100 像素画一条线
//        canvas.drawPath(mPath,mPaint);

////        不论是直线还是贝塞尔曲线，都是以当前位置作为起点，而不能指定起点。
////        但你可以通过 moveTo(x, y) 或 rMoveTo() 来改变当前位置，从而间接地设置这些方法的起点。
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.lineTo(100, 100);//画斜线
        mPath.moveTo(200, 100);//移动
        mPath.lineTo(200, 100);//画竖线
        canvas.drawPath(mPath, mPaint);


//        这个方法和 Canvas.drawArc() 比起来，少了一个参数 useCenter，而多了一个参数 forceMoveTo 。
//        少了 useCenter ，是因为 arcTo() 只用来画弧形而不画扇形，所以不再需要 useCenter 参数；
//        而多出来的这个 forceMoveTo 参数的意思是，绘制是要「抬一下笔移动过去」，还是「直接拖着笔过去」，
//        区别在于是否留下移动的痕迹。
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPath.lineTo(100, 100);
//        mPath.arcTo(100, 100, 300, 300, -90, 90, true); // 强制移动到弧形起点（无痕迹）
//        mPath.arcTo(100, 100, 300, 300, -90, 90, false); // 强制移动到弧形起点（有痕迹）
//        canvas.drawPath(mPath, mPaint);

//        mPaint.setStyle(Paint.Style.STROKE);
//        mPath.lineTo(100, 100);
//        mPath.addArc(100, 100, 300, 300, -90, 90);
//        canvas.drawPath(mPath,mPaint);

//        自图形未封闭
        mPaint.setStyle(Paint.Style.FILL);
        mPath.moveTo(100, 100);
        mPath.lineTo(200, 100);
        mPath.lineTo(150, 150);
        canvas.drawPath(mPath, mPaint);


        mPaint.setStyle(Paint.Style.STROKE);
        mPath.lineTo(200, 100);
        mPath.addArc(100, 100, 300, 300, -90, 90);
        canvas.drawPath(mPath, mPaint);

        String text = "Hello World";
        mPaint.setTextSize(18);
        canvas.drawText(text, 500, 25, mPaint);
        mPaint.setTextSize(36);
        canvas.drawText(text, 500, 70, mPaint);
        mPaint.setTextSize(60);
        canvas.drawText(text, 500, 145, mPaint);
        mPaint.setTextSize(84);
        canvas.drawText(text, 500, 240, mPaint);


    }
}
