package QualityKioskTraining.CalculatorAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMultiplication {
	Calculator Cal;
	int Result;
	
	@BeforeClass
	public void Init()
	{
		System.out.println("I am in Multiplication class");
		Cal=new Calculator();
		
	}
	@BeforeGroups("RegressionTest")
	public void InitGroup() {
		System.out.println("I am in the Before group");
		Cal=new Calculator();
	}

	@BeforeMethod
	public void ReinitalisingResult()
	{
		Result=0;
	}
	
	@Test(priority=1,dataProvider="ProvidePositiveIntegerValues",groups= {"RegressionTest"})
	public void TestMultiplicationWithPositiveValues(int number1,int number2,int ExpectedResult)
	{
		System.out.println("I am in 1 test");
		Result=Cal.Multiplication(number1, number2);
		Assert.assertEquals(Result,ExpectedResult, "Multiplication does not work with positive number");
	}
	
	@DataProvider
	public Object[][] ProvidePositiveIntegerValues()
	{
		
		Object[][] SetOfValues=new Object[4][3];
		
		SetOfValues[0][0]=1;
		SetOfValues[0][1]=2;
		SetOfValues[0][2]=2;
		
		SetOfValues[1][0]=10;
		SetOfValues[1][1]=20;
		SetOfValues[1][2]=200;
		
		SetOfValues[2][0]=100;
		SetOfValues[2][1]=200;
		SetOfValues[2][2]=20000;
		
		SetOfValues[3][0]=1000;
		SetOfValues[3][1]=2000;
		SetOfValues[3][2]=2000000;
		
		return SetOfValues;
		
	}
		@BeforeSuite
		@Parameters({"RequestID"})
		public void CreateResultFolder(String RequestID)
		{
			System.out.println("Iam in before suite");
			try
			{
			Files.createDirectories(Paths.get("./"+RequestID));
			}
			catch(IOException e)
			{
				System.out.println("Problem while creating dir");
			}
		}
		
		@AfterSuite
		@Parameters({"RequestID"})
		public void CopyResultFile(String RequestID)
		{
			System.out.println("Iam in after suite");
			try {
				Files.copy(Paths.get(".\\target\\surefire-reports\\emailable-report.html"),Paths.get("./"+RequestID+"/Result.html"), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				
				System.out.println("Problem while creating dir");
			}
		}
		
	
	
	
}
