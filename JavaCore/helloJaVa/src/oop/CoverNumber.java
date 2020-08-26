package oop;

import java.text.NumberFormat;

public class CoverNumber {
    public static void main(String[] args) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        double x = 0.1;
        System.out.println("currencyFormatter---" + currencyFormatter.format(x));
        System.out.println("percentFormatter---" + percentFormatter.format(x));
    }
}