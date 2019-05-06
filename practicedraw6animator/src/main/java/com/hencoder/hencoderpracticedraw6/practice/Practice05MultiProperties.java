package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.hencoder.hencoderpracticedraw6.R;

/**
 * FileName: Practice05MultiProperties
 * Author: nanzong
 * Date: 2019/5/6 9:58 AM
 * Description:
 * History:
 */
public class Practice05MultiProperties extends ConstraintLayout {

    Button animateBt;
    ImageView imageView;
    int index;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);

        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 在这里处理点击事件，同时对多个属性做动画
                if (index == 0) {
                    imageView.animate()
                            .rotation(360)
                            .translationX(600)
                            .scaleX(1)
                            .scaleY(1)
                            .alpha(1);
                    index = 1;
                } else {
                    imageView.animate()
                            .rotation(0)
                            .translationX(0)
                            .scaleX(0)
                            .scaleY(0)
                            .alpha(0);
                    index = 0;
                }
            }
        });
    }
}
