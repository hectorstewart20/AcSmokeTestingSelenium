package seleniumgluecode;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {
    private static ChromeDriver driver;
    //private DriverManager driverManager;

    @Before
    public void setUp() throws IOException {
        //Properties properties = new Properties();
        //properties.load(new FileReader("src/test/resources/config.properties"));
        //driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        //driver = driverManager.getDriver();
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.17.22:82/logcloud");
        driver.manage().window().maximize();



        //driver.get(properties.getProperty("url_base"));
        //driver.manage().window().maximize();
    }


    public void connectToMongoServer() throws IOException {
        //MongoDBHelper.connectToServer();
    }

    @After
    public void tearDown(){
        /*if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        driverManager.quitDriver();*/
        //driver.quit();
        //driver.close();
    }

    public static ChromeDriver getDriver(){
        return driver;
    }
}
