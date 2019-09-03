package com.mockup.allexamples.sharedPreferencesP;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.mockup.allexamples.R;

public class SharedPreferences extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        tabLayout = findViewById(R.id.tablayout);
        appBarLayout = findViewById(R.id.appbarsP);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragment(new Fragment1(), "Fragment 1");
        viewPagerAdapter.AddFragment(new Fragment2(), "Fragment 2");
        viewPagerAdapter.AddFragment(new Fragment3(), "Fragment 3");

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);


    }
}
