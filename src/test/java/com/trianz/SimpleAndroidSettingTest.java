package com.trianz;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class SimpleAndroidSettingTest {

 AppiumDriver driver;

 @BeforeTest
 public void setUp() throws MalformedURLException, InterruptedException {
  // Created object of DesiredCapabilities class.
  DesiredCapabilities capabilities = new DesiredCapabilities();
 
  // Set android deviceName desired capability. Set your device name.
  

  // Set BROWSER_NAME desired capability. It's Android in our case here.
  //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

  // Set android VERSION desired capability. Set your mobile device's OS version.
  //capabilities.setCapability(CapabilityType.VERSION, "4.4.2");

  // Set android platformName desired capability. It's Android in our case here.
  capabilities.setCapability("platformName", "Android");
  capabilities.setCapability("deviceName", "Emulator");

  // Set android appPackage desired capability. It is
    //capabilities.setCapability("appPackage", "com.android.settings");
  capabilities.setCapability("appPackage", "com.trianz.datavisionplus");
  // Set android appActivity desired capability. It is
    //capabilities.setCapability("appActivity", ".MainSettings");
    capabilities.setCapability("appActivity", "com.trianz.datavisionplus.MainActivity");
    capabilities.setCapability("autoAcceptAlerts", true);
    capabilities.setCapability("waitForAppScript", true);
  // Created object of RemoteWebDriver will all set capabilities.
  // Set appium server address and port number in URL string.

  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 // Thread.sleep(90000);
 }

 @Test
 public void Setting() throws InterruptedException {
  
   /*String test=driver.findElement(By.name("More")).getText();
   System.out.println(test);
   driver.findElement(By.name("More")).click();
   Thread.sleep(5000);
   driver.findElement(By.name("Airplane mode")).click();
   Thread.sleep(5000);*/
   

	Thread.sleep(50000);
	WebElement userName=driver.findElement(By.className("android.widget.EditText"));
	Thread.sleep(2000);
	userName.sendKeys("Srinivas.Marry@trianz.com");
	Thread.sleep(2000);
	WebElement passWord=driver.findElement(By.xpath("//android.widget.EditText[2]"));          ////android.widget.EditText[2]
	passWord.sendKeys("Passw0rd@");
	Thread.sleep(15000);
	WebElement	login = driver.findElement(By.xpath("//*[@content-desc='Login']"));
	login.click();
	Thread.sleep(15000);
	
	
	/*WebElement Group=driver.findElementByXPath("//*[@content-desc='trianz_Group This group is a default group created by admin']");
	Group.click();*/
	/*WebElement el=driver.findElement(By.xpath("//android.view.View"));
	el.click();
	driver.findElementByXPath("//*[@content-desc='Test_Group This group is created for testing Datavision Application']");*/
	/*WebElement	testGroup = driver.findElement(By.xpath("//*[@content-desc='SrinivasLogout']"));
	testGroup.click();
	Thread.sleep(15000);
	
	
	WebElement	checkbox = driver.findElementByClassName("android.widget.CheckBox");
	checkbox.click();
	Thread.sleep(10000);
	WebElement	executeTestPlan = driver.findElementByName("Execute Test Plan");
	executeTestPlan.click();
	Thread.sleep(20000);
	
	
	driver.navigate().back();*/
	Thread.sleep(20000);
	
 }

@AfterTest
 public void End() {
  driver.quit();
 }
}
