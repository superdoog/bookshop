// Generated by Selenium IDE

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RegTest {
    private ArrayList param;

    @Parameterized.Parameters
    public static Collection data() {
        ArrayList list = new ArrayList<>();
        list.add("test1");
        list.add("123456");
        list.add("123456");
        list.add("男");
        list.add("123456");

        ArrayList list1 = new ArrayList<>();
        list1.add("test1");
        list1.add("123456");
        list1.add("123456");
        list1.add("男");
        list1.add("123456");

        ArrayList list2 = new ArrayList<>();
        list2.add("01234567890");
        list2.add("123456");
        list2.add("123456");
        list2.add("女");
        list2.add("123456");

        ArrayList list3 = new ArrayList<>();
        list3.add("test3");
        list3.add("12345");
        list3.add("12345");
        list3.add("男");
        list3.add("123456");

        ArrayList list4 = new ArrayList<>();
        list4.add("test4");
        list4.add("123456789012345678901");
        list4.add("123456789012345678901");
        list4.add("男");
        list4.add("123456");

        ArrayList list5 = new ArrayList<>();
        list5.add("test5");
        list5.add("123456");
        list5.add("12345");
        list5.add("男");
        list5.add("123456");

        ArrayList list6 = new ArrayList<>();
        list6.add("test6");
        list6.add("123456");
        list6.add("123456");
        list6.add("男");
        list6.add("123456");


        //return Arrays.asList(new Object[][]{{list, true},{list1, true},{list2, true},{list3, true},{list4, true},{list5, true},{list6, true}});
        return Arrays.asList(new Object[]{list,list1,list2,list3,list4,list5,list6});
    }

    public RegTest(ArrayList param) {
        this.param = param;
    }

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        System.out.println("----开始测试----");
    }

    @After
    public void tearDown() {
        System.out.println("----结束----");
        driver.quit();
    }

    @Test
    public void reg() {
        driver.get("http://localhost:8080/BookShop/index");
        //driver.manage().window().setSize(new Dimension(960, 1057));
        driver.findElement(By.cssSelector("li:nth-child(3) font")).click();
        driver.findElement(By.id("register")).click();
        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).sendKeys((CharSequence) param.get(0));
        driver.findElement(By.id("userPassword")).click();
        driver.findElement(By.id("userPassword")).sendKeys((CharSequence) param.get(1));
        driver.findElement(By.id("ruserPassword")).click();
        driver.findElement(By.id("ruserPassword")).sendKeys((CharSequence) param.get(2));
        driver.findElement(By.id("gender")).click();
        {
            WebElement dropdown = driver.findElement(By.id("gender"));
            dropdown.findElement(By.xpath("//option[. = '" + (CharSequence) param.get(3) + "']")).click();
        }
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys((CharSequence) param.get(4));
        driver.findElement(By.id("add")).click();
        assertThat(driver.switchTo().alert().getText(), is("是否确认注册？"));
        driver.switchTo().alert().accept();
        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).sendKeys((CharSequence) param.get(0));
        driver.findElement(By.id("passWord")).click();
        driver.findElement(By.id("passWord")).sendKeys((CharSequence) param.get(1));
        driver.findElement(By.id("yan")).click();
        driver.findElement(By.id("yan")).sendKeys("KEY");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("logout")).click();
    }
}