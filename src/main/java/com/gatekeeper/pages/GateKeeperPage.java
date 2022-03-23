package com.gatekeeper.pages;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.gatekeeper.base.TestBase;

public class GateKeeperPage extends TestBase {

	// Page Factory - OR
	@FindBy(id = "mat-input-0")
	WebElement firstNum;

	@FindBy(xpath = "//*[@id=\"mat-input-1\"]")
	WebElement secondNum;

	@FindBy(xpath = "//*[@id=\"mat-input-2\"]")
	WebElement result;

	@FindBy(xpath = "//*[@id=\"mat-input-3\"]")
	WebElement searchBar;

	@FindBy(xpath = "/html/body/app-root/app-test/div/div/div[1]/div[3]/div/div")
	WebElement searchResult;

	@FindBy(xpath = "/html/body/app-root/app-test/div/div/div[1]/div[4]/button/span")
	WebElement battleBtn;

	@FindBy(xpath = "//div[@class='arena']/div/i[@style]")
	WebElement target;

	@FindBy(xpath = "//span[contains(text(),'Vefabey Sokak, No:16 D:11, 34349, Gayrettepe/Istanbul/Turkey')]")
	WebElement displayedAddress;

	@FindBy(id = "comp-kvi6khho")
	WebElement expectedAddress;

	// Initializing the Page Objects
	public GateKeeperPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String displayedSum(int num1, int num2) {
		firstNum.sendKeys("" + num1);
		secondNum.sendKeys("" + num2);
		return result.getAttribute("value");
	}

	public String expectedSum(int num1, int num2) {
		String sum = String.valueOf(num1 + num2);
		return sum;
	}

	public void clickBattleBtn() {
		battleBtn.click();
	}

	public void clickTarget() {
		target.click();
	}

	public String displayedSearchResult(String uniName) {
		searchBar.sendKeys(uniName, Keys.ENTER);
		return searchResult.getText();

	}

	public boolean verifyAddress() {

		String actualAddress = displayedAddress.getText().trim();
		driver.switchTo().frame("iframe");
		String correctAddress = expectedAddress.getText().trim();
		System.out.println(correctAddress);
		System.out.println(actualAddress);

		if (actualAddress.equals(correctAddress)) {
			return true;
		}
		return false;
	}
}
