package com.amazonaws.tests;

import static org.testng.Assert.assertTrue;

public class AWSCalculatorTests extends TestBaseClass{
	public void defaultMonthlyBillTest() {
		assertTrue(calculator.isAt());
	}

}
