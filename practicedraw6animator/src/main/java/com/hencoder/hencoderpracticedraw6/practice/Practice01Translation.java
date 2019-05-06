package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.hencoder.hencoderpracticedraw6.R;
import com.hencoder.hencoderpracticedraw6.Utils;

import static android.os.Build.VERSION.SDK_INT;
import static com.hencoder.hencoderpracticedraw6.Utils.dpToPixel;

/**
 * FileName: Practice01Translation
 * Author: nanzong
 * Date: 2019/5/5 4:14 PM
 * Description:
 * History:
 */
public class Practice01Translation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    int index;
    boolean isAnim = false;

    public Practice01Translation(Context context) {
        super(context);
    }

    public Practice01Translation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01Translation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);
        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.setOutlineProvider(new MusicOutlineProvider());
        }

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，通过 View.animate().translationX/Y/Z() 来让 View 平移

                if (!isAnim) {
                    if (index == 0) {
                        imageView.animate().translationX(300);
                    } else if (index == 1) {
                        imageView.animate().translationY(100);
                    } else {
                        imageView.animate().translationZ(50);
                    }
                    isAnim = true;
                } else {
                    if (index == 0) {
                        imageView.animate().translationX(0);
                        index++;
                    } else if (index == 1) {
                        imageView.animate().translationY(0);
                        index++;
                    } else {
                        imageView.animate().translationZ(0);
                        index = 0;
                    }
                    isAnim = false;
                }


                Log.e("animateBt", "index--->  " + index + "    " + isAnim);

            }
        });

    }

    /**
     * 为音乐图标设置三角形的 Outline.
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {

        Path path = new Path();

        {
            path.moveTo(0, dpToPixel(10));
            path.lineTo(dpToPixel(7), dpToPixel(2));
            path.lineTo(dpToPixel(116), dpToPixel(58));
            path.lineTo(dpToPixel(116), dpToPixel(70));
            path.lineTo(dpToPixel(7), dpToPixel(128));
            path.lineTo(0, dpToPixel(120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }


}
