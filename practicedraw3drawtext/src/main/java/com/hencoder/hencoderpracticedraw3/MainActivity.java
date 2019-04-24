package com.hencoder.hencoderpracticedraw3;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
//        绘制文字
        pageModels.add(new PageModel(R.layout.sample_draw_text, R.string.title_draw_text, R.layout.practice_draw_text));
//        设置文字换行
        pageModels.add(new PageModel(R.layout.sample_static_layout, R.string.title_static_layout, R.layout.practice_static_layout));
//        设置文字大小
        pageModels.add(new PageModel(R.layout.sample_set_text_size, R.string.title_set_text_size, R.layout.practice_set_text_size));
//        设置字体样式
        pageModels.add(new PageModel(R.layout.sample_set_typeface, R.string.title_set_typeface, R.layout.practice_set_typeface));
//        绘制伪粗体文字
        pageModels.add(new PageModel(R.layout.sample_set_fake_bold_text, R.string.title_set_fake_bold_text, R.layout.practice_set_fake_bold_text));
//        绘制删除线
        pageModels.add(new PageModel(R.layout.sample_set_strike_thru_text, R.string.title_set_strike_thru_text, R.layout.practice_set_strike_thru_text));
//        绘制下划线
        pageModels.add(new PageModel(R.layout.sample_set_underline_text, R.string.title_set_underline_text, R.layout.practice_set_underline_text));
//        绘制斜体文字
        pageModels.add(new PageModel(R.layout.sample_set_text_skew_x, R.string.title_set_text_skew_x, R.layout.practice_set_text_skew_x));
//        绘制文字宽度缩放
        pageModels.add(new PageModel(R.layout.sample_set_text_scale_x, R.string.title_set_text_scale_x, R.layout.practice_set_text_scale_x));
//        设置文字对齐方式
        pageModels.add(new PageModel(R.layout.sample_set_text_align, R.string.title_set_text_align, R.layout.practice_set_text_align));
//        设置文字行距
        pageModels.add(new PageModel(R.layout.sample_get_font_spacing, R.string.title_get_font_spacing, R.layout.practice_get_font_spacing));
//        测量文字绘制时所占用的宽度
        pageModels.add(new PageModel(R.layout.sample_measure_text, R.string.title_measure_text, R.layout.practice_measure_text));
//        通过getTextBounds方法获取文字显示区域
        pageModels.add(new PageModel(R.layout.sample_get_text_bounds, R.string.title_get_text_bounds, R.layout.practice_get_text_bounds));
//        通过getFontMetrics方法获取文字显示区域
        pageModels.add(new PageModel(R.layout.sample_get_font_metrics, R.string.title_get_font_metrics, R.layout.practice_get_font_metrics));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
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

        tabLayout = findViewById(R.id.tabLayout);
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
        @LayoutRes int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
