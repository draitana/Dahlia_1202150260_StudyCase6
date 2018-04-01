package com.example.a3d.dahlia_1202150260_sc006.homeScreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by 3D on 4/1/2018.
 */

public class AdapterPager extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public AdapterPager(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FragmentPostTerbaru();
            case 1:
                return new FragmentMyPost();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
