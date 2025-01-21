package edu.neu.csye7374;

public abstract class StockAPI implements Tradable {
    protected String ID;
    protected double price;
    protected String description;
    protected double[] priceHistory;
    protected int historyIndex;
    
    public StockAPI(String ID, double initialPrice, String description) {
        this.ID = ID;
        this.price = initialPrice;
        this.description = description;
        this.priceHistory = new double[6];  // Store last 6 prices
        this.historyIndex = 0;
        this.priceHistory[0] = initialPrice;
    }
    
    @Override
    public void setBid(String bid) {
        try {
            double newPrice = Double.parseDouble(bid);
            if (historyIndex < 5) {
                historyIndex++;
            } else {
                // Shift history left
                for (int i = 0; i < 5; i++) {
                    priceHistory[i] = priceHistory[i + 1];
                }
            }
            price = newPrice;
            priceHistory[historyIndex] = newPrice;
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid format: " + bid);
        }
    }
    
    @Override
    public String toString() {
        return String.format("Stock: %s, Price: $%.2f, Description: %s", 
                           ID, price, description);
    }
} 