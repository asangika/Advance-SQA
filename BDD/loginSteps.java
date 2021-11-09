package stepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	
	WebDriver driver;
	
	@Given("User in Login page")
	public void user_on_login_page() {
		System.out.println("User in Login page");
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.navigate().to("http://automationpractice.com/index.php?");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
	}
	
	@And("User click sign In")
	public void user_click_SignIn() {
		System.out.println("User click sign in button");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.className("login")).click();
	}
	
	@When("User enters email and password")
	public void user_enter_credentials() {
		System.out.println("User enter login credentials");
		
		driver.findElement(By.id("email")).sendKeys("asangikasandamini@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("A1234");
	}
	
	@And("User click sign In button")
	public void user_click_login_button() {
		System.out.println("User click sign in button");
		
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	@Then("Successfully navigate to the dashboard")
	public void user_navigate_successfully() {
		System.out.println("Navigated successfully");
	}
	
	@Given("User is already logged in")
	public void user_already_logged_in() {
		System.out.println("User logged in");
	}
	
	@And("User naviagate to woman section")
	public void user_navigate_to_women_section() {
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?id_category=3&controller=category']")).click();
	}
	
	@When("user add items to cart")
	public void user_add_item() {
		Actions actions = new Actions(driver);
		WebElement card1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div")); 
		actions.moveToElement(card1).perform();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]")));
		WebElement addToCartButton1 = driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]")); 
		addToCartButton1.click();
		WebElement backToWomen = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")); 
		backToWomen.click();

		WebElement card2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")); 
		actions.moveToElement(card2).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line hovered']//span[contains(text(),'Add to cart')]")));
		WebElement addToCartButton2 = driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line hovered']//span[contains(text(),'Add to cart')]")); 
		addToCartButton2.click();

		backToWomen.click();
//		WebElement continueShopping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")); 
//		continueShopping.click();

		System.out.println("sucessfulyy added items to cart");
	}
	
	@Then("User navigate to cart")
	public void navigate_to_cart() {
		WebElement shoppingCart = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
		shoppingCart.click();
		System.out.println("sucessfully navigated to the cart");
	}
	
	@Then("User successfully checkout")
	public void user_checkout_from_application() {
//		WebElement quantity = driver.findElement(By.xpath("//*[@id=\"cart_quantity_up_1_1_0_580192\"]"));
//		quantity.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement proceedToPay = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]"));
		proceedToPay.click();
		WebElement textArea = driver.findElement(By.xpath("//*[@id=\"ordermsg\"]/textarea"));
		textArea.sendKeys("Can I change after delivery?");
		WebElement proceedToPay2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button"));
		proceedToPay2.click();
		WebElement termConditions = driver.findElement(By.xpath("//*[@id=\"form\"]/div/p[2]/a"));
		termConditions.click();
		WebElement crossButton = driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a"));
		crossButton.click();
		WebElement cgv = driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
		cgv.click();
		WebElement proceedToPay3 = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button"));
		proceedToPay3.click();
		WebElement selectPaymentMethod = driver.findElement(By.className("bankwire"));
		selectPaymentMethod.click();
		WebElement confirmOrder = driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]"));
		confirmOrder.click();
	}
}
