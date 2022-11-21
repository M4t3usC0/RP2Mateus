package test;

import com.google.gson.JsonObject;
import org.openqa.selenium.JavascriptExecutor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestTopicosCustom {

    private static JSONObject jsonObject;
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() throws FileNotFoundException, IOException, ParseException {

        jsonObject = (JSONObject) new JSONParser().parse(
                new FileReader("C:\\Users\\User\\Documents\\test\\projetorp2\\src\\test\\java\\test\\arquivo.json"));
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        // driver.quick();

    }

    @Test
    public void testeDeArquivo() throws InterruptedException {
        driver.get(jsonObject.get("url").toString());
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.findElement(By.linkText("Acessar")).click();
        driver.findElement(By.id("username")).sendKeys(jsonObject.get("username").toString());
        driver.findElement(By.id("password")).sendKeys(jsonObject.get("password").toString());
        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.className("custom-control-input")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("a[href='https://gmlunardi.pro.br/moodlerp2/my/courses.php']")).click();
        Thread.sleep(4000);
        driver.findElement(By.className("multiline")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("action-menu-toggle-1")).findElement(By.className("icon")).click();
        Thread.sleep(2000);
        driver.findElement(
                By.cssSelector("a[href='https://gmlunardi.pro.br/moodlerp2/course/editsection.php?id=23&sr=0']"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.id("id_name_customize")).click();
        Thread.sleep(4000);
        driver.findElement(By.className("fdefaultcustom")).findElement(By.className("form-control"))
                .sendKeys(jsonObject.get("topc1").toString());
        Thread.sleep(2000);
        driver.findElement(By.className("editor_atto_content")).sendKeys(jsonObject.get("texto1").toString());
        Thread.sleep(2000);
        driver.findElement(By.id("collapseElement-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("submitbutton")).click();
        Thread.sleep(2000);

        assertEquals(driver.findElement(By.id("section-0")).findElement(By.className("course-section-header")).findElement(By.tagName("h3")).getText(),jsonObject.get("topc1").toString());
        // driver.findElement(By.className("availability-button")).click();
        // Thread.sleep(4000);
        /*
         * driver.findElement(By.className("col-6")).click();
         * Thread.sleep(2000);
         * WebElement conteudo = driver.findElement(By.name("cm"));
         * conteudo.findElement(By.xpath("//option[. = 'Conteúdo das aulas']")).click();
         * WebElement conteudo2 = driver.findElement(By.name("e"));
         * conteudo2.findElement(By.
         * xpath("//option[. = 'não deve ser marcada como concluída']")).click();
         * driver.findElement(By.id("id_submitbutton")).click();
         * Thread.sleep(2000);
         * 
         * driver.findElement(By.className("activity-add-text")).click();
         * Thread.sleep(4000);
         * driver.findElement(By.cssSelector(
         * "a[href='https://gmlunardi.pro.br/moodlerp2/course/mod.php?id=6&add=choice&section=0&sr=0']"
         * )).click();
         */
        // asssetEquals("", jsonObject.get("topc1").toString());

    }

    @Test

    public void teste2() throws InterruptedException {
        driver.get(jsonObject.get("url").toString());
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.findElement(By.linkText("Acessar")).click();
        driver.findElement(By.id("username")).sendKeys(jsonObject.get("username").toString());
        driver.findElement(By.id("password")).sendKeys(jsonObject.get("password").toString());
        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.className("custom-control-input")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("a[href='https://gmlunardi.pro.br/moodlerp2/my/courses.php']")).click();
        Thread.sleep(4000);
        driver.findElement(By.className("multiline")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("action-menu-toggle-5")).findElement(By.className("icon")).click();
        Thread.sleep(2000);
        driver.findElement(
                By.cssSelector("a[href='https://gmlunardi.pro.br/moodlerp2/course/editsection.php?id=25&sr=0']"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.id("id_name_customize")).click();
        Thread.sleep(4000);
        driver.findElement(By.className("fdefaultcustom")).findElement(By.className("form-control"))
                .sendKeys(jsonObject.get("topc2").toString());
        Thread.sleep(2000);
        driver.findElement(By.className("editor_atto_content")).sendKeys(jsonObject.get("texto2").toString());
        Thread.sleep(2000);
        driver.findElement(By.id("collapseElement-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("submitbutton")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("section-2")).findElement(By.className("add-sections")).click();
            Thread.sleep(2000);

            assertEquals(driver.findElement(By.id("section-2")).findElement(By.className("course-section-header")).findElement(By.tagName("h3")).getText(),jsonObject.get("topc2").toString());     
            
    }

    @Test

        public void teste3() throws InterruptedException {
            driver.get(jsonObject.get("url").toString());
            driver.manage().window().setSize(new Dimension(1440, 900));
            driver.findElement(By.linkText("Acessar")).click();
            driver.findElement(By.id("username")).sendKeys(jsonObject.get("username").toString());
            driver.findElement(By.id("password")).sendKeys(jsonObject.get("password").toString());
            driver.findElement(By.id("loginbtn")).click();
            driver.findElement(By.className("custom-control-input")).click();
            Thread.sleep(4000);
            driver.findElement(By.cssSelector("a[href='https://gmlunardi.pro.br/moodlerp2/my/courses.php']")).click();
            Thread.sleep(4000);
            driver.findElement(By.className("multiline")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("section-3")).findElement(By.className("quickeditlink")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("section-3")).findElement(By.className("form-control")).sendKeys(jsonObject.get("topc3").toString());
            Thread.sleep(2000);
            driver.findElement(By.id("section-3")).findElement(By.className("form-control")).sendKeys(Keys.ENTER);    
            driver.findElement(By.id("section-3")).findElement(By.className("activity-add-text")).click();
            Thread.sleep(4000);
            driver.findElement(By.cssSelector("a[href='https://gmlunardi.pro.br/moodlerp2/course/mod.php?id=6&add=data&section=3&sr=0']")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("id_name")).sendKeys(jsonObject.get("bd1").toString());
            Thread.sleep(2000);
            driver.findElement(By.id("id_introeditoreditable")).sendKeys(jsonObject.get("bdText").toString());
            Thread.sleep(2000);
            driver.findElement(By.id("id_submitbutton2")).click();

            assertEquals(driver.findElement(By.id("section-3")).findElement(By.className("course-section-header")).findElement(By.tagName("h3")).getText(),jsonObject.get("topc3").toString());

    }

    @Test

    public void teste4() throws InterruptedException {
        driver.get(jsonObject.get("url").toString());
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.findElement(By.linkText("Acessar")).click();
        driver.findElement(By.id("username")).sendKeys(jsonObject.get("username").toString());
        driver.findElement(By.id("password")).sendKeys(jsonObject.get("password").toString());
        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.className("custom-control-input")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("a[href='https://gmlunardi.pro.br/moodlerp2/my/courses.php']")).click();
        Thread.sleep(4000);
        driver.findElement(By.className("multiline")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("section-4")).findElement(By.className("quickeditlink")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("section-4")).findElement(By.className("form-control")).sendKeys(jsonObject.get("topc3").toString());
        Thread.sleep(2000);
        driver.findElement(By.id("section-4")).findElement(By.className("form-control")).sendKeys(Keys.ENTER);    
        driver.findElement(By.id("section-4")).findElement(By.className("activity-add-text")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("a[href='https://gmlunardi.pro.br/moodlerp2/course/mod.php?id=6&add=data&section=3&sr=0']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("id_name")).sendKeys(jsonObject.get("glos1").toString());
        Thread.sleep(2000);
        driver.findElement(By.id("id_introeditoreditable")).sendKeys(jsonObject.get("glosText").toString());
        Thread.sleep(2000);
        driver.findElement(By.id("id_submitbutton2")).click();

        assertEquals(driver.findElement(By.id("section-4")).findElement(By.className("course-section-header")).findElement(By.tagName("h3")).getText(),jsonObject.get("topc4").toString());

    }

}
