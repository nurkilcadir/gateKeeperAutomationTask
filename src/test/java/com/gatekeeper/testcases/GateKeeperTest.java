package com.gatekeeper.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.gatekeeper.base.TestBase;
import com.gatekeeper.pages.GateKeeperPage;

public class GateKeeperTest extends TestBase {
	GateKeeperPage gatekeeper;

	public GateKeeperTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		gatekeeper = new GateKeeperPage();
	}

	@Test(priority = 1)
	public void mathTest() {
		String displayedSum = gatekeeper.displayedSum(10, 20);
		String expectedSum = gatekeeper.expectedSum(10, 20);

		Assert.assertEquals(displayedSum, expectedSum, "Result verification is failed");
		System.out.println("Result verification is passed");
	}

	@Test(priority = 2)
	public void searchTest() {
		String actualSearchResult = gatekeeper.displayedSearchResult("bobi");
		Assert.assertEquals(actualSearchResult, "Bobi Codeshake", "Result verification is failed");
		System.out.println("Bobi is found");
	}

	@Test(priority = 3)
	public void popUpTest() {
		gatekeeper.clickBattleBtn();
		gatekeeper.clickTarget();
	}

	@Test(priority = 4)
	public void verifyAddressTest() {
		Boolean verifyAddress = gatekeeper.verifyAddress();
		Assert.assertTrue(verifyAddress);
		System.out.println("Address is verified");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
