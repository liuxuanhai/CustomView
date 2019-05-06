package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.hencoder.hencoderpracticedraw6.R;

/**
 * FileName: Practice02Rotation
 * Author: nanzong
 * Date: 2019/5/5 5:53 PM
 * Description:
 * History:
 */
public class Practice02Rotation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    int index;

    public Practice02Rotation(Context context) {
        super(context);
    }

    public Practice02Rotation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02Rotation(Context context, AttributeSet attrs, int defStyleAttr) {
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
                        imageView.animate().rotation(0);
                        break;
                    case 1:
                        imageView.animate().rotation(90);
                        break;
                    case 2:
                        imageView.animate().rotation(180);
                        break;
                    case 3:
                        imageView.animate().rotation(270);
                        break;
                    case 4:
                        imageView.animate().rotation(180);
                        break;
                    case 5:
                        imageView.animate().rotation(0);
                        break;
                    default:
                }
                index++;
                if (index > 5) {
                    index = 0;
                }

            }
        });


    }
}
