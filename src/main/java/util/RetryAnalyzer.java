package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int retry = 2;
	int count = 0;
	public boolean retry(ITestResult result) {
		
		while(count<retry) {
			count++;
			return true;
		}
		return false;
	}


}
