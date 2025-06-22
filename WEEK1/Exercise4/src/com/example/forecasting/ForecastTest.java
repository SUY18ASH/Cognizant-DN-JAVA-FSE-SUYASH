package com.example.forecasting;

public class ForecastTest {
    public static void main(String[] args) {
        double principal = 1000.0;
        double[] rates = {0.05, 0.07, 0.06, 0.08};

        double r1 = FinancialForecaster.forecastRecursive(principal, rates);
        double r2 = FinancialForecaster.forecastMemoized(principal, rates);
        double r3 = FinancialForecaster.forecastIterative(principal, rates);

        System.out.printf("Recursive result: %.2f%n", r1);
        System.out.printf("Memoized  result: %.2f%n", r2);
        System.out.printf("Iterative result: %.2f%n", r3);
    }
}