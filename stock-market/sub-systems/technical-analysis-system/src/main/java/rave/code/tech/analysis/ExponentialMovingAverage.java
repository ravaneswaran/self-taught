package rave.code.tech.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExponentialMovingAverage {

    public static List<Double> calculateEMA(List<Double> prices, int period) {
        List<Double> exponentialMovingAverages = new ArrayList<>();

        if (prices == null || prices.size() < period) {
            return exponentialMovingAverages; // Not enough data
        }

        // Smoothing factor α = 2 / (period + 1)
        double multiplier = 2.0 / (period + 1);

        // Start with the SMA of the first 'period' prices
        double simpleMovingAverage = 0.0;
        for (int index = 0; index < period; index++) {
            simpleMovingAverage += prices.get(index);
        }
        simpleMovingAverage /= period;
        exponentialMovingAverages.add(simpleMovingAverage);

        // Calculate EMA for remaining values
        for (int index = period; index < prices.size(); index++) {
            double price = prices.get(index);
            double exponentialMovingAveragePrev = exponentialMovingAverages.get(exponentialMovingAverages.size() - 1);
            double exponentialMovingAverage = (price - exponentialMovingAveragePrev) * multiplier + exponentialMovingAveragePrev;
            exponentialMovingAverages.add(exponentialMovingAverage);
        }

        // Prepend nulls for initial values to align with price list
        for (int index = 0; index < period - 1; index++) {
            exponentialMovingAverages.add(0, null);
        }

        return exponentialMovingAverages;
    }

    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(22.0, 24.5, 25.0, 23.5, 26.0, 27.5, 28.0, 29.5, 30.0);

        int period = 3; // You can change to 5, 10, etc.
        List<Double> emaValues = calculateEMA(prices, period);

        System.out.println("Prices: " + prices);
        System.out.println("EMA (" + period + "-day): " + emaValues);
    }
}
