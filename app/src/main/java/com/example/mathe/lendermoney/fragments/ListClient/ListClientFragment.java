package com.example.mathe.lendermoney.fragments.ListClient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mathe.lendermoney.R;
import com.example.mathe.lendermoney.Util.FinancialService;
import com.example.mathe.lendermoney.fragments.DetailClient.DetailClientFragment;
import com.example.mathe.lendermoney.fragments.DetailClient.DetailDebtFragment;
import com.example.mathe.lendermoney.model.Debt;

import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListClientFragment extends Fragment {

    private ListView listView;
    private List<Debt> debtList = new ArrayList<>();
    FragmentManager fragmentManager;

    public ListClientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v = inflater.inflate(R.layout.fragment_list_client, container, false);
        populateBD();
        listView = v.findViewById(R.id.listclient_listviewID);
        ListClientFragmentAdapter adapter = new ListClientFragmentAdapter(debtList,getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                DetailClientFragment detailClientFragment = new DetailClientFragment();
                Bundle arguments = new Bundle();
                arguments.putSerializable("debt",debtList.get(i));
                detailClientFragment.setArguments(arguments);
                fragmentTransaction.replace(R.id.fragment,detailClientFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return v;
    }

    private void populateBD(){
        Debt debtor = new Debt();
        debtor.setName("Matheus Marinho");
        debtor.setDebtOriginal(new BigDecimal(500.00));
        debtor.setInterest(10.00);
        debtor.setDebtDate(LocalDate.now());
        debtor.setCalculateDay(LocalDate.now());
        debtor.setPayDay(LocalDate.now().withMonthOfYear(LocalDate.now().getMonthOfYear()+1));
        debtor.setDebtTax(FinancialService.calculateTax(debtor.getDebtOriginal(),debtor.getCalculateDay(),debtor.getPayDay(),debtor.getInterest()));
        debtList.add(debtor);

    }

}
