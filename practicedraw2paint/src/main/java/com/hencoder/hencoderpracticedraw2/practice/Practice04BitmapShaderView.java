package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw2.R;

/**
 * FileName: Practice04BitmapShaderView
 * Author: nanzong
 * Date: 2019/4/19 2:23 PM
 * Description: 用 Bitmap 来着色（终于不是渐变了）。其实也就是用 Bitmap 的像素来作为图形或文字的填充。
 * History:
 */
public class Practice04BitmapShaderView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    Context context;

    public Practice04BitmapShaderView(Context context) {
        this(context, null);
        this.context = context;
    }

    public Practice04BitmapShaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }

    public Practice04BitmapShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.batman);
//        Bitmap 的像素来作为图形或文字的填充
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(200, 200, 200, paint);
    }
}
