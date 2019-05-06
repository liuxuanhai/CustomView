package com.hencoder.hencoderpracticedraw7.practice.practice01;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.hencoder.hencoderpracticedraw7.R;

/**
 * FileName: Practice01ArgbEvaluatorLayout
 * Author: nanzong
 * Date: 2019/5/6 11:44 AM
 * Description:
 * History:
 */
public class Practice01ArgbEvaluatorLayout extends RelativeLayout {

    Practice01ArgbEvaluatorView view;
    Button animateBt;

    public Practice01ArgbEvaluatorLayout(Context context) {
        super(context);
    }

    public Practice01ArgbEvaluatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ArgbEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = findViewById(R.id.objectAnimatorView);
        animateBt = findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofInt(view, "color", 0xffff0000, 0xff00ff00);
                // 在这里使用 ObjectAnimator.setEvaluator() 来设置 ArgbEvaluator，修复闪烁问题

                //5.0 以上可以直接用这种方式
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ObjectAnimator animator1 = ObjectAnimator.ofArgb(view, "color", 0xffff0000, 0xff00ff00);
                    animator1.setDuration(2000);
                    animator1.start();
                } else {
                    animator.setInterpolator(new LinearInterpolator());
                    //  TypeEvaluator 来计算动画完成度和参数值的关系
                    animator.setEvaluator(new ArgbEvaluator());
                    animator.setDuration(2000);
                    animator.start();
                }
            }
        });
    }
}
