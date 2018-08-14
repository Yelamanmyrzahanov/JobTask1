package kz.djunglestones.jobtask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapterEventInfo extends FragmentStatePagerAdapter {
    private int numOfTabs;
    Fragment fragment;

    public PageAdapterEventInfo(FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new EventInfoTicketFragment();
            case 1:
                return new EventInfoFragment();
        }
        return new BlankFragment();
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
