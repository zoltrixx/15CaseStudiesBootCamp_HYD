import java.time.Duration;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SpiceJetTest {

    WebDriver driver;

    @Parameters("browser")
    @Test
    public void bookFlight(String browser) throws Exception {

        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("//div[text()='From']")).click();
        driver.findElement(By.xpath("//input[@autocapitalize='sentences']")).sendKeys("Delhi");
        driver.findElement(By.xpath("//div[contains(text(),'Delhi')]")).click();

        driver.findElement(By.xpath("//div[text()='To']")).click();
        driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[2]")).sendKeys("Mumbai");
        driver.findElement(By.xpath("//div[contains(text(),'Mumbai')]")).click();

        LocalDate date = LocalDate.now().plusDays(5);
        String day = String.valueOf(date.getDayOfMonth());

        driver.findElement(By.xpath("//div[text()='" + day + "']")).click();

        driver.findElement(By.xpath("//div[text()='Passengers']")).click();

        for(int i=1;i<5;i++) {
            driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        }

        driver.findElement(By.xpath("//div[text()='Done']")).click();

        driver.findElement(By.xpath("//div[text()='Search Flight']")).click();

        Thread.sleep(5000);

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src,new File("SearchPage.png"));

        driver.quit();
    }
}
