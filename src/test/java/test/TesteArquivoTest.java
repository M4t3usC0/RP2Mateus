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


public class TesteArquivoTest {


  private static  JSONObject jsonObject;
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp()throws FileNotFoundException, IOException, ParseException {
    
    jsonObject = (JSONObject) new JSONParser().parse(new FileReader("C:\\Users\\User\\Documents\\test\\projetorp2\\src\\test\\java\\test\\arquivo.json"));
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    
  }
  @Test
  public void testeDeArquivo() throws InterruptedException {
    driver.get(jsonObject.get("url").toString());
    driver.manage().window().setSize(new Dimension(1440, 900));
    
    driver.findElement(By.linkText("Acessar")).click();
  //driver.findElement(By.id("username")).click();
  driver.findElement(By.id("username")).sendKeys(jsonObject.get("username").toString());
  driver.findElement(By.id("password")).sendKeys(jsonObject.get("password").toString());
  driver.findElement(By.id("loginbtn")).click();
  driver.findElement(By.className("custom-control-input")).click();
  Thread.sleep(4000);
  driver.findElement(By.cssSelector("a[href='https://gmlunardi.pro.br/moodlerp2/my/courses.php']")).click();
  Thread.sleep(4000);
  driver.findElement(By.className("multiline")).click();

  //driver.findElement(By.id("coursecontentsection1")).click();
  //WebElement a = 
  driver.findElement(By.id("section-1")).findElement(By.className("quickeditlink")).click();
  Thread.sleep(2000);
  driver.findElement(By.id("section-1")).findElement(By.className("form-control")).sendKeys("Mateus");
  //a.sendKeys("Calculo A");
  Thread.sleep(2000);
  driver.findElement(By.id("section-1")).findElement(By.className("form-control")).sendKeys(Keys.ENTER);
  Thread.sleep(2000);
  driver.findElement(By.id("section-1")).findElement(By.className("activity-add-text")).click();
  Thread.sleep(4000);
  driver.findElement(By.cssSelector("a[href='https://gmlunardi.pro.br/moodlerp2/course/mod.php?id=6&add=resource&section=1&sr=0']")).click();
  Thread.sleep(2000);
  driver.findElement(By.id("id_name")).sendKeys(jsonObject.get("nomeArquivo").toString());
  //Thread.sleep(2000);
  //driver.findElement(By.id("id_name")).sendKeys(Keys.ENTER);
  Thread.sleep(2000);
  driver.findElement(By.className("editor_atto_content")).sendKeys(jsonObject.get("texto1").toString());
  Thread.sleep(2000);
  driver.findElement(By.className("dndupload-arrow")).click();
  Thread.sleep(2000);
  driver.findElement(By.name("repo_upload_file")).sendKeys(jsonObject.get("caminho").toString());
  Thread.sleep(2000);
  driver.findElement(By.className("fp-upload-btn")).click();
  Thread.sleep(10000);
  driver.findElement(By.id("id_submitbutton2")).click();

  List<WebElement> listaModulos = driver.findElement(By.id("section-1")).findElement(By.className("d-block")).findElements(By.tagName("li"));

        for(WebElement elemento : listaModulos) {
            if(elemento.getText().contains("Topc1")) {
                assertEquals(elemento.getText(), "Topc1");
                break;
            }
        } 


  }
}
