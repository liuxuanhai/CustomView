package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.hencoder.hencoderpracticedraw6.R;

/**
 * FileName: Practice03Scale
 * Author: nanzong
 * Date: 2019/5/5 6:00 PM
 * Description:
 * History:
 */
public class Practice03Scale extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    int index;

    public Practice03Scale(Context context) {
        super(context);
    }

    public Practice03Scale(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03Scale(Context context, AttributeSet attrs, int defStyleAttr) {
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
                switch (index) {
                    case 0:
                        imageView.animate().scaleX(1.5f);
                        break;
                    case 1:
                        imageView.animate().scaleX(1f);
                        break;
                    case 2:
                        imageView.animate().scaleX(1.25f);
                        break;
                    case 3:
                        imageView.animate().scaleX(1.5f);
                        break;
                }
                index++;
                if (index > 3) {
                    index = 0;
                }

            }
        });
    }
}
