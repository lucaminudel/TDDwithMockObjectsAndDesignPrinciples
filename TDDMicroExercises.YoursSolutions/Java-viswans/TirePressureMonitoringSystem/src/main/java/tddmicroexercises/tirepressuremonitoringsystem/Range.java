package tddmicroexercises.tirepressuremonitoringsystem;

public class Range {
	
	private double low, high;
	
	public Range(double low, double high) {
		if (low > high) 
			throw new IllegalArgumentException();
		
		this.low = low;
		this.high = high;
	}
	
	public boolean inRange(double val) {
		return !(val < low || val > high); 
	}

}
