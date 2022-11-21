package test;

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
import com.google.gson.JsonObject;
import org.openqa.selenium.JavascriptExecutor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {

  private static  JSONObject jsonObject;
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  @BeforeEach
  public void setUp() throws FileNotFoundException, IOException, ParseException {
    jsonObject = (JSONObject) new JSONParser().parse(new FileReader("C:\\Users\\User\\Documents\\test\\projetorp2\\src\\test\\java\\test\\arquivo.json"));
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  // Comentario 2.0
  @Test
  public void testLogin() {
    driver.get (jsonObject.get("url").toString());
    driver.manage().window().setSize(new Dimension(1440, 900));
    {
        WebElement element = driver.findElement(By.id("lang-menu-toggle"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
      }
      driver.findElement(By.linkText("Acessar")).click();
    //driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys(jsonObject.get("username").toString());
    driver.findElement(By.id("password")).sendKeys(jsonObject.get("password").toString());
    driver.findElement(By.id("loginbtn")).click();
    assertEquals( "https://gmlunardi.pro.br/moodlerp2/my/", driver.getCurrentUrl());
    }
    
  }
