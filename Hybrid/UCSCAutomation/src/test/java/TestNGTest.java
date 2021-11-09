//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//public class TestNGTest {
//	
//	
//
//	@Test
//	public void setup() {
//		System.out.println("Thisara");
//		
//		System.setProperty("webdriver.chrome.driver","C://Users//User//Downloads//Compressed//chromedriver_win32//chromedriver.exe");
//		
//		WebDriver driver = new ChromeDriver();   
//		
//		driver.get("https://demo.actitime.com/login.do");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
//		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		
//		driver.findElement(By.id("username")).sendKeys("admin");
//		
//		//driver.quit();
//		
//	}
//	
////	@BeforeMethod
////	public void a() {
////		System.out.println("Thisara this");
////	}
//
//}
