import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BusinessFlow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector(".search-keyword")).sendKeys("Cuc");
		List<WebElement> items = driver.findElements(By.cssSelector(".product"));
		WebElement expectedItem = items.stream().filter(item -> item.findElement(By.cssSelector(".product-name")).getText().equalsIgnoreCase("Cucumber")).findFirst().orElse(null);
		expectedItem.findElement(By.tagName("button")).click();
		
	}

}
