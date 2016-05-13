package nenu.callon.test.com.test;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.content.res.Configuration;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;

public class MainActivity extends AutoLayoutActivity {

    private View curcor;
    private int width,height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        width = metric.widthPixels;
        height = metric.heightPixels;


        curcor = (View)findViewById(R.id.cursor_MessageFragment);

        curcor.setX(0);
        initViewPager();

    }
    /**
     * 屏幕旋转时调用此方法
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //newConfig.orientation获得当前屏幕状态是横向或者竖向
        //Configuration.ORIENTATION_PORTRAIT 表示竖向
        //Configuration.ORIENTATION_LANDSCAPE 表示横屏
        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){

        }
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){

        }
    }
    private void initViewPager() {
        ViewPager viewpager = (ViewPager)findViewById(R.id.viewpager);

        View view1 = LayoutInflater.from(this).inflate(R.layout.layout1,null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.layout2,null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.layout3,null);

        ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        MYViewPagerAdapter adapter = new MYViewPagerAdapter();

        adapter.setViews(views);
        viewpager.setAdapter(adapter);

        viewpager.addOnPageChangeListener(listener);

    }
    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if(position == 0)
                curcor.setX(0);
            else if(position == 1)
                curcor.setX(width/3);
            else if(position == 2)
                curcor.setX(width*2/3);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
