package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.*;
import com.hencoder.hencoderpracticedraw6.R;

/**
 * FileName: Practice06Duration
 * Author: nanzong
 * Date: 2019/5/6 10:11 AM
 * Description:
 * History:
 */
public class Practice06Duration extends LinearLayout {
    SeekBar durationSb;
    TextView durationValueTv;
    Button animateBt;
    ImageView imageView;
    int index;

    int duration = 300;

    public Practice06Duration(Context context) {
        super(context);
    }

    public Practice06Duration(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06Duration(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        durationSb = findViewById(R.id.durationSb);
        durationValueTv = findViewById(R.id.durationValueTv);
        durationValueTv.setText(getContext().getString(R.string.ms_with_value, duration));
        durationSb.setMax(10);
        durationSb.setProgress(1);
        durationSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                duration = progress * 300;
                durationValueTv.setText(getContext().getString(R.string.ms_with_value, duration));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 在这里切换点击事件，执行动画。记得使用 'setDura'
                if (index == 0) {
                    imageView.animate()
                            .translationX(300)
                            .setDuration(duration);
                    index = 1;
                } else {
                    imageView.animate()
                            .translationX(0)
                            .setDuration(duration);
                    index = 0;
                }

            }
        });
    }
}
