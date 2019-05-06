package com.hencoder.hencoderpracticedraw7.practice.practice03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw7.Utils;

/**
 * FileName: Practice03OfObjectView
 * Author: nanzong
 * Date: 2019/5/6 2:58 PM
 * Description:
 * History:
 */
public class Practice03OfObjectView extends View {
    public static final float RADIUS = Utils.dpToPixel(20);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    PointF position = new PointF();

    public Practice03OfObjectView(Context context) {
        super(context);
    }

    public Practice03OfObjectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03OfObjectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PointF getPosition() {
        return position;
    }

    public void setPosition(PointF position) {
        if (position != null) {
            this.position = position;
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float innterPaddingLeft = RADIUS * 1;
        float innterPaddingRight = RADIUS * 1;
        float innterPaddingTop = RADIUS * 1;
        float innterPaddingBottom = RADIUS * 3;
        float width = getWidth() - innterPaddingLeft - innterPaddingRight - RADIUS * 2;
        float height = getHeight() - innterPaddingTop - innterPaddingBottom - RADIUS * 2;

        paint.setColor(Color.parseColor("#009688"));
        canvas.drawCircle(innterPaddingLeft + RADIUS + width * position.x, innterPaddingTop + RADIUS + height * position.y, RADIUS, paint);
    }
}
