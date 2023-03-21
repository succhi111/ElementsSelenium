package com.bridgelabz.cqa115;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesExample {
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\suche\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("C:\\Users\\suche\\IdeaProjects\\ElementsSelenium\\src\\main\\resources\\Tables.html");
            Thread.sleep(2000);
            List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
            int totalRows = allRows.size();
            System.out.println("total number of rows present in the table is :"+ totalRows);

            List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
            int totalColumns = allColumns.size();
            System.out.println("Total number of columns in the table is :" + totalColumns);

            List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
            int totalCells = allCells.size();
            System.out.println("Total number of cells present in the table is :" + totalCells);

            int countNumberValue = 0;
            int sum=0;
            for (WebElement cell : allCells) {
                String cellValue = cell.getText();
                try{
                    int number = Integer.parseInt(cellValue);
                    countNumberValue++;
                    sum = sum+number;
                }catch (Exception e) {
                }
            }
            System.out.println("Total count of numeric values is :"+countNumberValue);
            System.out.println("Total sum of all the numeric values is :"+sum);

            driver.close();
        }
    }


