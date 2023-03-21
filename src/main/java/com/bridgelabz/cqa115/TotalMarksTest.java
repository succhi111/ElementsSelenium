package com.bridgelabz.cqa115;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalMarksTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suche\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("C:\\Users\\suche\\IdeaProjects\\ElementsSelenium\\src\\main\\resources\\Tables.html");
        Thread.sleep(2000);

        int total = Integer.parseInt(driver.findElement(By.xpath("//tbody/tr[7]/td[3]")).getText());

        int actualTotal = 0;
        for (int i = 2; i <= 6; i++) {
            String xpath = "//tbody/tr[" + i + "]/td[3]";
            actualTotal = actualTotal + Integer.parseInt(driver.findElement(By.xpath(xpath)).getText());

        }
        if (total == actualTotal) {
            System.out.println("Total sum  is correct");
        } else {
            System.out.println("Total sum coming as " + actualTotal);
            System.out.println("Total sum is incorrect...it is not matching with total row value...");

            Thread.sleep(2000);
            driver.close();
        }
    }
}
