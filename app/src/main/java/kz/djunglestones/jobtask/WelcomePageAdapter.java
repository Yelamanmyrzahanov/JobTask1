package kz.djunglestones.jobtask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class WelcomePageAdapter extends FragmentStatePagerAdapter{

    private List<Fragment> fragments;
    public WelcomePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FirstFragment();
            case 1: return new SecondFragment();
            case 2: return new ThirdFragment();
            case 3: return new FourthFragment();
            default:return new FirstFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
