package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw2.R;

/**
 * FileName: Practice05ComposeShaderView
 * Author: nanzong
 * Date: 2019/4/19 2:36 PM
 * Description: ComposeShader 混合着色器
 * History:
 */
public class Practice05ComposeShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice05ComposeShaderView(Context context) {
        this(context, null);
    }

    public Practice05ComposeShaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice05ComposeShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 第一个 Shader：头像的 Bitmap
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Shader shader1 = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);

        // 第二个 Shader：从上到下的线性渐变（由透明到黑色）
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
        Shader shader2 = new BitmapShader(bitmap2, Shader.TileMode.MIRROR, Shader.TileMode.CLAMP);

        Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.DST_OUT);

        /*
         *  PorterDuff.Mode 是用来指定两个图像共同绘制时的颜色策略的
         *  PorterDuff.Mode.DST_OUT，就会变成挖空效果
         *  PorterDuff.Mode.DST_IN，就会变成蒙版抠图效果：
         **/

        paint.setShader(shader);
        canvas.drawCircle(200, 200, 200, paint);
    }
}
