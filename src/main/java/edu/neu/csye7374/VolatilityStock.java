package edu.neu.csye7374;

public class VolatilityStock extends StockAPI {
    public VolatilityStock(String ID, double initialPrice, String description) {
        super(ID, initialPrice, description);
    }
    
    @Override
    public int getMetric() {
        if (historyIndex < 1) return 0;  // Need at least 2 prices
        
        // Calculate average price
        double sum = 0;
        int count = historyIndex + 1;
        for (int i = 0; i <= historyIndex; i++) {
            sum += priceHistory[i];
        }
        double avg = sum / count;
        
        // Calculate variance
        double variance = 0;
        for (int i = 0; i <= historyIndex; i++) {
            variance += Math.pow(priceHistory[i] - avg, 2);
        }
        variance /= count;
        
        // Return negative metric for high volatility
        return -(int)(variance * 100);
    }
} 