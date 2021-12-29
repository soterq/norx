package com.example.norx.parcer;

import com.example.norx.bnm.Currency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLStringToCurrency {

    private static List<String> getSplitData(String data) {
        List<String> detailedSteps = Arrays.asList(data.split("</Valute>"));
        return detailedSteps;
    }

    public static List<Currency> getCurrencyList(String data) {
        List<Currency> currencyList = new ArrayList<>();
        List<String> list = getSplitData(data);
        for (int i = 0; i < list.size() - 1; i++) {
            Currency currency = new Currency();
            currency.setId(Integer.parseInt(list.get(i).substring(list.get(i).indexOf("ID=\"") + 4, list.get(i).indexOf("\">"))));
            currency.setNumCode(list.get(i).substring(list.get(i).indexOf("<NumCode>") + 9, list.get(i).indexOf("</NumCode>")));
            currency.setCharCode(list.get(i).substring(list.get(i).indexOf("<CharCode>") + 10, list.get(i).indexOf("</CharCode>")));
            currency.setNominal(Integer.valueOf(list.get(i).substring(list.get(i).indexOf("<Nominal>") + 9, list.get(i).indexOf("</Nominal>"))));
            currency.setName(list.get(i).substring(list.get(i).indexOf("<Name>") + 6, list.get(i).indexOf("</Name>")));
            currency.setValue(Double.valueOf(list.get(i).substring(list.get(i).indexOf("<Value>") + 7, list.get(i).indexOf("</Value>"))));
            currencyList.add(currency);
        }
        return currencyList;
    }

}
