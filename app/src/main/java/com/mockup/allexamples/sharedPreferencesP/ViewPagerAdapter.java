package com.mockup.allexamples.sharedPreferencesP;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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

        return fragmentList.get(i);
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
