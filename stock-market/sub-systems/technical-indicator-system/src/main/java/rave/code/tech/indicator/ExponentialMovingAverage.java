package rave.code.tech.indicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExponentialMovingAverage {

    public static List<Double> calculateEMA(List<Double> prices, int period) {
        List<Double> emaValues = new ArrayList<>();

        if (prices == null || prices.size() < period) {
            return emaValues; // Not enough data
        }

        // Smoothing factor α = 2 / (period + 1)
        double multiplier = 2.0 / (period + 1);

        // Start with the SMA of the first 'period' prices
        double sma = 0.0;
        for (int i = 0; i < period; i++) {
            sma += prices.get(i);
        }
        sma /= period;
        emaValues.add(sma);

        // Calculate EMA for remaining values
        for (int i = period; i < prices.size(); i++) {
            double price = prices.get(i);
            double emaPrev = emaValues.get(emaValues.size() - 1);
            double ema = (price - emaPrev) * multiplier + emaPrev;
            emaValues.add(ema);
        }

        // Prepend nulls for initial values to align with price list
        for (int i = 0; i < period - 1; i++) {
            emaValues.add(0, null);
        }

        return emaValues;
    }

    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(22.0, 24.5, 25.0, 23.5, 26.0, 27.5, 28.0, 29.5, 30.0);

        int period = 3; // You can change to 5, 10, etc.
        List<Double> emaValues = calculateEMA(prices, period);

        System.out.println("Prices: " + prices);
        System.out.println("EMA (" + period + "-day): " + emaValues);
    }
}
