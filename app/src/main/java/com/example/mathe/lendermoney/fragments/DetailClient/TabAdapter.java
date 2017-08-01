package com.example.mathe.lendermoney.fragments.DetailClient;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.mathe.lendermoney.model.Debt;

/**
 * Created by mathe on 01/08/2017.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    private String[] titleTab = {"DETALHES", "PAGAMENTOS"};
    private Debt debt;

    public TabAdapter(FragmentManager fm,Debt debt) {
        super(fm);
        this.debt = debt;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = DetailDebtFragment.newInstance(debt);
                break;
            case 1:
                fragment = new DetailPaymentsFragment();
                break;

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return titleTab.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleTab[position];
    }
}
