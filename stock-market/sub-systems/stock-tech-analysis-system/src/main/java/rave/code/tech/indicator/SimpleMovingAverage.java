package rave.code.tech.indicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleMovingAverage {

    // Method to calculate SMA
    public static List<Double> calculateSMA(List<Double> prices, int period) {
        List<Double> sma = new ArrayList<>();
        if (prices == null || prices.size() < period) {
            return sma; // Not enough data
        }
        double sum = 0.0;
        for (int i = 0; i < prices.size(); i++) {
            sum += prices.get(i);
            if (i >= period - 1) {
                if (i >= period) {
                    sum -= prices.get(i - period);
                }
                sma.add(sum / period);
            }
        }
        return sma;
    }

    public static void main(String[] args) {
        // Example closing prices
        List<Double> prices = Arrays.asList(22.0, 24.5, 25.0, 23.5, 26.0, 27.5, 28.0, 29.5, 30.0);

        // SMA for 3-day period
        int period = 3;
        List<Double> smaValues = calculateSMA(prices, period);

        System.out.println("SMA (" + period + "-day): " + smaValues);
    }
}
