package QualityKioskTraining.CalculatorAPI;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class TestDivision {
	Calculator Cal;
	int result;
	
	@BeforeClass
	public void Init()
	{
	System.out.println("I am in the Division class");
		Cal=new Calculator();
		
	}
	
	@BeforeGroups("RegressionTest")
	public void InitGroup() {
		System.out.println("I am in the Before group");
		Cal=new Calculator();
	}
	
	@BeforeMethod
	public void Reinitialised()
	{
		System.out.println("I am in the before method");
		result=0 ;
	}
	@Test(priority=1,groups= {"RegressionTest"})
	public void TestDivisionWithPositiveNumber()
	{
		System.out.println("I am in the test 1");
		int Result=Cal.Division(50, 2);
		Assert.assertEquals(Result, 25, "Division Does not work with Positive Number");
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("In After Method");
	}
	
	@Test(priority=2)
	public void TestDivisionWithNegativeNumber()
	{
		System.out.println("I am in the test 2");
		int Result=Cal.Division(100, -2);
		Assert.assertEquals(Result, -50, "Division Does not work with Negative Number");
	}

	
	@AfterClass
	public void Teardown()
	{
		System.out.println("I am in the after class");
		Cal=null;
	}

}
