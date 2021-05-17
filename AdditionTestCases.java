package QualityKioskTraining.CalculatorAPI;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

public class AdditionTestCases {
	
	Calculator Obj;
	int Result;
	@BeforeGroups("RegressionTest")
	public void InitGroup() {
		System.out.println("I am in the Before group");
		Obj=new Calculator();
	}
	@BeforeClass
	public void Init() {
		System.out.println("I am in the Before Class");
		Obj=new Calculator();
	}
	@BeforeMethod
	public void ReinitialiseResultVar()
	{
		System.out.println("Im in before Method");
		Result=0;
	}
	
	@Test(priority=1,groups={"RegressionTest"})
	public void TestAdditionWithPositiveNumbers()
	{
		System.out.println("Im in 1 class");
		 Result=Obj.Addition(10,20);
		Assert.assertEquals(Result, 30,"Addition does not work with positive number");
		
	}
	
	@Test(priority=2,groups={"RegressionTest"})
	public void TestAdditionWithNegativeNumbers()
	{
		System.out.println("Im in 2 class");
		 Result=Obj.Addition(-10,-20);
		Assert.assertEquals(Result, -30,"Addition does not work with positive number");
	}
	
	@Test(priority=4)
	public void TestAdditionWithZeroeNumbers()
	{
		System.out.println("Im in 4 class");
		Result=Obj.Addition(0,0);
		Assert.assertEquals(Result, 0,"Addition does not work with Zero number");
		
	}
	
	@Test(priority=3)
	public void TestAdditionWithOnePositiveOneNegativeNumbers()
	{
		System.out.println("Im in 3 class");
		Result=Obj.Addition(100,-50);
		Assert.assertEquals(Result, 50,"Addition does not work with 1 positive 1 negative number");
		
	}
	
	@AfterClass
	public void Teardown()
	{
		System.out.println("Im in Afterclass");
		Obj=null;
	}
	
	

}
