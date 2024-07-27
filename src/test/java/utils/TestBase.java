package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("QAUrl");
		String browser_properties=prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		String browser=browser_maven!=null?browser_maven:browser_properties;
		if(driver==null) {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", "D:\\rahulshettyacademy\\CucumberAutomation\\driver\\chromedriver126.exe");
				driver=new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get(url);
		}
		return driver;
	}

}
