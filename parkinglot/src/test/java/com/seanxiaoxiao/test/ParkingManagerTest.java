package com.seanxiaoxiao.test;

import org.junit.Assert;
import org.junit.Test;

import com.seanxiaoxiao.ParkingException;
import com.seanxiaoxiao.ParkingManager;

public class ParkingManagerTest {

	private ParkingManager parkingManager = new ParkingManager();
	
	@Test(expected = ParkingException.class)
	public void testParking_NoLot_NotAvailable() throws ParkingException {
		parkingManager.park();
	}
	
	@Test
	public void testParking_OneLot_Available() {
		parkingManager.addParkingLot();
		try {
			parkingManager.park();
		} catch (ParkingException e) {
			Assert.fail();
		}
	}
	
	@Test(expected = ParkingException.class)
	public void testParking_OneLot_NotAvailable() throws ParkingException {
		parkingManager.addParkingLot();
		try {
			for (int i = 0; i < 10; i++) {
				parkingManager.park();
			}
		} catch (ParkingException e) {
			Assert.fail();
		}
		parkingManager.park();
	}
	
	@Test
	public void testParking_TwoLot_Available() throws ParkingException {
		parkingManager.addParkingLot();
		parkingManager.addParkingLot();
		try {
			for (int i = 0; i < 10; i++) {
				parkingManager.park();
			}
		} catch (ParkingException e) {
			Assert.fail();
		}
		try {
			parkingManager.park();
		} catch (ParkingException e) {
			Assert.fail();
		}
	}
	
	@Test(expected = ParkingException.class)
	public void testParking_TwoLot_NotAvailable() throws ParkingException {
		parkingManager.addParkingLot();
		parkingManager.addParkingLot();
		try {
			for (int i = 0; i < 20; i++) {
				parkingManager.park();
			}
		} catch (ParkingException e) {
			Assert.fail();
		}
		parkingManager.park();
	}
	
	@Test(expected = ParkingException.class)
	public void testUnParking_NoLot() throws ParkingException {
		parkingManager.unPark();
	}
	
	@Test(expected = ParkingException.class)
	public void testUnParking_OneLot_NoCar() throws ParkingException {
		parkingManager.addParkingLot();
		parkingManager.unPark();
	}
	
	@Test
	public void testUnParking_OneLot_OneCar() throws ParkingException {
		parkingManager.addParkingLot();
		parkingManager.park();
		try {
			parkingManager.unPark();
		} catch (ParkingException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testUnParking_OneLot_TenCar() throws ParkingException {
		parkingManager.addParkingLot();
		for (int i = 0; i < 10; i++) {
			parkingManager.park();
		}
		try {
			for (int i = 0; i < 10; i++) {
				parkingManager.unPark();
			}
		} catch (ParkingException e) {
			Assert.fail();
		}
	}
	
	@Test(expected = ParkingException.class)
	public void testUnParking_TwoLots_NoCar() throws ParkingException {
		parkingManager.addParkingLot();
		parkingManager.addParkingLot();
		parkingManager.unPark();
	}
	
	@Test
	public void testUnParking_TwoLots_OneCar() throws ParkingException {
		parkingManager.addParkingLot();
		parkingManager.addParkingLot();
		parkingManager.park();
		try {
			parkingManager.unPark();
		} catch (ParkingException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testUnParking_TwoLots_TwentyCar() throws ParkingException {
		parkingManager.addParkingLot();
		parkingManager.addParkingLot();
		for (int i = 0; i < 10; i++) {
			parkingManager.park();
		}
		try {
			for (int i = 0; i < 10; i++) {
				parkingManager.unPark();
			}
		} catch (ParkingException e) {
			Assert.fail();
		}
	}
}
