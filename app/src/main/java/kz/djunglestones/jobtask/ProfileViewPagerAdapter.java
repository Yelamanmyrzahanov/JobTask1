package kz.djunglestones.jobtask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ProfileViewPagerAdapter extends FragmentStatePagerAdapter {
    private int numOftabs;

    public ProfileViewPagerAdapter(FragmentManager fm,int numOftabs) {
        super(fm);
        this.numOftabs = numOftabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TicketsBoughtsFragment();
            case 1:
                return new BlankTicketsFragment();
            case 2:
                return new BlankTicketsFragment();
            default:
                return new BlankFragment();
        }
    }

    @Override
    public int getCount() {
        return numOftabs;
    }

//    public int getItemPosition(Object object) {
//        return POSITION_NONE;
//    }
}
