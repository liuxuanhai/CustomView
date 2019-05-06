package com.hencoder.hencoderpracticedraw6.practice.practice08;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.hencoder.hencoderpracticedraw6.R;

/**
 * FileName: Practice08ObjectAnimatorLayout
 * Author: nanzong
 * Date: 2019/5/6 11:04 AM
 * Description:
 * History:
 */
public class Practice08ObjectAnimatorLayout extends RelativeLayout {
    Practice08ObjectAnimatorView view;
    Button animateBt;
    int index;
    ObjectAnimator animator;


    public Practice08ObjectAnimatorLayout(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
                //TODO 在这里处理点击事件，用ObjectAnimatot播放动画
                //1、用ObjectAnimatot 创建 Animator 对象
                //2、用start()执行动画
                //*. 记得在 Practice08ObjectAnimatorView 中为 progress 添加 setter/ getter 方法！
                if (index == 0) {
                    animator = ObjectAnimator.ofFloat(view, "progress", 0, 66);
                    index = 1;
                } else {
                    animator = ObjectAnimator.ofFloat(view, "progress", 0, 66);
                    index = 0;
                }
                animator.setDuration(600).start();

            }
        });
    }
}
