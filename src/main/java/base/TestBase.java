package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static int WAIT_TIME = 20;
	
	public TestBase() throws IOException {
		
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		prop= new Properties();
		prop.load(fin);
	}

	public static void initialize() {
		
		if(prop.getProperty("browser").equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(prop.getProperty("browser").equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(prop.getProperty("browser").equals("ie")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WAIT_TIME,TimeUnit.SECONDS);
		
	}
}