package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw2.R;

/**
 * FileName: Practice06LightingColorFilterView
 * Author: nanzong
 * Date: 2019/4/19 2:56 PM
 * Description:  颜色过滤器
 * History:
 */
public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice06LightingColorFilterView(Context context) {
        this(context, null);
    }

    public Practice06LightingColorFilterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice06LightingColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        ColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff, 0x000000);
        paint.setColorFilter(lightingColorFilter);
        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter

        // 第一个 LightingColorFilter：去掉红色部分
        canvas.drawBitmap(bitmap, 0, 0, paint);

        /*
         * 具体的颜色要如何搭配，直接找设计师就好了
         * */
        ColorFilter lightingColorFilter1 = new LightingColorFilter(0xffffff, 0x003000);
        paint.setColorFilter(lightingColorFilter1);

        // 第二个 LightingColorFilter：增强绿色部分
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);

    }
}

