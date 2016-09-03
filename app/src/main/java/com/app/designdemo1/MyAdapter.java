package com.app.designdemo1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author: liyabin
 * @description:
 * @projectName: DesignDemo1
 * @date: 2016-09-03
 * @time: 11:14
 */
public class MyAdapter extends FragmentPagerAdapter {
    private List<String> list;

    public MyAdapter(FragmentManager fm, List<String> list){
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
