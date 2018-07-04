package com.qait.bingtranslator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

public class testbingt {

	WebDriver driver;
	JavascriptExecutor js;

	@Test(priority = 1)
	public void launchBrowser() {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vipulsrivastava\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver.get("https://www.bing.com/translator");
		Assert.assertEquals("Bing Microsoft Translator",driver.getTitle());
		

	}

	@Test(priority = 2)
	public void testTranslation() throws InterruptedException {
		js.executeScript("document.getElementById('t_tl').value = 'hi'");
		js.executeScript("document.getElementById('t_sv').value='Hello';");
		Thread.sleep(4000);

		// js.executeScript("document.getElementById('t_tl').value='hi'");
		String result = (String) js.executeScript(" return document.getElementById('t_tv').value");
		Assert.assertEquals("नमस्कार", result);

	}

	
	@Test(priority = 3)
	public void testSwitch() throws InterruptedException {
		js.executeScript(" return document.getElementById('t_revIcon').click();");
		Thread.sleep(4000);
		String box1 = (String) js.executeScript(" return document.getElementById('t_sv').value");
		String box2 = (String) js.executeScript(" return document.getElementById('t_tv').value");

		Assert.assertEquals("नमस्कार", box1);

		Assert.assertEquals("Hello", box2);
	}


//	@Test(priority = 4)
	public void testSound() {
		String classnamebeforeclick = (String) js
				.executeScript("return document.getElementById('t_srcplaycIcon').className");
		js.executeScript("document.getElementById('t_srcplaycIcon').click();");
		// js.executeScript("document.querySelector('a < a:nth-child(1)').click();");
		String classnameafterclick = (String) js
				.executeScript("return document.getElementById('t_srcplaycIcon').className");
		System.out.println(classnamebeforeclick + " " + classnameafterclick);
		Assert.assertNotEquals(classnamebeforeclick, classnameafterclick);

	}
	
	// @Test(priority=4) 
	 public void testCopyButton() {
	 //js.executeScript("document.getElementById('t_copyIcon').click();");
	 System.out.println("before");
	String copiedvalue= (String)js.executeScript("document.addEventListener('copy', function (event) {" + 
			"  var clipText = event.clipboardData.getData('text'); console.log(clipText);return clipText;" + 
			"});document.getElementById('t_copyIcon').click();");
	System.out.println(copiedvalue);
	String box2 = (String) js.executeScript(" return document.getElementById('t_tv').value");
	 
	  Assert.assertEquals(copiedvalue,box2);
	  }
	 
	 @Test(priority=4)
	 public void noneditablebox() {
		 
		 driver=(WebDriver)js;
		 js.executeScript(" return document.getElementById('t_sv').value='add'");
		//	driver.findElement(By.id("t_sv")).sendKeys("add");  
			String box1 = (String) js.executeScript(" return document.getElementById('t_sv').value");
			 Assert.assertEquals("add",box1);
		  }
		 
	 @Test(priority=5)
	 public void editablebox() {
		 
		 driver=(WebDriver)js;
			driver.findElement(By.id("t_tv")).sendKeys("add");  
			String box2 = (String) js.executeScript(" return document.getElementById('t_tv').value");
			 Assert.assertEquals("Hello",box2);
		  }
		 
	 
	 
	 
	 
	 

		@Test(priority=6) 
		public void testClearButton() throws InterruptedException {
			  js.executeScript("document.getElementById('t_edc').click();");
			  String classname=(String)js.executeScript("return document.getElementById('t_edc').className");
					  	  Assert.assertEquals("b_hide",classname);
			  
			  }
		
		
		

}
