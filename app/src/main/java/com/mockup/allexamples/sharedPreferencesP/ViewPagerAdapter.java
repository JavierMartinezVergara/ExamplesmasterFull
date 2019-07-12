package com.mockup.allexamples.sharedPreferencesP;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList= new ArrayList<>();
    private final List<String> stringListTitles = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {

        return stringListTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringListTitles.get(position);
    }

    public void AddFragment (Fragment fragment, String Titulo){
        fragmentList.add(fragment);
        stringListTitles.add(Titulo);
    }
}
