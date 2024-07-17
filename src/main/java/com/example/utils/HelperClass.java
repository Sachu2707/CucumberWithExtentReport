package com.example.utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
  
public class HelperClass {
      
    private static HelperClass helperClass;
      
    private static WebDriver driver;
    private static WebDriverWait wait;
    public final static int TIMEOUT = 10;
      
     private HelperClass() {
                   

       WebDriverManager.chromedriver().setup();
       ChromeOptions options = new ChromeOptions();
       options.setHeadless(false);
       options.addArguments("start-maximized"); // open Browser in maximized mode
       options.addArguments("disable-infobars"); // disabling infobars
       options.addArguments("--disable-extensions"); // disabling extensions
       options.addArguments("--disable-gpu"); // applicable to Windows os only
       options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
       options.addArguments("--no-sandbox"); // Bypass OS security model
       options.addArguments("--disable-in-process-stack-traces");
       options.addArguments("--disable-logging");
       options.addArguments("--log-level=3");
       options.addArguments("--remote-allow-origins=*");

       driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
       driver.manage().window().maximize();
         }    
              
    public static void openPage(String url) {
        driver.get(url);
    }
  
      
    public static WebDriver getDriver() {
        return driver;              
    }
      
    public static void setUpDriver() {
          
        if (helperClass==null) {
              
            helperClass = new HelperClass();
        }
    }
      
     public static void tearDown() {
           
         if(driver!=null) {
             driver.close();
             driver.quit();
         }
           
         helperClass = null;
     } 
      
}