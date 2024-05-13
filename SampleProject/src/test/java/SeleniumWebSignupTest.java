import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**My Tests
 * 1. Verify that user input the correct url and is on the right page
 * 2. Verify that user cannot signup with an invalid email address
 * 3. Verify that user cannot signup with password less than or equal to one character
 * 4. Verify that user cannot signup with any/all fields blank
 *
 */
public class SeleniumWebSignupTest {
    private WebDriver driver;

    @BeforeTest
    public void begin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com/");
        //Test 1: Verify that user input the correct url and is on the right page
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            System.out.println("Correct URL");
        else
            System.out.println("Wrong URL");

        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    //Test 2: Verify that user cannot signup with an invalid email address
    public void invalidEmail() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("MomohSample6");
        driver.findElement(By.id("user_email")).sendKeys("momohsample6@mailinator");
        driver.findElement(By.id("user_password")).sendKeys("momohSAMPLEpw1234");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("user_username")).clear();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_password")).clear();
        Thread.sleep(5000);
    }
    @Test (priority = 1)
    //Test 3: Verify that user cannot signup with password less than or equal to one character
    public void blankPassword() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("MomohSample6");
        driver.findElement(By.id("user_email")).sendKeys("momohsample6@mailinator.com");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("user_username")).clear();
        driver.findElement(By.id("user_email")).clear();
        Thread.sleep(5000);
    }
    @Test (priority = 2)
    //Test 4: Verify that user cannot signup with any/all fields blank
    public void allBlankFields() throws InterruptedException {
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 3)
    //Test 5: Verify that user can signup successfully with all valid data
    public void validData() throws InterruptedException {
        driver.findElement(By.id("user_username")).sendKeys("MomohSample6");
        driver.findElement(By.id("user_email")).sendKeys("momohsample6@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("momohSAMPLEpw1234");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void clickItem() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 5)
    public void verifyItem() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        Thread.sleep(3000);
    }
    @AfterTest
    public void end(){
        driver.quit();
    }
}
