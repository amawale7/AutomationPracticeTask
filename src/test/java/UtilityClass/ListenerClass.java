package UtilityClass;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Pages.CreateAccount;

public class ListenerClass implements ITestListener
{
	
	static Logger log=Logger.getLogger(ListenerClass.class.getName());
	
    @Override		
    public void onTestFailure(ITestResult result) 
    {					
       	log.info("Test is Fail="+result.getName());		
    }		

    @Override		
    public void onTestSkipped(ITestResult result)
    {					
       	log.info("Test is Skipped="+result.getName());				
    }		

    @Override		
    public void onTestStart(ITestResult result)
    {					
       log.info("Test is Start="+result.getName()); 			
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult result)
    {					
     				
       log.info("Test is Success"+result.getName()); 		
    }		
 
}
