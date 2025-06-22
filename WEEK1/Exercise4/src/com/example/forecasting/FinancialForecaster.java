package com.example.forecasting;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecaster {

    public static double forecastRecursive(double principal, double[] rates) {
        return forecastHelper(principal, rates, 0);
    }

    private static double forecastHelper(double current, double[] rates, int index) {
        if (index >= rates.length) {
            return current;                    // Base case
        }
        double nextValue = current * (1 + rates[index]);
        return forecastHelper(nextValue, rates, index + 1);
    }

    public static double forecastMemoized(double principal, double[] rates) {
        return forecastMemoHelper(principal, rates, 0, new HashMap<>());
    }

    private static double forecastMemoHelper(double current, double[] rates, int index,
                                             Map<Integer, Double> memo) {
        if (index >= rates.length) {
            return current;
        }

        if (memo.containsKey(index)) {
            return current * memo.get(index);
        }

        double next = forecastMemoHelper(current * (1 + rates[index]), rates, index + 1, memo);

        memo.put(index, next / current);
        return next;
    }

    public static double forecastIterative(double principal, double[] rates) {
        double result = principal;
        for (double r : rates) {
            result *= (1 + r);
        }
        return result;
    }
}