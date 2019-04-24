package com.hencoder.hencoderpracticedraw4;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
//        范围裁切
        pageModels.add(new PageModel(R.layout.sample_clip_rect, R.string.title_clip_rect, R.layout.practice_clip_rect));
//        范围裁切
        pageModels.add(new PageModel(R.layout.sample_clip_path, R.string.title_clip_path, R.layout.practice_clip_path));
//        几何变换-平移
        pageModels.add(new PageModel(R.layout.sample_translate, R.string.title_translate, R.layout.practice_translate));
//        几何变换-缩放
        pageModels.add(new PageModel(R.layout.sample_scale, R.string.title_scale, R.layout.practice_scale));
//        几何变换-旋转
        pageModels.add(new PageModel(R.layout.sample_rotate, R.string.title_rotate, R.layout.practice_rotate));
//        几何变换-错切
        pageModels.add(new PageModel(R.layout.sample_skew, R.string.title_skew, R.layout.practice_skew));
//        使用 Matrix 来做自定义变换-平移
        pageModels.add(new PageModel(R.layout.sample_matrix_translate, R.string.title_matrix_translate, R.layout.practice_matrix_translate));
//        使用 Matrix 来做自定义变换-缩放
        pageModels.add(new PageModel(R.layout.sample_matrix_scale, R.string.title_matrix_scale, R.layout.practice_matrix_scale));
//        使用 Matrix 来做自定义变换-旋转
        pageModels.add(new PageModel(R.layout.sample_matrix_rotate, R.string.title_matrix_rotate, R.layout.practice_matrix_rotate));
//        使用 Matrix 来做自定义变换-错切
        pageModels.add(new PageModel(R.layout.sample_matrix_skew, R.string.title_matrix_skew, R.layout.practice_matrix_skew));
//        Camera 变换- 三维旋转
        pageModels.add(new PageModel(R.layout.sample_camera_rotate, R.string.title_camera_rotate, R.layout.practice_camera_rotate));
//        Camera 变换- 三维旋转--修正版
        pageModels.add(new PageModel(R.layout.sample_camera_rotate_fixed, R.string.title_camera_rotate_fixed, R.layout.practice_measure_text));
//        Camera.setLocation(x, y, z) 设置虚拟相机的位置
        pageModels.add(new PageModel(R.layout.sample_camera_rotate_hitting_face, R.string.title_camera_rotate_hitting_face, R.layout.practice_camera_rotate_hitting_face));
//        翻页效果
        pageModels.add(new PageModel(R.layout.sample_flipboard, R.string.title_flipboard, R.layout.practice_flipboard));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private class PageModel {
        @LayoutRes
        int sampleLayoutRes;
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
