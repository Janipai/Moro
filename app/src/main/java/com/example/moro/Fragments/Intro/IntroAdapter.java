package com.example.moro.Fragments.Intro;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class IntroAdapter extends FragmentPagerAdapter {


    public IntroAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case  0:
                 return new IntroFragment1();
            case 1:
                 return new IntroFragment2();
            case 2:
                 return new IntroFragment3();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
