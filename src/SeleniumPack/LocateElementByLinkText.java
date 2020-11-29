package SeleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementByLinkText {

	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
		driver = new ChromeDriver();//launching browser
		driver.get("https://www.calculator.net/calorie-calculator.html");//navigating to url
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement BMILink = driver.findElement(By.linkText("BMI"));
		BMILink.click();
		System.out.println("Title of the BMI Page is " + driver.getTitle());
		boolean titleflag = driver.getTitle().equals("BMI Calculator");
		System.out.println("Expected and Actual Title of BMI Page matches ");
		//from the BMI Page - I want to click on first link which has part of the text as Weight
		Thread.sleep(3000);
		WebElement idealWeightLink = driver.findElement(By.partialLinkText("Weight"));
		idealWeightLink.click();
		System.out.println("Print the Title of the  Page = " + driver.getTitle());
		
		//get all the links
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for(WebElement link : allLinks) {
			System.out.println(link.getText() + " " + link.isDisplayed());
		}
	}

}
