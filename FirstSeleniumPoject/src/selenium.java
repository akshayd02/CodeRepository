import java.util.Set; 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.Keys; 
import org.openqa.selenium.Point; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.interactions.Actions; 

public class selenium { public static void main(String[] args) throws Exception 
{ 
System.setProperty("webdriver.chrome.driver", "D:\\JARS\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe"); 
WebDriver driver = new ChromeDriver(); 
driver.get("https://www.naukri.com/"); 
String title = driver.getTitle(); System.out.println(title);
JavascriptExecutor js = (JavascriptExecutor) driver;
/*
 * JavascriptExecutor js = (JavascriptExecutor) driver;
 * driver.findElement(By.xpath("//span[contains(text(),'Solutions')]")).click();
 * driver.findElement(By.xpath("//a[contains(text(),'Geolocation Testing')]")).
 * click(); js.executeScript("window.scrollBy(0,40)");
 * 
 * WebElement link = driver.findElement(By.xpath(
 * "//a[@id='product-menu-toggle']//span[@class='account-down-caret']//*[local-name()='svg']"
 * )); Actions newwin = new Actions(driver);
 * newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
 * //Thread.sleep(2000); //js.executeScript("window.scrollBy(0,400)");
 */
Thread.sleep(3000); 
Set<String> windows = driver.getWindowHandles(); 
System.out.println(windows); 
System.out.println("a1"); 
for (String window : windows) 
{ 
driver.switchTo().window(window); 
 System.out.println(driver.getTitle());
} 
Thread.sleep(3000); 
 
} 
}