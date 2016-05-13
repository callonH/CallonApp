package nenu.callon.test.com.test;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;

public class MYViewPagerAdapter extends PagerAdapter{

    private ArrayList<View> views;

    public void setViews(ArrayList<View> views){
        this.views = views;

    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {

        ((ViewPager)container).removeView(views.get(position));
    }
    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(views.get(position));
        return views.get(position);
    }

}