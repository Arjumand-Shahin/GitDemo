package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}
	
	@Then("^User searched with same shortname (.+) in offers page$")
	public void user_searched_with_same_shortname_in_offers_page(String shortName) {
		switchToOffersPage();
		OfferPage offerPage=testContextSetup.pageObjectManager.getOfferPage();
		//OfferPage offerPage=new OfferPage(testContextSetup.driver);
		offerPage.search(shortName);
		offersPageProductName=offerPage.productName();
		    
	}
	public void switchToOffersPage() {
		//OfferPage offerPage=new OfferPage(testContextSetup.driver);
		//pageObjectManager=new PageObjectManager(testContextSetup.driver);
		//OfferPage offerPage=pageObjectManager.getOfferPage();
		OfferPage offerPage=testContextSetup.pageObjectManager.getOfferPage();
		offerPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();
			
	}
	@Then("Validate product name in offers page matches with the landing page")
	public void Validate_product_name_in_offers_page_matches_with_the_landing_page() {
		Assert.assertEquals(testContextSetup.landingPageProductName, offersPageProductName);
	}
	

}
