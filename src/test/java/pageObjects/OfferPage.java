package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
	public WebDriver driver;
	public OfferPage(WebDriver driver) {
		this.driver=driver;
	}
	By search=By.id("search-field");
	By productName=By.xpath("//tr/td[1]");
	By topDeals=By.linkText("Top Deals");
	
	public void search(String name) {
		driver.findElement(search).sendKeys(name);
	}
	public String productName() {
		return driver.findElement(productName).getText();
	}
	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}

}
