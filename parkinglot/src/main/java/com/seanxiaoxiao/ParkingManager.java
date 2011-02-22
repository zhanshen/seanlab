package com.seanxiaoxiao;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {

	private List<ParkingLot> managedLots = new ArrayList<ParkingLot>();
	
	public void addParkingLot() {
		managedLots.add(new ParkingLot());
	}
	
	/**
	 * Park to the first available parking lot.
	 * @throws ParkingException No parking lot is available.
	 */
	public void park() throws ParkingException {
		for (ParkingLot currentParkingLot : managedLots) {
			if (currentParkingLot.canPark()) {
				currentParkingLot.park();
				return;
			}
		}
		throw new ParkingException("No lots available for parking");
	}
	
	/**
	 * Unpark from the parking lots collection.
	 * @throws ParkingException No cars in every parking lots.
	 */
	public void unPark() throws ParkingException {
		for (ParkingLot currentParkingLot : managedLots) {
			if (currentParkingLot.hasCar()) {
				currentParkingLot.unPark();
				return;
			}
		}
		throw new ParkingException("No cars available for unparking");
	}
}
