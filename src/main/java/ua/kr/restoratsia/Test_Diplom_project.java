package ua.kr.restoratsia;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Diplom_project {
    public WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://restoratsia.kr.ua/");
        driver.manage().window().maximize();
    }
    @AfterEach
    public void quit() {
        driver.quit();
    }
    //Checking the language change on the site
    @Test
    public void switch_language() {
        WebElement iframe = driver.findElement(By.id("food"));
        driver.switchTo().frame(iframe);
        WebElement language = driver.findElement(By.xpath("//div[@class='header__language__toggler']/span[1]"));
        language.click();
    }
    // Login to your personal account
    @Test
    public void login() {
        WebElement iframe = driver.findElement(By.id("food"));
        driver.switchTo().frame(iframe);
        WebElement login = driver.findElement(By.xpath("//a[contains(text(),'Вхід')]"));
        login.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement phone =driver.findElement(By.xpath("//input[@id=\"phone\"]"));
        phone.sendKeys("0993605735");

        WebElement send_code = driver.findElement(By.xpath("//button[@id=\"sign-in-button\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('sign-in-button').setAttribute('color', '#00000')");

    }
    //Checking product categories
    @Test
    public void product_categories() {
        WebElement iframe = driver.findElement(By.id("food"));
        driver.switchTo().frame(iframe);
        WebElement product_categories = driver.findElement(By.xpath("//a[@data-target=\"bouli\"]"));
        product_categories.click();
    }
    //Shopping cart
    @Test
    public void Shopping_cart() {
        WebElement iframe = driver.findElement(By.id("food"));
        driver.switchTo().frame(iframe);
        WebElement cart = driver.findElement(By.xpath("//*[@data-attr_id=\"8566\"]/div[1]/div[3]/button"));
        cart.click();
    }
    //goods tooltip
    @Test
    public void goods_tooltip() {
        WebElement iframe = driver.findElement(By.id("food"));
        driver.switchTo().frame(iframe);
        WebElement goods = driver.findElement(By.cssSelector("#category__id-85 > div:nth-child(2) span.icon.show-modal"));
    }
    //go to the restaurant instagram page
    @Test
    public void instagram_page() {
        WebElement instagram = driver.findElement(By.xpath("//a[@href='https://www.instagram.com/rest_kropivnitskih/']"));
        instagram.click();

    }
    //go to the restaurant facebook page
    @Test
    public void facebook_page() {
        WebElement facebook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/RestoratsiiaKropyvnytskykh/']"));
       facebook.click();

    }
    //Checking the transition to reviews
    @Test
    public void checking_reviews() {
        WebElement iframe = driver.findElement(By.id("food"));
        driver.switchTo().frame(iframe);
        WebElement reviews = driver.findElement(By.xpath("//a[@href='#rating-section']"));
        reviews.click();
    }
    //Checking the ability to scroll through the carousel
    @Test
    public void product_scroll_carousel() {
        WebElement iframe = driver.findElement(By.id("food"));
        driver.switchTo().frame(iframe);
        WebElement carousel = driver.findElement(By.xpath("//button[@id='next']"));
        carousel.click();
    }
    //Checking the button "Show more"
    @Test
        public void button_Show_more() {
        WebElement iframe = driver.findElement(By.id("food"));
        driver.switchTo().frame(iframe);
        WebElement show_more = driver.findElement(By.xpath("//*[@id=\"maso\"]/div[3]/button"));
        show_more.click();

    }
    //Checking the "Delivery" button
    @Test
    public void delivery () {
        WebElement delivery = driver.findElement(By.xpath("//a[@href=\"https://restoratsia.kr.ua\"]"));
        delivery.click();
    }
    //Checking the transition to the "Main" button
    @Test
    public void main () {
        WebElement main = driver.findElement(By.xpath("//a[@href=\"https://restoratsia.kr.ua/head#banner\"]"));
        main.click();
    }
    //Checking the transition to the "About establishment" button
    @Test
    public void about_establishment() {
        WebElement about_establishment = driver.findElement(By.xpath("//a[@href=\"https://restoratsia.kr.ua/head#about\"]"));
        about_establishment.click();
    }
    //checking the transition to the "App" button
    @Test
    public void app () {
        WebElement app = driver.findElement(By.xpath("//a[@href=\"https://restoratsia.kr.ua/head#delivery\"]"));
        app.click();
    }
    //Checking the transition to the "Contacts" button
    @Test
    public void contacts () {
        WebElement contacts = driver.findElement(By.xpath("//a[@href=\"https://restoratsia.kr.ua/head#contacts\"]"));
        contacts.click();
    }
}