package edu.neu.csye7374;

public class MomentumStock extends StockAPI {
    public MomentumStock(String ID, double initialPrice, String description) {
        super(ID, initialPrice, description);
    }
    
    @Override
    public int getMetric() {
        if (historyIndex < 2) return 0;  // Need at least 3 prices for momentum
        
        // Calculate rate of price change
        double recentChange = priceHistory[historyIndex] - priceHistory[historyIndex - 1];
        double previousChange = priceHistory[historyIndex - 1] - priceHistory[historyIndex - 2];
        
        // Return scaled difference between recent and previous change
        return (int)((recentChange - previousChange) * 100);
    }
} 