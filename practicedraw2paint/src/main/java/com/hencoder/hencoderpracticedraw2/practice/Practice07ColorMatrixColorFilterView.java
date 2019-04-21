package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw2.R;

/**
 * FileName: Practice07ColorMatrixColorFilterView
 * Author: nanzong
 * Date: 2019/4/21 12:05 PM
 * Description:
 * History:
 */
public class Practice07ColorMatrixColorFilterView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;


    public Practice07ColorMatrixColorFilterView(Context context) {
        this(context,null);
    }

    public Practice07ColorMatrixColorFilterView(Context context,  AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice07ColorMatrixColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);

        ColorFilter lightingColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(lightingColorFilter);

        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
