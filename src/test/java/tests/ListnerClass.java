package tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		//getTestContext().getName()
		screenshottaking(result.getMethod().getMethodName());
	}

}
