package domaci24;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

/*  Napisati program koji na sajtu:
    http://automationpractice.com
    1. dodaje najmanje 3 proizvoda u cart,
    2. nastavlja do cart-a,
    3. izbacuje jedan proizvod, a drugom povecava kolicinu za 1.

    Sajt je malo usporen i bagovit, pa stavljajte malo vece wait-ere

*/
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)", "");



        WebElement product1 = driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]/div/div[2]/div[1]"));
        product1.click();
        Actions hover = new Actions(driver);
        hover.moveToElement(product1);

        WebElement addCart1 = driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span"));
        addCart1.click();
        WebElement continueShopping = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"));
        continueShopping.click();


        WebElement product2 = driver.findElement(By.xpath("//*[@id='homefeatured']/li[5]/div/div[2]/div[1]/span[1]"));
        product2.click();
        Actions hover2 = new Actions(driver);
        hover.moveToElement(product2);

        WebElement addCart2 = driver.findElement(By.xpath("//*[@id='homefeatured']/li[5]/div/div[2]"));
        addCart2.click();
        WebElement continueShopping2 = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"));
        continueShopping.click();


        WebElement product3 = driver.findElement(By.xpath("//*[@id='homefeatured']/li[3]/div/div[2]/div[1]"));
        product3.click();
        Actions hover3 = new Actions(driver);
        hover.moveToElement(product3);

        WebElement addCart3 = driver.findElement(By.xpath("//*[@id='homefeatured']/li[3]/div/div[2]/div[2]/a[1]"));
        addCart3.click();
        WebElement proceed = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a"));
        proceed.click();




        WebElement minus = driver.findElement(By.xpath("//*[@id='cart_quantity_down_5_19_0_0']"));
        minus.click();

        WebElement plus = driver.findElement(By.xpath("//*[@id='cart_quantity_up_1_1_0_0']"));
        plus.click();

        WebElement proceed2 = driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]"));
        proceed2.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}
