package com.hencoder.hencoderpracticedraw7;

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
//        ArgbEvaluator     求值器  动画完成度，求出对应的实际的属性值  更改颜色时 ArgbEvaluator
        pageModels.add(new PageModel(R.layout.sample_argb_evaluator, R.string.title_argb_evaluator, R.layout.practice_argb_evaluator));
//        自定义求值器--颜色渐变
        pageModels.add(new PageModel(R.layout.sample_hsv_evaluator, R.string.title_hsv_evaluator, R.layout.practice_hsv_evaluator));
//        自定义求值器--点的运动轨迹
        pageModels.add(new PageModel(R.layout.sample_of_object, R.string.title_of_object, R.layout.practice_of_object));
//        PropertyValuesHolder 同一个动画中改变多个属性
        pageModels.add(new PageModel(R.layout.sample_property_values_holder, R.string.title_property_values_holder, R.layout.practice_property_values_holder));
//        AnimatorSet 多个动画配合执行
        pageModels.add(new PageModel(R.layout.sample_animator_set, R.string.title_animator_set, R.layout.practice_animator_set));
//        PropertyValuesHolders.ofKeyframe() 把同一个属性拆分
        pageModels.add(new PageModel(R.layout.sample_keyframe, R.string.title_keyframe, R.layout.practice_keyframe));
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
