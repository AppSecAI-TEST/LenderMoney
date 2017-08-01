package com.example.mathe.lendermoney.fragments.DetailClient;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.mathe.lendermoney.R;
import com.example.mathe.lendermoney.Util.SlidingTabLayout;
import com.example.mathe.lendermoney.model.Debt;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailClientFragment extends Fragment {

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;


    public DetailClientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Debt debt;
        TabAdapter tabAdapter;
        Bundle arguments = getArguments();
        debt = (Debt) arguments.getSerializable("debt");

        View v = inflater.inflate(R.layout.fragment_detail_client, container, false);
        slidingTabLayout = v.findViewById(R.id.stl_tabs);
        viewPager = v.findViewById(R.id.vp_fragment_detail);


        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(getActivity(),R.color.colorAccent));

        //Configurar o Adapter
        tabAdapter = new TabAdapter(getFragmentManager(),debt);
        viewPager.setAdapter(tabAdapter);

        slidingTabLayout.setViewPager(viewPager);


        return v;
    }

}
