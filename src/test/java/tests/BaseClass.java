package tests;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Propertyreader;

public class BaseClass {
public static WebDriver driver;

@BeforeMethod
public void launching() throws IOException {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(Propertyreader.readProperty("URL"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
@AfterMethod
public void tearDown()
{
	driver.quit();
}
public void screenshottaking(String name) {
	String path=".//Screenshots//"+name+".jpg";
	TakesScreenshot tss=(TakesScreenshot) driver;
	File srcFile=tss.getScreenshotAs(OutputType.FILE);
	File destFile=new File(path);
	try {
		FileHandler.copy(srcFile, destFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Screenshot Captured...!!!");
}
	
	
}
