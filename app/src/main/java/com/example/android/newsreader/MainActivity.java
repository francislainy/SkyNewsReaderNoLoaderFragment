package com.example.android.newsreader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Replace layout from fragment_top_news (Loaded into the
         * TopNewsFragment class) for container layout inside
         * activity_main.xml
         */
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flid, new TopNewsFragment())
                .commit();

//        // Get the ViewPager and set it's PagerAdapter so that it can display items
//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
//        viewPager.setAdapter(new SimpleFragmentPagerAdapter(this, getSupportFragmentManager()));
//
//        // Give the TabLayout the ViewPager
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
//        tabLayout.setupWithViewPager(viewPager);

    }

}