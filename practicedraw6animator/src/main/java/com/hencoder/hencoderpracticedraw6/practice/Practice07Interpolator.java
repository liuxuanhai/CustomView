package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.graphics.Path;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.hencoder.hencoderpracticedraw6.R;
import com.hencoder.hencoderpracticedraw6.Utils;

/**
 * FileName: Practice07Interpolator
 * Author: nanzong
 * Date: 2019/5/6 10:57 AM
 * Description:
 * History:
 * Interpolator 就别练了，没什么好练的，Practice 和 Sample 的代码是一毛一样的。
 * 它的关键是理解，所以还是去看几眼实际效果吧。
 */
public class Practice07Interpolator extends LinearLayout {
    Spinner spinner;
    Button animateBt;
    ImageView imageView;

    Interpolator[] interpolators = new Interpolator[13];
    Path interpolatorPath = new Path();

    public Practice07Interpolator(Context context) {
        super(context);
    }

    public Practice07Interpolator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice07Interpolator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        interpolatorPath.lineTo(0.25f, 0.25f);
        interpolatorPath.moveTo(0.25f, 1.5f);
        interpolatorPath.lineTo(1, 1);
        interpolators[0] = new AccelerateDecelerateInterpolator();
        interpolators[1] = new LinearInterpolator();
        interpolators[2] = new AccelerateInterpolator();
        interpolators[3] = new DecelerateInterpolator();
        interpolators[4] = new AnticipateInterpolator();
        interpolators[5] = new OvershootInterpolator();
        interpolators[6] = new AnticipateOvershootInterpolator();
        interpolators[7] = new BounceInterpolator();
        interpolators[8] = new CycleInterpolator(0.5f);
        interpolators[9] = PathInterpolatorCompat.create(interpolatorPath);
        interpolators[10] = new FastOutLinearInInterpolator();
        interpolators[11] = new FastOutSlowInInterpolator();
        interpolators[12] = new LinearOutSlowInInterpolator();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        spinner = findViewById(R.id.interpolatorSpinner);

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.animate()
                        .translationX(Utils.dpToPixel(150))
                        .setDuration(600)
                        .setInterpolator(interpolators[spinner.getSelectedItemPosition()])
                        .withEndAction(new Runnable() { //withEndAction 动画结束时的回调
                            @Override
                            public void run() {
                                imageView.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageView.setTranslationX(0);
                                    }
                                }, 500);
                            }
                        });

            }
        });


    }
}
