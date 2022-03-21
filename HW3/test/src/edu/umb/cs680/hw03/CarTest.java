package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	private String[] carToStringArray(Car car) {
		String[] carStringArray = new String[3];
		carStringArray[0] = car.getMake();
		carStringArray[1] = car.getModel();
		carStringArray[2] = car.getYear() + "";
		return carStringArray;
	}
	
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Maruti", "Alto800", "2021"};
		Car actual = new Car("Maruti", "Alto800", 2021);
		assertArrayEquals(expected, carToStringArray(actual));
	}

	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Maruti", "zen", "1997"};
		Car actual = new Car("Maruti", "zen", 1997);
		assertArrayEquals(expected, carToStringArray(actual));
	}
}