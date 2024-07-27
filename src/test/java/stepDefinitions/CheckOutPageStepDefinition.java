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
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckOutPageStepDefinition {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	public CheckOutPage checkoutPage;
	
	public CheckOutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.checkoutPage=testContextSetup.pageObjectManager.getCheckOutPage();
	}
	
	@Then("verify user has ability to enter promocode and place the order")
	public void verify_user_has_ability_to_enter_promocode_and_place_the_order() {
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
	}
	@Then("^User proceed to checkout and validate the (.+) items in checkout page$")
	public void User_proceed_to_checkout(String name) throws InterruptedException {
		checkoutPage.checkOutItems();
	}
	
}
