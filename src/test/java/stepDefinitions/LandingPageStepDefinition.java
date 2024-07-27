package stepDefinitions;

import java.io.IOException;
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
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	TestContextSetup testContextSetup;
	public LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() throws IOException {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		
	}
	@When("^User searched with shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
		//LandingPage landingPage=new LandingPage(testContextSetup.driver);
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName+" is the extracted from Home Page");
	    
	}
	@When("Added {string} items to the selected product to cart")
	public void added_items_product(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
}
