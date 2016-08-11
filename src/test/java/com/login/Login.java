package com.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public WebDriverWait createWait(WebDriver driver){
		return new WebDriverWait(driver, 120);
	}
	
	@Given ("^User is on Gmail home Page$")
	public void openHomePage(){
		System.out.println("User is on Gmail home Page");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://gmail.com");
		wait= createWait(driver);
	}
	@When ("^User enters UserName and Password$")
	public void doLogin(){
		System.out.println("User is on Gmail home Page");
		driver.findElement(By.id("Email")).sendKeys("orbitztest007");
		driver.findElement(By.id("next")).click();
		WebElement passwordFeild = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
		passwordFeild.sendKeys("Orbitz@1234");
		driver.findElement(By.id("signIn")).click();
	}
	@Then ("^Should login successfully$")
	public void checkLogin(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}
	
}
