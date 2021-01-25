package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Ro;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;


public class SmokeTest {
    private ChromeDriver driver = Hooks.getDriver();
    By usernameElem      = By.id("UserName");
    By passElem          = By.id("Password");
    By loginButtonElem   = By.className("btnenviar");
    By menuButtonElem    = By.xpath("//*[@id=\"botonMenu\"]");
    By expandReservaElem = By.xpath("/html/body/div[2]/div[1]/div/div[1]/ul/li[23]/div/span");
    By gestionReservaMenuElem = By.partialLinkText("n Reservas");
    By nuevaAwbLinkElem  = By.xpath("//*[@id=\"gridGuiasReservadas\"]/div[1]/a");
    By nuevaAwbLinkElem2 = By.partialLinkText("Nueva AWB");
    By selectClienteAwbNewElem = By.xpath("//tbody/tr[1]/td[13]/span[1]/span[1]");
    By inputClienteAwbNewElem = By.xpath("//input[@aria-owns='idCliente_listbox']");
    By selectTransporteElem = By.xpath("//span[contains(text(),'Seleccionar ...')]");
    By inputTransporteElem = By.xpath("//input[@aria-owns='idTransporte_listbox']");
    By selectPuertoOrigenElem = By.xpath("//tbody/tr[1]/td[26]/span[1]/span[1]/span[2]/span[1]");
    By inputPuertoOrigenElem = By.xpath("//input[@aria-owns='idPuertoOrigen_listbox']");
    By inputCoordElem = By.xpath("//input[@id='bxsCoordinadas']");
    By inputReservadasElem = By.xpath("//input[@id='cajasReservadas']");
    By inputPesoNetoElem = By.xpath("//input[@id='pesoNetoCajasReservadas']");
    By inputPesoVolElem = By.xpath("//input[@id='pesoVolumenCajasReservadas']");
    By selectPagoElem = By.xpath("//tbody/tr[1]/td[16]/span[1]/span[1]/span[2]/span[1]");
    By pagoCC = By.xpath("//body/div[113]/div[1]/div[3]/ul[1]/li[1]");
    By pagoPP = By.xpath("//body/div[113]/div[1]/div[3]/ul[1]/li[2]");


    String idCliente = "PASSION GROWERS WEST LLCMIA";

    @Given("^El usuario se encuentra en la pagina de Login de AC$")
    public void elUsuarioSeEncuentraEnLaPaginaDeLoginDeAC() throws Throwable {
        String urlLogin = driver.getTitle();
        String titleLoginPAge = "Login - LAG";
        Assert.assertEquals(titleLoginPAge,urlLogin);
    }

    @When("^Ingrese Las credenciales validas$")
    public void ingreseLasCredencialesValidas() throws Throwable {
        WebElement usernameBox = driver.findElement(usernameElem);
        WebElement passwordBox = driver.findElement(passElem);
        usernameBox.sendKeys("hgonzalez");
        passwordBox.sendKeys("Hgonzalez.2021");
        Thread.sleep(2000);
    }

    @When("^Haga click en la flecha verde$")
    public void hagaClickEnLaFlechaVerde() throws Throwable {
        WebElement flechaButtom = driver.findElement(loginButtonElem);
        flechaButtom.click();
        Thread.sleep(1000);
    }


    @When("^Ingreso al Sistema AC y veo la pagina Home$")
    public void ingresoAlSistemaACYVeoLaPaginaHome() throws Throwable {
        String urlHome = driver.getTitle();
        Assert.assertEquals("Home Page - LAG",urlHome);
    }

    @When("^El usuario se encuentra logueado en la pagina home de AC$")
    public void elUsuarioSeEncuentraLogueadoEnLaPaginaHomeDeAC() throws Throwable {
        String urlHome = driver.getTitle();
        String titleHomePage = "Home Page - LAG";
        Assert.assertEquals(titleHomePage,urlHome);
        Thread.sleep(1000);
    }

    @When("^Hago Click al Menu Principal y Entro al modudo de reservas$")
    public void entroAlModudoDeReservas() throws Throwable {
        Robot robot = new Robot();
        WebElement menuButtom = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(menuButtonElem));
        robot.mouseMove(15,150);
        Thread.sleep(1000);
        //intento hacer click asi ya que es mas confiable
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        //se ubica en el panel de opciones para scrollear
        robot.mouseMove(10,500);
        robot.mouseWheel(1000);
        Thread.sleep(1000);
        WebElement expandReservaIcon = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(expandReservaElem));
        Thread.sleep(1000);
        expandReservaIcon.click();
        Thread.sleep(500);
        WebElement GestionReservasButton = driver.findElement(gestionReservaMenuElem);
        GestionReservasButton.click();
        Thread.sleep(1000);
    }

    @When("^Elijo la Fecha en el calendario$")
    public void elijoLaFechaEnElCalendario() throws Throwable {
        WebElement fechaEmbargeCalendar = driver.findElement(By.id("fechaEmbarque"));
    }

    @When("^Hago click en el enlace Nueva AWB$")
    public void hagoClickEnElEnlaceNuevaAWB() throws Throwable {
        /*WebElement nuevaAwbLink = new WebDriverWait(driver,20)
                .until(ExpectedConditions.presenceOfElementLocated(nuevaAwbLinkElem));
        nuevaAwbLink.click();*/
        Thread.sleep(5000);
        WebElement nuevaAwbLink2 = new WebDriverWait(driver,20)
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Nueva AWB")));
        nuevaAwbLink2.click();


    }

    @When("^Completo los datos de la nueva AWB$")
    public void CompletoLosDatosDeLaNuevaAWB() throws Throwable {
        System.out.println("Completando dato del cliente en el select");
        //Select selectClienteAwbNew = new Select(driver.findElement(selectClienteAwbNewElem));
        //selectClienteAwbNew.selectByVisibleText("PASSION GROWERS WEST LLCMIA");
        Robot robot = new Robot();
        robot.mouseWheel(200);
    // List Cliente   "//input[@aria-owns='idCliente_listbox']"
        WebElement selectClienteAwbNew = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectClienteAwbNewElem));
        selectClienteAwbNew.click();
        Thread.sleep(5000);
        WebElement  inputClienteAwbNew = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(inputClienteAwbNewElem));
        inputClienteAwbNew.sendKeys(idCliente);
        Thread.sleep(1000);
        inputClienteAwbNew.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        inputClienteAwbNew.sendKeys(Keys.ENTER);
    // List Transporte
        WebElement selectTransporte = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectTransporteElem));
        selectTransporte.click();
        Thread.sleep(5000);
        WebElement  inputTransporte = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(inputTransporteElem));
        inputTransporte.sendKeys("UC");
        Thread.sleep(1000);
        inputTransporte.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        inputTransporte.sendKeys(Keys.ENTER);

    //TIPO DE PAGO REQUERIDO SE HABILITA AL ESCOGER EL CLIENTE
        WebElement  selectPago = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectPagoElem));
        selectPago.click();
        Thread.sleep(1000);
        selectPago.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        selectPago.sendKeys(Keys.ENTER);

    // campos de texto peso coor
        Thread.sleep(3000);
        driver.findElement(inputCoordElem).sendKeys("100");
        driver.findElement(inputReservadasElem).sendKeys("90");
        driver.findElement(inputPesoNetoElem).sendKeys("800");
        driver.findElement(inputPesoVolElem).sendKeys("1000");
    //PUERTO DE ORIGEN
        WebElement selectPuertoOrigen = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectPuertoOrigenElem));
        selectPuertoOrigen.click();
        Thread.sleep(5000);
        WebElement  inputPuertoOrigen = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(inputPuertoOrigenElem));
        inputPuertoOrigen.sendKeys("UIO");
        Thread.sleep(1000);
        inputPuertoOrigen.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        inputPuertoOrigen.sendKeys(Keys.ENTER);

    }

    @Then("^Se inserta una nueva fila vacìa en la tabla de reservas$")
    public void seInsertaUnaNuevaFilaVacìaEnLaTablaDeReservas() throws Throwable {
        System.out.println("Se abrio la nueva fila de reserva");
    }




}
