package com.example.mathe.lendermoney.fragments.DetailClient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mathe.lendermoney.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailPaymentsFragment extends Fragment {


    public DetailPaymentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_payments, container, false);
    }

}
