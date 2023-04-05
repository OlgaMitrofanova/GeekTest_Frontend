package front;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AuthTest {

    static FirefoxDriver driver;
    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String username;
    private static String password;
    private static String base_url;
    private static String token;
    private static String notValidPass;
    private static String notValidUser;
    private  static Long time = 5l;

    @BeforeEach
    void init() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.get("https://test-stand.gb.ru/login");

        configFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configFile);

        username = prop.getProperty("username");
        password = prop.getProperty("password");
        base_url = prop.getProperty("base_url");
        token = prop.getProperty("token");
        notValidPass = prop.getProperty("notValidPassword");
        notValidUser = prop.getProperty("notValidUser");
    }
    public static String getUsername() {
        return username;
    }

    public static String getPassword(){
        return password;
    }

    public static String getBase_url(){
        return base_url;
    }
    public static String getToken(){
        return token;
    }
    public static String getNotValidPass(){
        return notValidPass;
    }
    public static String getNotValidUser(){
        return notValidUser;
    }

    @AfterEach
    void close(){
        driver.quit();
    }

// Successful logIn
    @Test
    void logIn(){
    WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
    userName.sendKeys(getUsername());
    WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
    password.sendKeys(getPassword());
    WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
    button.click();

    Assertions.assertNotNull(driver.findElement(By.cssSelector(".content")));
}

    // Invalid logIn
    @Test
    void invalidUserName(){
    WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
    userName.sendKeys(getNotValidUser());
    WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
    password.sendKeys(getPassword());
    WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
    button.click();

    Assertions.assertNotNull(driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]")));
}

    // Short login
@Test
void invalidShortLogin2(){
    WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
    userName.sendKeys("Ab");
    WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
    password.sendKeys("abc1234");
    WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
    button.click();

    Assertions.assertNotNull(driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]")));
}

    @Test
    void invalidShortLogin3(){
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Abc");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("kjkjkj1234");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        Assertions.assertNotNull(driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]")));
    }

    @Test
    void invalidShortLogin4(){
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("kJks");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("kjkjkj1234");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        Assertions.assertNotNull(driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]")));
    }

    @Test
    void invalidLongLogin19(){
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("klklklklklklklklklk");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("kjkjkj1234");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        Assertions.assertNotNull(driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]")));
    }

    @Test
    void invalidLongLogin20(){
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("sgsgsgsgsgsghghghghgh");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("kjkjkj1234");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        Assertions.assertNotNull(driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]")));
    }

    @Test
    void invalidLongLogin21(){
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("jfkjkjdhdhdhdhdhdhdhd");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("kjkjkj1234");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        Assertions.assertNotNull(driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]")));
    }

}
