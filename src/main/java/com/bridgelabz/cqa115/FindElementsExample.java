package com.bridgelabz.cqa115;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsExample {
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\suche\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://www.facebook.com/");
            Thread.sleep(2000);

            List<WebElement> totalLinks = driver.findElements(By.tagName("a"));

            int visibleLinkCount=0 ,hiddenLinkCount=0;

            for (WebElement link : totalLinks) {

                if (link.isDisplayed()) {
                    visibleLinkCount++;
                    System.out.println("visible Link" +link);
                }else{
                    hiddenLinkCount++;
                }
            }
            System.out.println("Total number of visible links :" + visibleLinkCount);
            System.out.println("Total number of hidden links :" + hiddenLinkCount);
           Thread.sleep(5000);

            driver.close();
        }
}

