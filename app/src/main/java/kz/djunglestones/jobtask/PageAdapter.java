package kz.djunglestones.jobtask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class PageAdapter extends FragmentPagerAdapter {
    private int numOfTabs;
    Fragment fragment;
    private boolean spinnerSelected;
    public PageAdapter(FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
//        this.spinnerSelected = spinnerSelected;
//        this.fragment = fragment;
    }

    @Override
    public Fragment getItem(int position) {

//        if (!spinnerSelected) {
//            Log.i("Switch", "getItem: Switch Case");
            switch (position) {
                case 0:
                    Log.i("First", "getItem: ");
                    return new Link1Fragment();
                case 1:
                    Log.i("Second", "getItem: ");
                    return new Link2Fragment();
                case 2:
                    Log.i("Third", "getItem: ");
                    return new Link3Fragment();
                default:
                    return new BlankFragment();
            }
//        }else {
//            Log.i("Blank Fragment", "getItem: Blank Fragment");
//            return new BlankFragment();
//        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
