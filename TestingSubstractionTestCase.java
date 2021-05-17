package QualityKioskTraining.CalculatorAPI;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingSubstractionTestCase {
	
	Calculator Cal;
	int result;
	
	@BeforeClass
	public void Init()
	{
	System.out.println("I am in the substraction class");
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
		result=0 ;
	}
	@Test(priority=1,groups= {"RegressionTest"})
	public void TestSubstractionWithPositiveNumber()
	{
		System.out.println("I am in 1 test");
		int Result=Cal.Substraction(50, 20);
		Assert.assertEquals(Result, 30, "Substraction Does not work with Positive Number");
	}
	
	@Test(priority=2)
	public void TestSubstractionWithOnePositiveOneNegativeNumber()
	{
		int Result=Cal.Substraction(50, -20);
		Assert.assertEquals(Result, 70, "Substraction Does not work with one Positive one negative Number");
	}

	@AfterClass
	public void Teardown()
	{
		Cal=null;
	}
}
