import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginToWebapp {

	private static final String[] dateStr = {  "Mar 17 2021", "Mar 18 2021"}; // provide separate values

	private static WebDriver chromeDriver;
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";

	enum Days {
		Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
	}

	private WebDriver getChromeDriver() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\JARS\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		// chromeDriver.wait(15);
		return chromeDriver;
	}

	public static boolean isProcessRunning(String serviceName) throws Exception {

		Process p = Runtime.getRuntime().exec(TASKLIST);
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {

			System.out.println(line);
			if (line.contains(serviceName)) {
				return true;
			}
		}

		return false;

	}

	public static void killProcess(String serviceName) throws Exception {

		Runtime.getRuntime().exec(KILL + serviceName);

	}

	public static int getDayNumberOld(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		LoginToWebapp token = new LoginToWebapp();
		String processName = "chromedriver.exe";
		Days day = null;
		Days[] daysArray = Days.values();
		// Date todaysDate = new Date();

		// kill chrome drivers
		if (isProcessRunning(processName)) {
			System.out.println("killing all chrome instances");
			killProcess(processName);
		} else {
			System.out.println("Driver instances found: 0");
		}

		try {
			// Robot robot = new Robot();
			chromeDriver = token.getChromeDriver();
			WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
			;

			// load SPINE HR
			chromeDriver.get("https://selfservicehr.vyom-labs.com/spinehrms/login.aspx");

			// Enter Username
			WebElement usernameTextBox = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='txtUser']")));
			usernameTextBox.sendKeys("ae0210");

			// Enter Password
			WebElement passwordTextBox = chromeDriver.findElement(By.xpath("//input[@name='txtPassword']"));
			passwordTextBox.sendKeys("16worlds*");

			// Click on Login btn
			chromeDriver.findElement(By.xpath("//input[@name='btnLogin']")).click();

			// Wait till time tab appears and click
			WebElement timeTab = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"MenuContent\"]/ul/li[4]/a")));
			timeTab.click();

			// Click on Apply beneath SWIPE option
			chromeDriver.findElement(By.xpath("//*[@id=\"MenuContent\"]/ul/li[4]/ul/li[4]/ul/a")).click();

			// click on Add New btn
			for (int i = 0; i < dateStr.length; i++) {
				Date todaysDate = new Date(dateStr[i]);
				int dayNoInWeek = getDayNumberOld(todaysDate);
				String dateXpath;
				SimpleDateFormat format = new SimpleDateFormat("MMMMM dd, yyyy");
				for (int j = 0; j < dayNoInWeek; j++) {
					day = daysArray[j];
					System.out.println(todaysDate + " : " + day);
				}
				// System.out.print(isProcessRunning(processName));
				String dateString = day + ", " + format.format(todaysDate);
				dateXpath = "//div[@title='" + dateString + "']";
				WebElement addNew = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[@id=\"ctl00_BodyContentPlaceHolder_Menu1\"]/ul/li[1]/a")));
				addNew.click();

				// Select Work from Home option in category
				WebElement category = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[@id=\"ctl00_BodyContentPlaceHolder_drpSwipeCategory\"]")));

				Select selectCategory = new Select(category);
				selectCategory.selectByVisibleText("Work From Home");

				Thread.sleep(2000);

				// select todays date from calendar
				WebElement calendar = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[@id=\"ctl00_BodyContentPlaceHolder_imagebtn1\"]")));
				calendar.click();
				Thread.sleep(2000);
				WebElement date = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dateXpath)));
				Thread.sleep(1000);
				date.click();

				// Select mode as Both
				WebElement dropdownMode = chromeDriver
						.findElement(By.xpath("//*[@id=\"ctl00_BodyContentPlaceHolder_dpInout\"]"));
				Select mode = new Select(dropdownMode);
				mode.selectByVisibleText("Both");
				Thread.sleep(2000);
				// Set reason for swipe
				chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_BodyContentPlaceHolder_txtReason\"]"))
						.sendKeys("Work from home. COVID19 constraints.");
				Thread.sleep(2700);
				// Scroll to save btn and click
				WebElement saveBtn = chromeDriver
						.findElement(By.xpath("//*[@id=\"ctl00_BodyContentPlaceHolder_btnSave\"]"));
				JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
				js.executeScript("window.scrollBy(0,1000)");
				saveBtn.click();
				Thread.sleep(5000);
			}

		} finally {
			// sign out and close browser
			chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_empphoto\"]")).click();
			chromeDriver.findElement(By.xpath("//*[@id=\"divTop\"]/div/ul[2]/li[2]/ul/li[5]/div/ul/li/div[1]/div[3]/div[3]/a")).click();

			chromeDriver.close();

		}
	}

}
