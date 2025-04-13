package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter currencyConverter = new CurrencyConverter();
        int number;
        do {
            System.out.println("Введите 1 для перевода из одной валюты в другую, 2 - для завершения работы");
            number = scanner.nextInt();
            if (number == 1){
                System.out.println("Введите сумму:");
                double amount = scanner.nextDouble();
                System.out.println("Введите текущую валюту:");
                String fromCurrency = scanner.next();
                System.out.println("Введите валюту, в которую необходимо перевести:");
                String toCurrency = scanner.next();
                try {
                    double res = currencyConverter.convert(amount, fromCurrency, toCurrency, LocalDate.now());
                    System.out.println(String.format("%.2f", amount)+" "+fromCurrency+" = "+String.format("%.2f", res)+" "+toCurrency);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        } while(number!=2);
    }
}
