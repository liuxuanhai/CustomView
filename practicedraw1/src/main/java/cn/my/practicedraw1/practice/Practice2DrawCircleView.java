package cn.my.practicedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * FileName: Practice2DrawCircleView
 * Author: nanzong
 * Date: 2019/4/11 10:34 AM
 * Description:
 * History:
 */
public class Practice2DrawCircleView extends View {
    private Paint mPaint;

    public Practice2DrawCircleView(Context context) {
        this(context, null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化
        mPaint = new Paint();
        //设置抗锯齿开关
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //练习内容：使用 canvas.drawCircle() 方法画圆
        //一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        // mPaint 提供基本信息之外的所有风格信息，例如颜色、线条粗细、阴影等。
        // 设置颜色
        mPaint.setColor(Color.BLACK);
        //画圆
        canvas.drawCircle(200, 200, 100, mPaint);


        //设置绘制模式
        // Paint.Style.STROKE 画线模式
        // Paint.Style.FILL填充模式（默认）
        // Paint.Style.FILL_AND_STROKE  即画线又填充
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        //前两个参数centerX centerY 圆心坐标，radius 是半径 单位都是像素
        canvas.drawCircle(500, 200, 100, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(200, 500, 100, mPaint);

        //画圆环
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        //设置线条宽度 像素   Paint.setStrokeWidth(float width)
        mPaint.setStrokeWidth(50);
        canvas.drawCircle(500, 500, 150, mPaint);

    }
}
