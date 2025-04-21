package Mb_Search;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mbsearch.base.TestBase;

public class Mb_ldp extends TestBase {
	
	public int num1;
	
	@FindAll({@FindBy(xpath="//*[contains(text(), 'locality')]")})
	public static List <WebElement>  localitymenu;

	@FindBy(xpath="//div[contains(@class,'filter__component topBudget activeFilter')]//div[contains(@class,'filter-budget__fieldset__min-max min')]//select[contains(@class,'filter-budget__select')]")
	public static WebElement pricemenu;
	
	@FindBy(xpath=("//div[contains(@class,'title-ellipsis')][normalize-space()='Top Localities']"))
	public static WebElement toplocalities;
	

	
	
	
	public Mb_ldp()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonlocalitymenu() 
	{
		toplocalities.click();
		//localitymenu.get(1).click();
	}
	
	
	
	
}
