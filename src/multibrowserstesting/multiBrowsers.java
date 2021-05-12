package multibrowserstesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class multiBrowsers {


    static String browser;
    static String url = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter browser name: ");
        browser= scanner.next();
        String title;
        String pageSource;




        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Wrong browser name");
        }

       driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        title = driver.getTitle();
        System.out.println(title.length());
        System.out.println(title);

        pageSource = driver.getPageSource();
        System.out.println(pageSource);

        driver.close();


    }

}
