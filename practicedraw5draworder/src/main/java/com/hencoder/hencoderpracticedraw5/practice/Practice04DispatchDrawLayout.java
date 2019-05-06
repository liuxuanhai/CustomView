package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * FileName: Practice04DispatchDrawLayout
 * Author: nanzong
 * Date: 2019/4/25 4:39 PM
 * Description:
 * History:
 */
public class Practice04DispatchDrawLayout extends LinearLayout {
    Pattern pattern = new Pattern();

    public Practice04DispatchDrawLayout(Context context) {
        this(context,null);
    }

    public Practice04DispatchDrawLayout(Context context,AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice04DispatchDrawLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);

    }

    // 把 onDraw() 换成 dispatchDraw()，让绘制内容可以盖住子 View
    // 另外，在改完之后，上面的 setWillNotDraw(false) 也可以删了
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        pattern.draw(canvas);
//    }


//    在绘制过程中，每一个 ViewGroup 会先调用自己的  onDraw() 来绘制完自己的主体之后再去绘制它的子 View。
//    对于上面这个例子来说，就是你的  LinearLayout 会在绘制完斑点后再去绘制它的子 View。
//    那么在子 View 绘制完成之后，先前绘制的斑点就被子 View 盖住了。


    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        pattern.draw(canvas);
    }

    private class Pattern {
        private static final float PATTERN_RATIO = 5f / 6;

        Paint patternPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Spot[] spots;

        private Pattern() {
            spots = new Spot[4];
            spots[0] = new Spot(0.14f, 0.3f, 0.026f);
            spots[1] = new Spot(0.59f, 0.25f, 0.067f);
            spots[2] = new Spot(0.22f, 0.6f, 0.067f);
            spots[3] = new Spot(0.52f, 0.78f, 0.083f);
        }

        private Pattern(Spot[] spots) {
            this.spots = spots;
        }

        {
            patternPaint.setColor(Color.parseColor("#A0E91E63"));
        }

        private void draw(Canvas canvas) {
            int repitition = (int) Math.ceil((float) getWidth() / getHeight());
            for (int i = 0; i < spots.length * repitition; i++) {
                Spot spot = spots[i % spots.length];
                canvas.drawCircle(i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(), spot.relativeY * getHeight(), spot.relativeSize * getHeight(), patternPaint);
            }
        }

        private class Spot {
            private float relativeX;
            private float relativeY;
            private float relativeSize;

            private Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
