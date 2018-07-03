package com.qait.bingtranslator;
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
	@Test(priority=1)
	public void launchBrowser()
	{
		driver=new ChromeDriver();
		js=(JavascriptExecutor)driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vipulsrivastava\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver.get("https://www.bing.com/translator");
		
	}
	@Test(priority=2)
	public void testTranslation() throws InterruptedException
	{
		js.executeScript("document.getElementById('t_tl').value = 'hi'");
		js.executeScript("document.getElementById('t_sv').value='hello';");
		Thread.sleep(4000);
		
	//	js.executeScript("document.getElementById('t_tl').value='hi'");
		String result =(String)js.executeScript(" return document.getElementById('t_tv').value");
		Assert.assertEquals("नमस्कार",result);
		
	}/*
	@Test(priority=3)
	public void testClearButton() throws InterruptedException
	{
		js.executeScript("retrun document.getElementById('t_edc').click();");
		js.executeScript("document.getElementById('t_sv').value='hello';");
		Thread.sleep(4000);
		
	//	js.executeScript("document.getElementById('t_tl').value='hi'");
		String result =(String)js.executeScript(" return document.getElementById('t_tv').value");
		Assert.assertEquals("नमस्कार",result);
		
	}*/
	@Test(priority=3)
	public void testSwitch() throws InterruptedException
	{
		js.executeScript(" return document.getElementById('t_revIcon').click();");
		String box1 =(String)js.executeScript(" return document.getElementById('t_sv').value");
		String box2 =(String)js.executeScript(" return document.getElementById('t_tv').value");
		Assert.assertEquals("नमस्कार",box1);
		Assert.assertEquals("Hello",box2);
		}
	
	
}
