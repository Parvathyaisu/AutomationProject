package basepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass {
	public static WebDriver driver;

	@BeforeClass
			 public void setup()
			  {
			     driver=new ChromeDriver();
			     driver.get("https://www.fablestreet.com/");
			     driver.manage().window().maximize();
			     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			  }
}
