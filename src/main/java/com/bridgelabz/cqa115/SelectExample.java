package com.bridgelabz.cqa115;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectExample {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suche\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("C:\\Users\\suche\\IdeaProjects\\ElementsSelenium\\src\\main\\resources\\Select.html");
        Thread.sleep(2000);

        WebElement list = driver.findElement(By.id("mtr"));

        Select s = new Select(list);

        List<WebElement> options = s.getOptions();
        int size = ((List<?>) options).size();
        System.out.println("Number of elements present inside the listbox is : "+ size);

        for (WebElement webElement : options) {
            String text = webElement.getText();
            System.out.println(text);
        }
        System.out.println("Element present in 3rd index is");
                s.selectByIndex(3);

        System.out.println("Element with value I is ");
        s.selectByValue("i");

        s.selectByVisibleText("Dosa");

        System.out.println("Print all selected options Above");
        List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
        int size2 = allSelectedOptions.size();

        System.out.println("Number of items that is selected in the list box is : "+size2);
        System.out.println(" Selected items are printed below ");
        for (WebElement webElement : allSelectedOptions) {
            System.out.println(webElement.getText());
        }
        System.out.println("check whether it is a multiple select listbox or not");
        boolean multiple = s.isMultiple();

        System.out.println(multiple +" yes , it is multi select");
        if (multiple) {

            WebElement firstSelectedOption = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption.getText()+" is the first selected item in the list box");

            s.deselectByIndex(0);

            WebElement firstSelectedOption1 = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption1.getText()+" is the first selected item");

            System.out.println("Deselecting value with v");
            s.deselectByValue("v");

            WebElement firstSelectedOption2 = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption2.getText()+" is the first selected item");
            s.deselectByVisibleText("Dosa");

        }
    }
}

