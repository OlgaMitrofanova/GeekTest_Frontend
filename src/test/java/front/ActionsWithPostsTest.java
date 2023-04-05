package front;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ActionsWithPostsTest extends AbstractTest{
    @Test
    void openMyPage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        WebElement contact = driver.findElement(By.xpath("//ul[@class=\"svelte-1rc85o5\"]/li[3]"));
        contact.click();
        TimeUnit.SECONDS.sleep(2);
        WebElement profile = driver.findElement(By.xpath("//ul[@class=\"mdc-deprecated-list\"]/li[1]"));
        profile.click();
        TimeUnit.SECONDS.sleep(4);
        Assertions.assertNotNull(driver.findElement(By.xpath("//h1[contains(text(),'Profile Page')]")));
    }

    @Test
    void turnOffButtonPreviousPage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        WebElement disabledPreviousPage = driver.findElement(By.cssSelector(".svelte-d01pfs.disabled"));
        Assertions.assertNotNull(driver.findElement(By.cssSelector(".svelte-d01pfs.disabled")));
        Assertions.assertNotNull(driver.findElement(By.xpath("//a[@href='/?page=2']")));
    }

    @Test
    void goToLoginPage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        WebElement contact = driver.findElement(By.xpath("//ul[@class=\"svelte-1rc85o5\"]/li[3]"));
        contact.click();
        TimeUnit.SECONDS.sleep(2);
        WebElement profile = driver.findElement(By.xpath("//ul[@class=\"mdc-deprecated-list\"]/li[2]"));
        profile.click();
        Assertions.assertNotNull(driver.findElement(By.xpath("//form[@id='login']")));
        Assertions.assertNotNull(driver.findElement(By.cssSelector(".svelte-1rc85o5.selected")));
    }

    @Test
    void goToAboutPage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        WebElement about = driver.findElement(By.xpath("//ul[@class=\"svelte-1rc85o5\"]/li[1]"));
        about.click();
        TimeUnit.SECONDS.sleep(2);
        Assertions.assertNotNull(driver.findElement(By.xpath("//h1[contains(text(),'About Page')]")));
    }

    @Test
    void goToContactPage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        WebElement contact = driver.findElement(By.xpath("//ul[@class=\"svelte-1rc85o5\"]/li[2]"));
        contact.click();
        Assertions.assertNotNull(driver.findElement(By.xpath("//h1[contains(text(),'Contact us!')]")));
    }

    @Test
    void goToPageTwo() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        WebElement nextPage = driver.findElement(By.xpath("//a[contains(text(),'Next Page')]"));
        nextPage.click();
        TimeUnit.SECONDS.sleep(2);
        Assertions.assertNotNull(driver.findElement(By.xpath("//a[@href='/?page=1']")));
        Assertions.assertNotNull(driver.findElement(By.xpath("//a[@href='/?page=3']")));
    }

    @Test
    void logOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        WebElement contact = driver.findElement(By.xpath("//ul[@class=\"svelte-1rc85o5\"]/li[3]"));
        contact.click();
        TimeUnit.SECONDS.sleep(2);
        WebElement profile = driver.findElement(By.xpath("//ul[@class=\"mdc-deprecated-list\"]/li[2]"));
        profile.click();
        Assertions.assertNotNull(driver.findElement(By.xpath("//form[@id='login']")));
    }

    @Test
    void switchBoxNotMyPosts() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        WebElement switchBox = driver.findElement(By.xpath("//button[@id='SMUI-form-field-1']"));
        switchBox.click();
        TimeUnit.SECONDS.sleep(1);
        Assertions.assertNotNull(driver.findElement(By.xpath("//a[@href='/?page=2&owner=notMe']")));
    }

    @Test
    void turnOffButtonNextPage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        WebElement page2 = driver.findElement(By.xpath("//a[@href='/?page=2']"));
        page2.click();
        WebElement page3 = driver.findElement(By.xpath("//a[@href='/?page=3']"));
        page3.click();
        TimeUnit.SECONDS.sleep(3);
        Assertions.assertNotNull(driver.findElement(By.cssSelector(".svelte-d01pfs.disabled")));
    }

    @Test
    void transitionFromPostToHome() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        WebElement element = driver.findElement(By.xpath("//a[@href='/posts/15032']"));
        element.click();
        TimeUnit.SECONDS.sleep(2);
        WebElement home = driver.findElement(By.cssSelector(".logo.svelte-1rc85o5"));
        home.click();
        Assertions.assertNotNull(driver.findElement(By.cssSelector(".svelte-d01pfs.disabled")));
        Assertions.assertNotNull(driver.findElement(By.xpath("//a[@href='/?page=2']")));
    }

    @Test
    void checkPosts(){
        WebElement prevPosts = driver.findElement(By.cssSelector(".posts.svelte-127jg4t"));
        Assertions.assertNotNull(driver.findElement(By.xpath("//div[@class=\"posts svelte-127jg4t\"]/a[1]")));
    }

    @Test
    void checkCreatePost() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        WebElement create = driver.findElement(By.xpath("//button[@id='create-btn']"));
        TimeUnit.SECONDS.sleep(4);
        create.click();
        Assertions.assertNotNull(driver.findElement(By.xpath("//h1[contains(text(),'Create Post')]")));
    }

}
