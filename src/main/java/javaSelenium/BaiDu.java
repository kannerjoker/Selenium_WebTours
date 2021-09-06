package javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Set;

public class BaiDu {
    WebDriver driver;
    @BeforeClass
    public void begin(){
        System.setProperty("webdriver.chrome.driver","F:\\java_Selenium\\Sources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void end(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void step_01(){
        driver.get("https://www.baidu.com");
        WebElement ele = driver.findElement(By.id("kw"));
        ele.sendKeys("Selenium自动化测试");
        WebElement ele1 = driver.findElement(By.id("su"));
        ele1.click();

    }
    @Test
    //浏览器打开新窗口
    public void step_02(){
        driver.get("file:///E:/Users/kan/Desktop/Selenium%20%E7%BB%83%E4%B9%A0/%E5%BC%B9%E5%87%BA%E7%AA%97%E5%8F%A3.html");
        String first_tit = driver.getTitle();
        String first_win = driver.getWindowHandle();
        System.out.println("窗口1+句柄："+first_tit+";"+first_win);

        driver.findElement(By.tagName("input")).click();

        Set<String> all_win = driver.getWindowHandles();
        for(String w : all_win){
            System.out.println(w);
            if(!w.equals(first_win)){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.switchTo().window(w);
                System.out.println(driver.getTitle());
                break;
            }
        }
        System.out.println("当前窗口+句柄："+driver.getTitle()+";"+driver.getWindowHandle());
    }

    @Test
    public void step_03_1(){
        driver.get("https://www.cnblogs.com/TankXiao/p/5237189.html");
        String win1_h = driver.getWindowHandle();
        String win1_t = driver.getTitle();
        System.out.println("初始窗口："+win1_t+"---->"+win1_h);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("java selenium (十二) 操作弹出窗口")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> all_wins = driver.getWindowHandles();
        for(String s:all_wins){
            if(!win1_h.equals(s)){
                driver.switchTo().window(s);
                System.out.println(driver.getTitle());
            }
        }
        System.out.println("==========>>>"+driver.getTitle());
        List<WebElement> h1_all = driver.findElements(By.tagName("h1"));
        WebElement ele = null;
        int count = 0;
        for(WebElement w : h1_all){
            if(w.getAttribute("id").equals("tank_h1")){
                ele = w;
                count++;
                System.out.println(count+"---"+ele.getText());
            }
        }
    }

    //切换iframe
    @Test
    public void step_03(){
        driver.get("file:///E:/Users/kan/Desktop/Selenium%20%E7%BB%83%E4%B9%A0/mian_frame.html");
        driver.findElement(By.id("maininput")).sendKeys("main_input");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame("frameA");
        driver.findElement(By.id("iframeinput")).sendKeys("iframe_input");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().defaultContent();
        driver.findElement(By.id("maininput")).clear();
    }
}
