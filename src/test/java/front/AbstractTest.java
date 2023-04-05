package front;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
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
        options.addArguments("--headless");
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        driver.get("https://test-stand.gb.ru/login");

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        configFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configFile);

        username = prop.getProperty("username");
        password = prop.getProperty("password");
        base_url = prop.getProperty("base_url");
        token = prop.getProperty("token");
        notValidPass = prop.getProperty("notValidPass");
        notValidUser = prop.getProperty("notValidUser");


            WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
            userName.sendKeys(getUsername());

            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            password.sendKeys(getPassword());

            WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
            button.click();


            Assertions.assertNotNull(driver.findElement(By.cssSelector(".content")));

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

}
