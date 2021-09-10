import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> items=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<items.size();i++)
		{
			String name=items.get(i).getText();
			if(name.contains("Cucumber"))
			{//click on add cart
				driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
				break;
			}
		}
	}

}
