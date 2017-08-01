package com.example.mathe.lendermoney.Util;

import android.os.Debug;
import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Created by mathe on 01/08/2017.
 */

public class FinancialService {
    //Fórmula dos juros compostos: Juros = ((1 + taxa / 100) ^ períodos) - 1

    public static final BigDecimal calculateTax(BigDecimal amount, org.joda.time.LocalDate dateInitial, org.joda.time.LocalDate dateFinal, Double tax){
        BigDecimal finalTax;
        Double propInitial,propFinal;
        Double period;
        Double calculation;
        propInitial = new Double((dateInitial.dayOfMonth().withMaximumValue().getDayOfMonth() - dateInitial.getDayOfMonth()))/dateInitial.dayOfMonth().withMaximumValue().getDayOfMonth();
        propFinal = new Double(dateFinal.getDayOfMonth())/dateFinal.dayOfMonth().withMaximumValue().getDayOfMonth();
        period = propFinal + propInitial;
        calculation = (1+(tax/100));
        calculation = (Math.pow(calculation, period)-1);
        finalTax = amount.multiply(new BigDecimal(calculation));
        Log.i("DATE: ", String.valueOf(dateFinal.dayOfMonth().withMaximumValue().getDayOfMonth()));

        return finalTax.setScale(2, RoundingMode.HALF_DOWN);
    }
}
