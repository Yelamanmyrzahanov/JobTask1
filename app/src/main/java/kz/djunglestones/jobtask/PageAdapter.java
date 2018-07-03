package kz.djunglestones.jobtask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;

public class PageAdapter extends FragmentStatePagerAdapter{
    private int numOfTabs;
    Fragment fragment;
    private boolean spinnerSelected;
    private long baseId = 0;
    public PageAdapter(FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
//        this.fragment = fragment;
    }

    @Override
    public Fragment getItem(int position) {

        if (!spinnerSelected) {
            Log.i("Switch", "getItem: Switch Case");
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
        }else {
            Log.i("Blank Fragment", "getItem: B" +
                    "lank Fragment");
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
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    public boolean isSpinnerSelected() {
        return spinnerSelected;
    }

    public void setSpinnerSelected(boolean spinnerSelected) {
        this.spinnerSelected = spinnerSelected;
    }

    //this is called when notifyDataSetChanged() is called
    @Override
    public int getItemPosition(Object object) {
        // refresh all fragments when data set changed
        return PagerAdapter.POSITION_NONE;
    }

    public void notifyChangeInPosition(int n) {
        // shift the ID returned by getItemId outside the range of all previous fragments
        baseId += getCount() + n;
    }
}
