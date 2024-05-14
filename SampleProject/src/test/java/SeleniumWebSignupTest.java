import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**My Tests
 * 1. Verify that user input the correct url and is on the right page
 * 2. Verify that user cannot sign up with an invalid email address
 * 3. Verify that user cannot sign up with password less than or equal to one character
 * 4. Verify that user cannot sign up with any/all fields blank
 *
 */
public class SeleniumWebSignupTest {
    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void begin() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //Open your chrome browser
        driver = new ChromeDriver();
        //Input your Selenium Demo Page URL
        driver.get("https://selenium-blog.herokuapp.com/");
        //Test 1: Verify that user input the correct url and is on the right page
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //Pass
            System.out.println("Correct URL");
        else
            //Fail
            System.out.println("Wrong URL");
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().maximize();
        //Locate and click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    //Test 2: Verify that user cannot sign up with an invalid email address
    public void invalidEmail() throws InterruptedException {
        //Locate the username field and input a username
        driver.findElement(By.id("user_username")).sendKeys("MomohSample7");
        //Locate the email address field and input an email address
        driver.findElement(By.id("user_email")).sendKeys("momohsample7@mailinator");
        //Locate the password field and input a password
        driver.findElement(By.id("user_password")).sendKeys("momohSAMPLEpw1234");
        //Locate and click on the submit button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Locate and clear the username field
        driver.findElement(By.id("user_username")).clear();
        //Locate and clear the email address field
        driver.findElement(By.id("user_email")).clear();
        //Locate and clear the password field
        driver.findElement(By.id("user_password")).clear();
        Thread.sleep(5000);
    }
    @Test (priority = 1)
    //Test 3: Verify that user cannot sign up with password less than or equal to one character
    public void blankPassword() throws InterruptedException {
        //Locate the username field and input a username
        driver.findElement(By.id("user_username")).sendKeys("MomohSample7");
        //Locate the email address field and input an email address
        driver.findElement(By.id("user_email")).sendKeys("momohsample7@mailinator.com");
        //Locate and click on the submit button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Locate and clear the username field
        driver.findElement(By.id("user_username")).clear();
        //Locate and clear the email address field
        driver.findElement(By.id("user_email")).clear();
        Thread.sleep(5000);
    }
    @Test (priority = 2)
    //Test 4: Verify that user cannot sign up with any/all fields blank
    public void allBlankFields() throws InterruptedException {
        //Locate and click on the submit button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 3)
    //Test 5: Verify that user can sign up successfully with all valid data
    public void validData() throws InterruptedException {
        //Locate the username field and input a username
        driver.findElement(By.id("user_username")).sendKeys("MomohSample7");
        //Locate the email address field and input an email address
        driver.findElement(By.id("user_email")).sendKeys("momohsample7@mailinator.com");
        //Locate the password field and input a password
        driver.findElement(By.id("user_password")).sendKeys("momohSAMPLEpw1234");
        //Locate and click on the submit button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void clickItem() throws InterruptedException {
        //Locate and click on meaghan button
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 5)
    public void verifyItem() throws InterruptedException {
        //Locate and click on Using Python with Selenium button
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        Thread.sleep(3000);
        //Locate and click on the logout button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        Thread.sleep(3000);
    }
    @AfterTest
    public void end(){
        //Close WebDriver
        driver.quit();
    }
}
