package javaSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Selenium_Java_Tank {
    WebDriver driver;
    @BeforeClass
    public void beforeStep(){
    System.setProperty("webdriver.chrome.driver","F:\\java_Selenium\\Sources\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }
    @AfterClass
    public void afterStep(){

    }
    //八大定位元素
    @Test
    //1、通过“id”定位元素
    public void step_01(){
        driver.get("file:///E:/Users/kan/Desktop/Selenium%20%E7%BB%83%E4%B9%A0/1%E3%80%81%208%E5%A4%A7%E5%AE%9A%E4%BD%8D%E5%85%83%E7%B4%A0%E6%96%B9%E6%B3%95/%E9%80%9A%E8%BF%87ID%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0.html");
        WebElement ele_1 = driver.findElement(By.id("kw")) ;
        ele_1.sendKeys("Hello World!");
        WebElement ele_2 = driver.findElement(By.id("su"));
        ele_2.click();

    }
    @Test
    //2、通过“name”定位元素
    public void step_02(){
        driver.get("file:///E:/Users/kan/Desktop/Selenium%20%E7%BB%83%E4%B9%A0/1%E3%80%81%208%E5%A4%A7%E5%AE%9A%E4%BD%8D%E5%85%83%E7%B4%A0%E6%96%B9%E6%B3%95/2%E3%80%81%E9%80%9A%E8%BF%87Name%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0.html");
        WebElement ele_3 = driver.findElement(By.name("choices"));
        ele_3.sendKeys("电影和小说");

    }
    @Test
    //3、通过“tagName”定位元素
    public void step_03(){
        driver.get("file:///E:/Users/kan/Desktop/Selenium%20%E7%BB%83%E4%B9%A0/1%E3%80%81%208%E5%A4%A7%E5%AE%9A%E4%BD%8D%E5%85%83%E7%B4%A0%E6%96%B9%E6%B3%95/3%E3%80%81%E9%80%9A%E8%BF%87TagName%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0.html");
        List<WebElement> ele_4s = driver.findElements(By.tagName("input"));
        for(WebElement w:ele_4s){
            if(w.getAttribute("size").equals("15")){
                w.sendKeys("hello world!");
            }
        }

    }
    @Test
    //4、通过“className”定位元素
    public void step_04(){
        driver.get("file:///E:/Users/kan/Desktop/Selenium%20%E7%BB%83%E4%B9%A0/1%E3%80%81%208%E5%A4%A7%E5%AE%9A%E4%BD%8D%E5%85%83%E7%B4%A0%E6%96%B9%E6%B3%95/4%E3%80%81%E9%80%9A%E8%BF%87ClassName%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0.html");
        WebElement ele_5  = driver.findElement(By.className("order-text21"));
        ele_5.sendKeys("hello world!");

    }
    @Test
    //5、通过“linkText”定位元素
    public void step_05(){
        driver.get("file:///E:/Users/kan/Desktop/Selenium%20%E7%BB%83%E4%B9%A0/1%E3%80%81%208%E5%A4%A7%E5%AE%9A%E4%BD%8D%E5%85%83%E7%B4%A0%E6%96%B9%E6%B3%95/5%E3%80%81%E9%80%9A%E8%BF%87linkText%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0.html");
        WebElement ele_6 = driver.findElement(By.linkText("登录"));
        ele_6.click();
    }
    @Test
    //6、通过“partialLinkText”定位元素
    public void step_06(){
        driver.get("file:///E:/Users/kan/Desktop/Selenium%20%E7%BB%83%E4%B9%A0/1%E3%80%81%208%E5%A4%A7%E5%AE%9A%E4%BD%8D%E5%85%83%E7%B4%A0%E6%96%B9%E6%B3%95/6%E3%80%81%E9%80%9A%E8%BF%87partialLinkText%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0.html");
        WebElement ele_7 = driver.findElement(By.partialLinkText("一"));
        ele_7.click();
    }
    @Test
    //7、通过“cssSelector”定位元素
    public void step_07() {
        driver.get("file:///E:/Users/kan/Desktop/Selenium%20%E7%BB%83%E4%B9%A0/1%E3%80%81%208%E5%A4%A7%E5%AE%9A%E4%BD%8D%E5%85%83%E7%B4%A0%E6%96%B9%E6%B3%95/7%E3%80%81%E9%80%9A%E8%BF%87cssSelector%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0.html/**/");
        WebElement ele_8 = driver.findElement(By.cssSelector("div li [target$=\"blank\"][href*=\"5237189\"]"));
        ele_8.click();
    }
    @Test
    //8、通过“xpath”定位元素
    public void step_08() {
        int i;
        driver.get("https://www.cnblogs.com/TankXiao/p/5253072.html");
        List<WebElement> ele_9 = driver.findElements(By.xpath("//div/p/a[@target='_blank']"));
        //List遍历
        //1、
        for (int j = 0; j < ele_9.size(); j++) {
            System.out.println(j+">>>>>>"+ele_9.get(j));
        }
        //2、
        i = 0;
        for(WebElement w:ele_9){
            System.out.println(i+"-------"+w);
            i++;
        }
        //3、
        i = 0;
        Iterator<WebElement> ele = ele_9.iterator();
        while(ele.hasNext()){
            System.out.println(i+"++++++++++"+ele.next());
            i++;
        }
        ele_9.get(1).click();
//        driver.navigate().back();
        Iterator<WebElement> ele_9_1 = ele_9.iterator();
        WebElement ele_10 = null;
        while(ele_9_1.hasNext()){
            if(ele_9_1.next().getAttribute("href").contains("5260683")){
                ele_10 = ele_9_1.next();
                break;
            }
        }
        ele_10.click();
    }
    @Test
    //显示等待
    public void step_09(){
        driver.get("file:///E:/Users/kan/Desktop/Selenium%20%E7%BB%83%E4%B9%A0/%E6%99%BA%E8%83%BD%E7%AD%89%E5%BE%85%E6%97%B6%E9%97%B4.html");
        //实例化WebDriverWait对象，设置浏览器和超时等待时间
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(By.id("b")).click();
        //1、设置等待条件_elementToBeClickable——查看元素是否可以被点击
        wait.until(ExpectedConditions.elementToBeClickable(By.className("red_box1"))).getTagName();
        //2、设置等待条件：elementToBeSelected——查看元素是否被选中
        /*wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.id(""))));*/

        //3、设置等待条件：presenceOfElementLocated()——查看页面元素是否存在
        WebDriverWait w_3 = new WebDriverWait(driver,10);
//        w_3.until(ExpectedConditions.presenceOfElementLocated());
    }



}