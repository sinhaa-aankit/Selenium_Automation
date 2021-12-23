package selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MilestoneAssessment {
public static void main(String[] args) throws InterruptedException {
		
		String chromeDriverLocation = "C:\\Users\\SNiP3R\\Downloads\\chromedriver_win32_1\\chromedriver.exe";
		String chromeDriverKey = "webdriver.chrome.driver";
		System.setProperty(chromeDriverKey, chromeDriverLocation);
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		Actions actions = new Actions(chromeDriver);
		
		
		step1(chromeDriver, actions);
		
		chromeDriver.navigate().back();
		
		step2(chromeDriver);
		
		chromeDriver.navigate().back();
		
		step3(chromeDriver);
		
		chromeDriver.navigate().back();
		
		step4(chromeDriver);
		
		chromeDriver.navigate().back();
		
		step5(chromeDriver);
		
		chromeDriver.navigate().back();
		chromeDriver.navigate().back();
		
		step6(chromeDriver);
		
		chromeDriver.navigate().back();
		
		step7(chromeDriver);
		
		chromeDriver.navigate().back();
		
		step8(chromeDriver);
		
		chromeDriver.navigate().back();
		
		step9(chromeDriver, actions);
		
		chromeDriver.quit();
		
		System.out.println("Test Successfull");
		
	}
	
	private static void step9(WebDriver chromeDriver, Actions actions) {
		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[7]/a")).click();
		
		WebElement hotspot = chromeDriver.findElement(By.id("hot-spot"));
		actions.contextClick(hotspot).perform();
	
	}

	private static void step8(WebDriver chromeDriver) {
		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[33]/a")).click();
		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		
		Set<String> ids = chromeDriver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentPage = it.next();
		String childPage = it.next();
		chromeDriver.switchTo().window(childPage);
		
		String childPageText = chromeDriver.findElement(By.xpath("/html/body/div/h3")).getText();
		System.out.println("Child Page Text: " + childPageText);
		
		chromeDriver.switchTo().window(parentPage);
	
}

	private static void step7(WebDriver chromeDriver) {
		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[31]/a")).click();

		WebElement element = chromeDriver.findElement(By.xpath("//*[@id=\"result\"]"));
		
		chromeDriver.findElement(By.id("target")).click();
		chromeDriver.findElement(By.id("target")).sendKeys(Keys.SHIFT);

		String keyPressed = element.getText();
		System.out.println(keyPressed);
	
	}

	private static void step6(WebDriver chromeDriver) {
		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[41]/a")).click();
		int i = 1;
		String nameXpath = "//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[2]";
		
		while(chromeDriver.findElements(By.xpath(nameXpath)).size() > 0) {
			String name = chromeDriver.findElement(By.xpath(nameXpath)).getText();
			if(name.equalsIgnoreCase("Tim")) {
				String emailXpath = "//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[3]";
				String webSiteXpath = "//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[5]";
				String email = chromeDriver.findElement(By.xpath(emailXpath)).getText();
				String webSite = chromeDriver.findElement(By.xpath(webSiteXpath)).getText();
				System.out.println("Email: "+ email + ", Website: " + webSite);
				break;
			}
			i++;
			nameXpath = "//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[2]";
		}
	
	}

	private static void step5(WebDriver chromeDriver) throws InterruptedException {
		Thread.sleep(1000);
		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[18]/a")).click();
		chromeDriver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\SNiP3R\\Desktop\\NewTextDocument.txt");
		chromeDriver.findElement(By.id("file-submit")).click();
	
	}

	private static void step4(WebDriver chromeDriver) {
		
		
		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")).click();
		
		chromeDriver.findElement(By.id("dropdown")).click();
		chromeDriver.findElement(By.id("dropdown")).sendKeys(Keys.DOWN);
		chromeDriver.findElement(By.id("dropdown")).sendKeys(Keys.DOWN);
		chromeDriver.findElement(By.id("dropdown")).sendKeys(Keys.ENTER);
		
	
	}

	private static void step3(WebDriver chromeDriver) {
		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[27]/a")).click();

		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys("1001");
		
		
	
	}

	private static void step2(WebDriver chromeDriver) throws InterruptedException {
		
		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();
		List<WebElement> choose = chromeDriver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=0; i<choose.size(); i++) {
			if(choose.get(i).isSelected() == true) {
				choose.get(i).click();
			}
		}
		Thread.sleep(2000);
		for(int i=0; i<choose.size(); i++) {
				choose.get(i).click();
		}
	}

	// Step 1
	private static void step1( WebDriver chromeDriver, Actions actions ) {
		chromeDriver.get("http://the-internet.herokuapp.com");
		chromeDriver.manage().timeouts();
		chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[25]/a")).click();
		WebElement firstImage = chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
		actions.moveToElement(firstImage).click().perform();
		String firstImageText =  chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText();
		System.out.println("User's Name: " + firstImageText.substring(6));
		
	}

}
