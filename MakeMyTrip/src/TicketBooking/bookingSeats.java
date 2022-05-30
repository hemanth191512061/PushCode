package TicketBooking;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class bookingSeats {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\chinni\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver web = new ChromeDriver();

		web.manage().window().maximize();
		//web.get("https//www.makemytrip.com/flights/?gclid=CjwKCAjwydP5BRBREiwA-qrCGofceTL3-m17BabI9f5SqXKH3fr6i31TT-rSGUiNvd36fnMumRr6OBoCgWQQAvD_BwE&cmp=SEM|D|DF|G|Brand|B_M_Makemytrip_Search_Exact|Brand_Top_5_Exact|Expanded|162031058804&s_kwcid=AL!1631!3!162031058804!e!!g!!make%20my%20trip&ef_id=CjwKCAjwydP5BRBREiwA-qrCGofceTL3-m17BabI9f5SqXKH3fr6i31TT-rSGUiNvd36fnMumRr6OBoCgWQQAvD_BwE:G:s");
		web.get("https://www.redbus.in/");
		web.manage().window().maximize();
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		web.findElement(By.id("src")).sendKeys("hyd");
		Thread.sleep(5000);
		web.findElement(By.id("src")).sendKeys(Keys.ARROW_DOWN);
		web.findElement(By.id("src")).sendKeys(Keys.ENTER);
		WebElement To = web.findElement(By.id("dest"));
		To.sendKeys("del");
		Thread.sleep(5000);
		To.sendKeys(Keys.ARROW_DOWN);
		To.sendKeys(Keys.ENTER);
		String month = web.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		System.out.println(month);
		while (!month.contains("Sept 2020")) {
			Thread.sleep(5000);
			web.findElement(By.xpath("//button[contains(text(),'>')]")).click();
			month = web.findElement(By.xpath("//td[@class='monthTitle']")).getText();

		}
		List<WebElement> date = web.findElements(By.xpath("//td[@class='wd day']"));
		for (int i = 0; i < date.size(); i++) {

			if (date.get(i).getText().contains("25")) {
				+6335855
				date.get(i).click();
			}
		}

		web.findElement(By.id("search_btn")).click();
		Thread.sleep(3000);
		File src = ((TakesScreenshot) web).getScreenshotAs(OutputType.FILE);
File dest= new File(System.getProperty("user.dir")+"\\Screenshot.png");
		System.out.println(System.getProperty("user.dir"));
		 FileUtils.copyFile(src, dest);

	}

}
