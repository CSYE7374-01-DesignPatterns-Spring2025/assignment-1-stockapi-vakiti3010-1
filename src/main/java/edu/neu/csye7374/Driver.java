package edu.neu.csye7374;

/**
 * 
 * @author Yesha
 * 
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("============Main Execution Start===================\n\n");

		// Create two different types of stocks
		MomentumStock ibm = new MomentumStock("IBM", 131.15, "IBM Common Stock");
		VolatilityStock aapl = new VolatilityStock("AAPL", 170.50, "Apple Inc. Common Stock");
		
		// Test bids for IBM (momentum-based)
		System.out.println("Testing IBM (Momentum-based):");
		System.out.println(ibm);
		String[] ibmBids = {"132.00", "133.50", "135.00", "134.80", "134.60", "134.20"};
		
		for (String bid : ibmBids) {
			ibm.setBid(bid);
			System.out.printf("New price: $%s, Metric: %d%n", bid, ibm.getMetric());
		}
		
		System.out.println("\nTesting AAPL (Volatility-based):");
		System.out.println(aapl);
		String[] aaplBids = {"171.00", "173.50", "172.00", "175.00", "171.50", "174.00"};
		
		for (String bid : aaplBids) {
			aapl.setBid(bid);
			System.out.printf("New price: $%s, Metric: %d%n", bid, aapl.getMetric());
		}
		
		System.out.println("\n\n============Main Execution End===================");
	}

}
