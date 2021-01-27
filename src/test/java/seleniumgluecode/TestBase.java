package seleniumgluecode;

import org.openqa.selenium.chrome.ChromeDriver;
import pom.HomePage;
import pom.LoginPage;
import pom.GestionReservasPage;

public class TestBase {
    protected ChromeDriver driver = Hooks.getDriver();
    protected LoginPage loginPage = new LoginPage();
    protected HomePage homePage   = new HomePage();
    protected GestionReservasPage gestionReservasPage   = new GestionReservasPage();
}
