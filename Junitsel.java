import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Jtest {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	String CONFIG="Chrome";
	/*if (driver == null) {
			if (CONFIG.getProperty("browser").equalsIgnoreCase("Mozilla")) {
				System.setProperty("webdriver.gecko.driver", "F:\\Naveen_work\\selenium\\geckodriver.exe");
				driver = new FirefoxDriver();				
			}
			else if (CONFIG.getProperty("browser").equalsIgnoreCase("IE")) {*/
				System.setProperty("webdriver.ie.driver", "F:\\Naveen_work\\selenium\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();				
			/*}
			else if (CONFIG.getProperty("browser").equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "F:\\Naveen_work\\selenium\\chromedriver.exe");
				driver = new ChromeDriver();				
			/*}
			else {
				System.setProperty("webdriver.chrome.driver", "F:\\Naveen_work\\selenium\\chromedriver.exe");
				driver = new ChromeDriver();
			}*/			
				driver.get("https://www.lambdatest.com/selenium-automation");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("inside test");
			Actions A= new Actions(driver);
			WebElement w1=driver.findElement(By.xpath("//*[@id='__next']/div[1]/section[8]/div/div/div/div[2]/div/div[4]/div/div[1]/text()"));
			A.moveToElement(w1).build().perform();
			driver.findElement(By.xpath("//*[@id='__next']/div[1]/section[8]/div/div/div/div[2]/div/div[4]/div/div[2]/span/a")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			int cnt=1;
			String parent_wnd_hdle="";
			for (String w2 : windowHandles) 
			{
				if(cnt==1)
				{
					parent_wnd_hdle=w2;
				}
				driver.switchTo().window(w2);
				cnt++;
			}
			String comp_url=driver.getCurrentUrl();
			if(comp_url.equalsIgnoreCase("https://www.lambdatest.com/support/docs/integrations-with-ci-cd-tools/"))
			{
				 JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
			        driver.close();
			        driver.switchTo().window(parent_wnd_hdle);
			        Actions A1= new Actions(driver);
			        WebElement w4=driver.findElement(By.xpath("//button[contains(text(),'Resources')]"));
			        A1.moveToElement(w4).build().perform();
			        driver.findElement(By.linkText("Newsletter")).click();
			        driver.findElement(By.cssSelector("#__next > section > div > div > div > div > div.mt-30 > a")).click();
			        if(driver.findElement(By.xpath("//h1")).getText().equals("All Editions"))
			        {
			        	driver.quit();
			        }
			        else
			        {
			        	Assert.assertFalse("not equal", true);
			        }
			}
			else
			{
				Assert.assertFalse(true);
			}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		}

}
