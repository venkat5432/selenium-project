package com.secookbook.learn;
import static org.junit.Assert.assertArrayEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.opencsv.CSVReader;


//@RunWith(value = Parameterized.class)
public class GoogleSearchTest {

	private static WebDriver driver;
//	private static StringBuffer verificationErrors = new StringBuffer();
/*
	private String height;
	private String weight;
	private String bmi;

	public GoogleSearchTest(String height,String weight,String bmi)
	{
		this.height=height;
		this.weight=weight;
		this.bmi=bmi;
	}
	*/
	@Test
	public void init(){

		
		System.setProperty("webdriver.gecko.driver","src\\test\\resources\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		List<String> expectedOptions=Arrays.asList("Asia","Europe","Africa","Australia","South America","North America","Antartica");
		List<String> actualOptions= new ArrayList<String>();
		Select dropDown=new Select(driver.findElement(By.id("continents")));
		for(WebElement eachElement:dropDown.getOptions())
		{
			actualOptions.add(eachElement.getText());
		}
		assertArrayEquals(expectedOptions.toArray(),actualOptions.toArray());
		System.out.println("hi1");
		//System.out.println(height+weight+bmi);
	}
	
	/*@Parameters
	public static List<String[]> testData() throws IOException {
		
		CSVReader reader=new CSVReader(new FileReader("\\test\\resources\\asdf.csv"));
		List<String[]> entries=reader.readAll();
		reader.close();
		return entries;
				
	}*/
}
