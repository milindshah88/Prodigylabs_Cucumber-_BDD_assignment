package Pompackage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Contactpage  {
	



public  WebDriver ldriver;


public Contactpage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
	System.out.println("driverinit");
}

		
@FindBy(linkText="Contact")
@CacheLookup
WebElement Link;


@FindBy (id="hs-eu-confirmation-button")
@CacheLookup
WebElement Acceptbutton;

@FindBy (xpath="//input[@name='firstname']")
@CacheLookup
WebElement Firstnametxtbox;

@FindBy (xpath="//input[@name='lastname']")
@CacheLookup
WebElement Lastnametxtbox;

@FindBy (xpath="//input[@name='email']")
@CacheLookup
WebElement Emailtxtbox;

@FindBy (xpath="//label[contains(text(),'Email must be formatted correctly.')]")
@CacheLookup
WebElement invalidemailerrormessage;

//@FindBy (="//select[@id='industry-b5332bff-db21-4424-9558-9e2cc3535cda']")

@CacheLookup
WebElement Industrydropdown;


@FindBy (id="city-b5332bff-db21-4424-9558-9e2cc3535cda")
@CacheLookup
WebElement Citytxtbox;

@FindBy (xpath="//input[@type='submit']")
@CacheLookup
WebElement submitbutton;

public void acceptcookies () {
	Acceptbutton.click();
	
	
}



public void verifylinkispresent()
{
if (Link.isEnabled())	
{ 
	Assert.assertTrue(true);
	}
else {
	Assert.assertTrue(false);
	
}


}
public void clickoncontactlink ()

{
Link.click();	
}



public void scroll(JavascriptExecutor ldriver)

{
	
	((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", Firstnametxtbox);	

}


public void fillfirstname(String fname)
{
	
	
Firstnametxtbox.sendKeys(fname);	
}

public void filllastname(String lname)
{
Lastnametxtbox.sendKeys(lname);	
}


public void fillinvalidemail (String wrongemail)


{
	Emailtxtbox.sendKeys(wrongemail);
	
}



public void fillvalidemail (String validemail)

{ Emailtxtbox.clear();
	Emailtxtbox.sendKeys(validemail);
	}

public void fillcityname (String cityname)
{
	Citytxtbox.sendKeys(cityname);
}

public void clicksubmit()

{
submitbutton.click();	

}



public void doSelectbyVisibleText()

{
	Select se = new Select(Industrydropdown);
	se.selectByIndex(10);
	}

}


