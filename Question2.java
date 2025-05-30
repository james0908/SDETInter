package SDET;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Question2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String actualTitle = driver.getTitle();
        String ExpectedTitle = "https://www.makemytrip.com/";

        driver.findElement(By.cssSelector("span[data-cy='closeModal']")).click();

        //Selecting From City
        driver.findElement(By.id("fromCity")).click();
        driver.findElement(By.cssSelector("input[placeholder='From']")).sendKeys("HYD");
        driver.findElement(By.cssSelector("p[class*='searchedResult']")).click();

        //Selecting To city
        driver.findElement(By.id("toCity")).click();
        driver.findElement(By.cssSelector("input[placeholder='To']")).sendKeys("MAA");
        driver.findElement(By.xpath("//div[text()='MAA']")).click();

        //Select from date
        driver.findElement(By.cssSelector("div[class*='DayPicker-Day'][aria-disabled='false']")).click();

        //Select return date
        driver.findElement(By.cssSelector("p[data-cy='returnDefaultText']")).click();
        driver.findElement(By.cssSelector("div[class*='DayPicker-Day'][aria-disabled='false'][aria-selected='false']")).click();

        driver.findElement(By.linkText("SEARCH")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();

        String searchResultText = driver.findElement(By.cssSelector("div[class='listingRhs']>p>span")).getText();
        String expectedText = "Flights from Hyderabad to Chennai, and back";

        if (searchResultText.equals(expectedText)) {
            System.out.println("Flight search is successful");
        } else {
            System.out.println("Flight Search failed");
        }
        driver.close();

    }

    }




