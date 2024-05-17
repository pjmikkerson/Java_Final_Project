package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import driver.ShedMaterialCalculatorMidterm;
import model.*;

/**
 * Peter Keeler - PmKeeler CIS171 25949/Wed 12:50 Feb 22, 2024
 */
class ShedMaterialCalculatorMidtermTest {

	@Test
	public void testGetInch() {
		assertEquals(960, Measurement.getInch("960\""));
		assertEquals(96, Measurement.getInch("0\'96\""));
		assertEquals(96, Measurement.getInch("8\'"));
		assertEquals(192, Measurement.getInch("8\'96\""));
	}

	@Test
	public void testGetFeetAndInches() {
		assertEquals("80\'0\"", Measurement.getFeetAndInches(960));
		assertEquals("8\'0\"", Measurement.getFeetAndInches(96));
		assertEquals("8\'4\"", Measurement.getFeetAndInches(100));
		assertEquals("16\'0\"", Measurement.getFeetAndInches(192));
		assertEquals("0\'11\"", Measurement.getFeetAndInches(11));
	}

	@Test
	public void GetLinealLumber() {
		assertEquals(80, Lumber.getLinealLumber(10, 10));
		assertEquals(840, Lumber.getLinealLumber(80, 130));
		assertEquals(576, Lumber.getLinealLumber(96, 48));
		assertEquals(1152, Lumber.getLinealLumber(96, 192));
		assertEquals(1020, Lumber.getLinealLumber(120, 135));
	}

	@Test
	public void testGetStudCount() {
		assertEquals(18, Lumber.getStudCount(120, 120));
		assertEquals(30, Lumber.getStudCount(80, 96));
		assertEquals(26, Lumber.getStudCount(96, 48));
		assertEquals(42, Lumber.getStudCount(100, 145));
		assertEquals(56, Lumber.getStudCount(172, 200));
	}

	@Test
	public void testEstimatePlywood() {
		// Test case 1: length = 96", width = 48", height = 96"
		assertEquals(2, Plywood.estimatePlywood(48, 48, 48));
		assertEquals(6, Plywood.estimatePlywood(96, 48, 96));
		assertEquals(10, Plywood.estimatePlywood(192, 48, 96));
		assertEquals(8, Plywood.estimatePlywood(96, 96, 96));
		assertEquals(7, Plywood.estimatePlywood(96, 48, 100));
		assertEquals(9, Plywood.estimatePlywood(70, 134, 100));
	}

	@Test
	public void testGetSiding() {
		assertEquals(40, Siding.estimateSiding(120, 120, 120));
		assertEquals(4.0, Siding.estimateSiding(12, 12, 120));
		assertEquals(4.0, Siding.estimateSiding(9, 12, 120));
		assertEquals(8.0, Siding.estimateSiding(12, 12, 240));
		assertEquals(10.0, Siding.estimateSiding(60, 60, 60));
		assertEquals(0, Siding.estimateSiding(60, 60, 0));
	}

}
