package seliniumproject2;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;


public class Letscode {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://letcode.in/frame");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement myframe=driver.findElement(By.xpath("//iframe[@id='firstFr']"));
		driver.switchTo().frame(myframe);
		driver.findElement(By.name("fname")).sendKeys("Nancy");
		driver.findElement(By.name("lname")).sendKeys("Leema");
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("/html/body/app-root/app-innerframe/div/div/div/div/div/input")).sendKeys("nancyleema.k0911@gmail.com");
		File firstSrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("./snap/img.png");
		FileHandler.copy(firstSrc, dest);	
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Watch tutorial')]\r\n"+ "")).click();
		
		// TODO Auto-generated method stub

	}

}
