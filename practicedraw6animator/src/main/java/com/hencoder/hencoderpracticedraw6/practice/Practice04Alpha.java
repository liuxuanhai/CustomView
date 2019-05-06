package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.hencoder.hencoderpracticedraw6.R;

/**
 * FileName: Practice04Alpha
 * Author: nanzong
 * Date: 2019/5/6 9:53 AM
 * Description:
 * History:
 */
public class Practice04Alpha extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    int index;

    public Practice04Alpha(Context context) {
        super(context);
    }

    public Practice04Alpha(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04Alpha(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，通过 View.animate().alpha() 来改变 View 的透明度
                if (index == 0) {
                    imageView.animate().alpha(0);
                    index = 1;
                } else {
                    imageView.animate().alpha(0.1f);
                    index = 0;
                }
            }
        });

    }
}
