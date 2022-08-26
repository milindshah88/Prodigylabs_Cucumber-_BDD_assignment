package Stepdef;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Pompackage.Contactpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdef   {
	


public Contactpage cp;

static   WebDriver driver;

	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mkuma\\eclipse-workspace\\Module1.0\\chromedriver.exe");
		driver  =new ChromeDriver();
		cp= new Contactpage(driver);
		
	
	}

	@When("user visits url ={string}")
	public void user_visits_url(String url) throws InterruptedException {
	    driver.get(url);
	    driver.manage().window().maximize();
	    
	    cp.acceptcookies();
	 
	}

	@Then("Contact link should be available on the page")
	public void contact_link_should_be_available_on_the_page() throws InterruptedException {
	
    cp.verifylinkispresent();
  Thread.sleep(3000);
	}

	@Then("User click on Contact link")
	public void user_click_on_contact_link() throws InterruptedException {
	       cp.clickoncontactlink();
	       Thread.sleep(3000);
	}

	@Then("Page should display contact email ={string} and address ={string}")
	public void page_should_display_contact_email_and_address(String email, String address) {
		
		
		//driver.switchTo().frame(0);
	    if(driver.getPageSource().contains(email)) {
	    	if(driver.getPageSource().contains(address))
	    	{
	    		Assert.assertTrue(true);
	    	}
	    else {
	    	Assert.assertTrue(false);
	    	driver.close();
	    	}
	    	
	    }
	}

	@Then("User fill out Firstname ={string} and Last Name ={string}")
	public void user_fill_out_firstname_and_last_name(String firstname, String lastname) throws InterruptedException {
		driver.switchTo().frame(0);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@name='firstname']")));
		Thread.sleep(2000);
	cp.fillfirstname(firstname);
	cp.filllastname(lastname);
	}

	@When("User enters invalid email ={string}")
	public void user_enters_invalid_email(String incorrectemail) throws InterruptedException {
	 cp.fillinvalidemail(incorrectemail);
	 Thread.sleep(3000);
	}

	@Then("Error message ={string} is displayed")
	public void error_message_is_displayed(String errormessage) {
		String message = driver.findElement(By.xpath("//label[@data-reactid='.hbspt-forms-0.1:$1.1:$email.3.$0.0']")).getText();
	
	Assert.assertEquals(errormessage, message);
	}

	@Then("User enters correct email ={string}")
	public void user_enters_correct_email(String validemail) throws InterruptedException {
	    
		cp.fillvalidemail(validemail);
		Thread.sleep(3000);
	}

	@Then("User select Industry as Banking from the dropdown")
	public void user_select_industry_as_from_the_dropdown() {


		  
		  List <WebElement>  listindustry = driver.findElements(By.xpath("//select[@name='industry']//option"));

		  System.out.println(listindustry.size());
		  
		  for (int i=0; i<listindustry.size(); i++) {
		  System.out.println(listindustry.get(i).getText());
		  
		  if
		  (listindustry.get(i).getText().equals("Banking")) 
		  {
		  listindustry.get(i).click(); break;
		  
		  }
		 
		  }
		}
				
		

	@Then("User Enter City as ={string}")
	public void user_enter_city_as(String city) throws InterruptedException {
	 
		cp.fillcityname(city);
		Thread.sleep(2000);
	}

	@Then("User Submit the from")
	public void user_submit_the_from() {
	   cp.clicksubmit();
	}
}
