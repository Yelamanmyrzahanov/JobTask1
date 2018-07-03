package kz.djunglestones.jobtask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class PageBlankAdapter extends FragmentPagerAdapter {
    private int numOfTabs;
    public PageBlankAdapter(FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Log.i("First", "getItem: ");
                return new BlankFragment();
            case 1:
                Log.i("Second", "getItem: ");
                return new BlankFragment();
            case 2:
                Log.i("Third", "getItem: ");
                return new BlankFragment();
            default:
                return new BlankFragment();
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
