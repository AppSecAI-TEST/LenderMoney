package com.example.mathe.lendermoney.fragments.DetailClient;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.mathe.lendermoney.R;
import com.example.mathe.lendermoney.model.Debt;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailDebtFragment extends Fragment {

    private static Debt debt;

    public DetailDebtFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Debt debtTab){
        DetailDebtFragment detailDebtFragment = new DetailDebtFragment();
        debt = debtTab;
        return  detailDebtFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_detail_debt, container, false);
        TextView name = v.findViewById(R.id.detailsNameID);
        TextView debtOriginal = v.findViewById(R.id.detailsDebtOriginalID);
        TextView debtDay = v.findViewById(R.id.detailsDebtDateID);
        TextView interest = v.findViewById(R.id.detailsInterestID);
        TextView calculateDay = v.findViewById(R.id.detailsCalculateDayID);
        TextView payDay = v.findViewById(R.id.detailsPayDayID);
        TextView tax = v.findViewById(R.id.detailsTaxID);
            name.setText(debt.getName());
            debtOriginal.setText("R$ "+debt.getDebtOriginal().toString());
            debtDay.setText(debt.getDebtDate().toString());
            interest.setText(debt.getInterest().toString()+"%");
            calculateDay.setText(debt.getCalculateDay().getDayOfMonth()+"-"+debt.getCalculateDay().getMonthOfYear()+"-"+debt.getCalculateDay().getYear());
            payDay.setText(debt.getPayDay().getDayOfMonth()+"-"+debt.getPayDay().getMonthOfYear()+"-"+debt.getPayDay().getYear());
            tax.setText("R$ "+debt.getDebtTax().toString());

            calculateDay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatePickerDialog datePickerDialog =  new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            i1++;
                            calculateDay.setText(i2+"-"+i1+"-"+i);
                        }
                    }, debt.getCalculateDay().getYear(), debt.getCalculateDay().getMonthOfYear(), debt.getCalculateDay().getDayOfMonth());
                    datePickerDialog.show();
                }
            });






        return v;
    }
    }


