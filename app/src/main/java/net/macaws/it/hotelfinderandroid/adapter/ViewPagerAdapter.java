package net.macaws.it.hotelfinderandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import net.macaws.it.hotelfinderandroid.HotelFragment;
import net.macaws.it.hotelfinderandroid.PostFragment;
import net.macaws.it.hotelfinderandroid.UserFragment;

/**
 * Created by Rob on 10/07/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PostFragment();
            case 1:
                return new UserFragment();
            case 2:
                return new HotelFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
