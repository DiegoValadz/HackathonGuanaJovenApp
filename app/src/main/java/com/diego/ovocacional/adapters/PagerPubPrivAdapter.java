package com.diego.ovocacional.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.diego.ovocacional.fragments.ListaUniPrivadasFragment;
import com.diego.ovocacional.fragments.ListaUniPublicasFragment;

public class PagerPubPrivAdapter extends FragmentStatePagerAdapter {
    private int numeroTabs;
    public PagerPubPrivAdapter(FragmentManager fm, int numeroTabs) {
        super(fm);
        this.numeroTabs =numeroTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ListaUniPublicasFragment();
            case 1:
                return new ListaUniPrivadasFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numeroTabs;
    }
}
