package com.seanxiaoxiao;

public class ParkingLot {

	private static final int MAX_LOTS = 10;
	
	private int lotsAvailable = 10;
	
	public void park() {
		if (canPark()) {
			lotsAvailable--;
		}
	}
	
	public void unPark() {
		if (hasCar()) {
			lotsAvailable++;
		}
	}
	
	public boolean canPark() {
		return lotsAvailable > 0;
	}
	
	public boolean hasCar() {
		return lotsAvailable < MAX_LOTS;
	}
}
