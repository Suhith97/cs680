package edu.umb.cs680.hw11;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw11.Car;
import edu.umb.cs680.hw11.YearComparator;

public class YearComparatorTest {

	@Test
	public void YearDescOrderTest() {
		LinkedList<Car> usedCars = new LinkedList<>();
		Car car1 = new Car("Tata", "INDICA", 50000, 2009, 5000.0f);
		Car car2 = new Car("Benz", "C200", 60000, 2008, 6000.0f);
		Car car3 = new Car("Audi", "Q5", 40000, 2010, 4000.0f);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car3);
		expected.add(car1);
		expected.add(car2);
		Collections.sort(usedCars, new YearComparator());
		Assert.assertArrayEquals(expected.toArray(), usedCars.toArray());
	}
}