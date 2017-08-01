package com.example.mathe.lendermoney.fragments.ListClient;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mathe.lendermoney.R;
import com.example.mathe.lendermoney.model.Debt;

import java.util.List;

/**
 * Created by mathe on 01/08/2017.
 */

public class ListClientFragmentAdapter extends BaseAdapter {

    private final List<Debt> debtList;
    private final Activity act;


    public ListClientFragmentAdapter(List<Debt> debts, Activity act) {
        this.debtList = debts;
        this.act = act;
    }

    @Override
    public int getCount() {
        return debtList.size();
    }

    @Override
    public Object getItem(int i) {
        return debtList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return debtList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View newView = act.getLayoutInflater().inflate(R.layout.listclient_listview_adapter,viewGroup,false);
        Debt debt = debtList.get(i);
        TextView name = newView.findViewById(R.id.listclient_nameID);
        TextView debtOriginal = newView.findViewById(R.id.listclient_amountID);
        TextView payDay =  newView.findViewById(R.id.listclient_dateID);

        name.setText(debt.getName());
        debtOriginal.setText("R$: "+debt.getDebtOriginal().setScale(2).toString());
        payDay.setText(debt.getPayDay().getDayOfMonth()+"-"+debt.getPayDay().getMonthOfYear()+"-"+debt.getPayDay().getYear());

        return newView;
    }
}
