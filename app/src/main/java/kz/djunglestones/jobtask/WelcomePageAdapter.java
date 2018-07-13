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
            case 0: return FirstFragment.newInstance("FirstFragment, Instance 1");
            case 1: return SecondFragment.newInstance("SecondFragment, Instance 2");
            case 2: return ThirdFragment.newInstance("ThirdFragment, Instance 3");
            case 3: return FourthFragment.newInstance("ThirdFragment, Instance 2");
            default:return FirstFragment.newInstance("FirstFragment, Instance 1");
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
