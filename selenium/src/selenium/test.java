package selenium;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.google.com/search?q=%EC%9E%90%EB%8F%99%EC%B0%A8&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiH3IyaoY3qAhUC7WEKHeblDC8Q_AUoAXoECA0QAw&biw=1920&bih=925");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (true) {

			long height = (long) js.executeScript("return document.body.scrollHeight");
			System.out.println(height);
			js.executeScript("window.scroll(0, document.body.scrollHeight)");
			Thread.sleep(1000);
			long height2 = (long) js.executeScript("return document.body.scrollHeight");
			System.out.println(height2);
			if (height == height2)
				break;
		}
		List<WebElement> list = driver.findElements(By.cssSelector(".rg_i"));
		test t =  new test();
		
		for (int i = 0; i < list.size(); i++) {
			WebElement el =list.get(i);
			String src = el.getAttribute("src");
			System.out.println(src);
			t.DownloadImage(src, i);
		}
		}
	public void DownloadImage(String address, int i) {
		try {
			URL imageURL = new URL(address);
			BufferedImage saveimage = ImageIO.read(imageURL);
			ImageIO.write(saveimage, "jpg", new File(i +".jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
