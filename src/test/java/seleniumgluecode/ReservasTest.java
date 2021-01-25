package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class ReservasTest {
    /*private ChromeDriver driver = Hooks.getDriver();

    @Given("^El usuario se encuentra logueado en la pagina home de AC$")
    public void elUsuarioSeEncuentraLogueadoEnLaPaginaHomeDeAC() throws Throwable {
        String urlHome = driver.getTitle();
        String titleHomePage = "Home Page - LAG";
        Assert.assertEquals(titleHomePage,urlHome);
    }

    @When("^Hago Click al Menu Principal y Entro al modudo de reservas$")
    public void entroAlModudoDeReservas() throws Throwable {
        WebElement MenuButtom = driver.findElement(By.id("botonMenu"));
        MenuButtom.click();
        Thread.sleep(1000);
        Robot robot = new Robot();
        robot.mouseMove(10,500);
        robot.mouseWheel(1000);
        Thread.sleep(1000);
        WebElement expandReservaIcon = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/ul/li[23]/div/span"));
        expandReservaIcon.click();
        Thread.sleep(500);
        //System.out.println("DISPLAYED "+ expandReservaIcon.isDisplayed());
        WebElement GestionReservasButton = driver.findElement(By.partialLinkText("n Reservas"));
        GestionReservasButton.click();
        Thread.sleep(1000);
    }

    @When("^Elige la Fecha en el calendario$")
    public void eligeLaFechaEnElCalendario() throws Throwable {
        WebElement fechaEmbargeCalendar = driver.findElement(By.id("fechaEmbarque"));
    }

    @When("^Haga click en el enlace Nueva AWB$")
    public void hagaClickEnElEnlaceNuevaAWB() throws Throwable {
        WebElement nuevaAwbLink = driver.findElement(By.xpath("//*[@id= \"gridGuiasReservadas \"]/div[1]/a/text()"));
        nuevaAwbLink.click();
    }

    @Then("^Se inserta una nueva fila vacìa en la tabla de reservas$")
    public void seInsertaUnaNuevaFilaVacìaEnLaTablaDeReservas() throws Throwable {
        System.out.println("Se abrio la nueva fila de reserva");
    }

     */
}
