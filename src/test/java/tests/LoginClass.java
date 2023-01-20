package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class LoginClass extends BaseClass{
	
	@Test
	public void failTest() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void search() {
		System.out.println("Hello");
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void clickbtn() {
		
	}

}
