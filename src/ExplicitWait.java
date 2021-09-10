import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	//	implicit wait //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//explicit wait
		WebDriverWait w=new WebDriverWait(driver, 5);
		
		String[] products = { "Cucumber", "Brocolli","Beetroot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
	addItems(driver,products);	
	
	driver.findElement(By.xpath("//img[@alt='Cart']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	//explicit wait
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
	driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
	driver.findElement(By.cssSelector(".promoBtn")).click();
	
	//explicit wait
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
	System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
}

public static void addItems(WebDriver driver, String[] products)
{
List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));

for (int i = 0; i < items.size(); i++) {
// format the name to get actual vegetable name
// name[0]-Brocolli
String[] name = items.get(i).getText().split("-");
String formatname = name[0].trim();

// check if name extracted is present in array or not
List productlist = Arrays.asList(products);

int j = 0;
if (productlist.contains(formatname)) {
j++;
// click on add cart
driver.findElements(By.cssSelector("div.product-action")).get(i).click();
if (j == 3)
	break;
 
}

}

	}

}
