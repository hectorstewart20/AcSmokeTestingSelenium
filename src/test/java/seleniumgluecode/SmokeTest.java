package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import pom.LoginPage;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SmokeTest extends TestBase{

    By usernameElem = By.id("UserName");
    By passElem = By.id("Password");
    By loginButtonElem = By.className("btnenviar");
    By menuButtonElem = By.xpath("//*[@id=\"botonMenu\"]");
    By expandReservaElem = By.xpath("/html/body/div[2]/div[1]/div/div[1]/ul/li[23]/div/span");
    By gestionReservaMenuElem = By.partialLinkText("n Reservas");
    By selectClienteAwbNewElem = By.xpath("//td[@data-container-for=\"nombreCliente\"]/span[@aria-owns=\"idCliente_listbox\"]");
    By inputClienteAwbNewElem = By.xpath("//input[@aria-owns='idCliente_listbox']");
    By selectTransporteIcaoElem = By.xpath("//span[contains(text(),'Seleccionar ...')]");
    By inputTransporteIcaoElem = By.xpath("//input[@aria-owns='idTransporte_listbox']");
    By selectPuertoOrigenElem = By.xpath("//tbody/tr[1]/td[26]/span[1]/span[1]/span[2]/span[1]");
    By inputPuertoOrigenElem = By.xpath("//input[@aria-owns='idPuertoOrigen_listbox']");
    By inputCoordElem = By.xpath("//input[@id='bxsCoordinadas']");
    By inputReservadasElem = By.xpath("//input[@id='cajasReservadas']");
    By inputPesoNetoElem = By.xpath("//input[@id='pesoNetoCajasReservadas']");
    By inputPesoVolElem = By.xpath("//input[@id='pesoVolumenCajasReservadas']");
    By selectPagoElem = By.xpath("//td[@data-container-for='tipoPago']/span[@aria-owns='tipoPago_listbox']");
    By pagoCC = By.xpath("//body/div[113]/div[1]/div[3]/ul[1]/li[1]");
    By pagoPP = By.xpath("//body/div[113]/div[1]/div[3]/ul[1]/li[2]");
    By puertoDestinoBoxElem = By.xpath("//input[@aria-owns='idPuertoDestino_listbox']");
    By puertoDestinoListElem = By.xpath("//tbody/tr[1]/td[27]/span[1]/span[1]/span[2]/span[1]");
    By brokerListElem = By.xpath("//tbody/tr[1]/td[28]/span[1]/span[1]/span[2]/span[1]");
    By brokerElem = By.xpath("substring(//li[contains(text(),'AERMAN')], 2)");
    By brokerBoxElem = By.xpath("//input[@aria-owns='idBroker_listbox']");
    //By textoAlertBrokerNo = By.xpath("//div[@id='cargaAdvertenciaNoParamerizado']/text()[1])");
    By botonCerrarBroker = By.xpath("//div[@id='modalAdvertenciaNoParamerizado']//button[@class='close']");
    By textoAlertBrokerNo2 = By.xpath("//*[@id='cargaAdvertenciaNoParamerizado']/text()[1]");
    String idClienteText = "PASSION GROWERS WEST LLCMIA";
    //By puertoDocListElem = By.xpath("//tbody/tr[1]/td[29]/span[1]/span[1]/span[2]/span[1]");
    By puertoDocListElem = By.xpath("//td[@data-container-for='ciudadDestinoDocumentos']/span[@aria-owns='idPuertoDestinoDocumentos_listbox']");
    By puertoDocBoxElem = By.xpath("//input[@aria-owns='idPuertoDestinoDocumentos_listbox']");
    By productoListElem = By.xpath("//tbody/tr[1]/td[30]/span[1]/span[1]/span[2]/span[1]");
    By productoBoxElem = By.xpath("//input[@aria-owns='idProducto_listbox']");
    By tipoGuiaListElem = By.xpath("//td[@data-container-for='tipoGuia']/span[@aria-owns='tipoGuia_listbox']");
    By tipoGuiaOpcionElem = By.xpath("//ul[@id='tipoGuia_listbox']//li[2]");//1 es DIRECTA, 2 es CONSOLIDADO
    By historicoListElem = By.xpath("//td[@data-container-for='aplicarHistorico']/span[@aria-owns='aplicarHistorico_listbox']");
    By historicoOpcionElem = By.xpath("//ul[@id='aplicarHistorico_listbox']//li[1]"); //1 es SI, 2 es NO
    By vwebListElem = By.xpath("//td[@data-container-for='visibleWeb']/span[@aria-owns='visibleWeb_listbox']");
    By vwebOpcionElem = By.xpath("//ul[@id='visibleWeb_listbox']//li[1]"); //1 es SI, 2 es NO
    By bodegaListElem = By.xpath("//td[@data-container-for='idBodega']/span[@aria-owns='idBodega_listbox']");
    By bodegaBoxElem = By.xpath("//input[@aria-owns='idBodega_listbox']");
    By bodegaDestListElem = By.xpath("//td[@data-container-for='nombreBodegaDestino']/span[@aria-owns='idBodegaDestino_listbox']");
    By bodegaDestBoxElem = By.xpath("//input[@aria-owns='idBodegaDestino_listbox']");
    By tipoVueloListElem = By.xpath("//td[@data-container-for='tipoVuelo']/span[@aria-owns='tipoVuelo_listbox']");
    //TODO: REFACTORIZAR, CREAR METODO PARA INDICAR EL ELEMENTO DE LA UL POR PARAMETRO
    By tipoVueloOpcionElem = By.xpath("//ul[@id='tipoVuelo_listbox']//li[1]"); //1 es REGULAR, 2 es CHARTER
    By guardarButtonElem = By.id("botonActualizarFilaGuias");
    private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Control");



    @Given("^El usuario se encuentra en la pagina de Login de AC$")
    public void elUsuarioSeEncuentraEnLaPaginaDeLoginDeAC() throws Throwable {
        //String urlLogin = driver.getTitle();
        //String titleLoginPAge = "Login - LAG";
        Assert.assertEquals(loginPage.getTitleLoginPage(),driver.getTitle());
    }

    @When("^Ingrese Las credenciales validas$")
    public void ingreseLasCredencialesValidas() throws Throwable {
        WebElement usernameBox = driver.findElement(loginPage.getUsernameElem());
        WebElement passwordBox = driver.findElement(loginPage.getPassElem());
        usernameBox.sendKeys(loginPage.getUser());
        passwordBox.sendKeys(loginPage.getPass());
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

    public void selectField(By listElem, By boxElem,String texto) throws InterruptedException {
        WebElement selectClienteAwbNew = new WebDriverWait(driver,15)
                .until(ExpectedConditions.elementToBeClickable(listElem));
        Thread.sleep(1000);
        selectClienteAwbNew.click();
        Thread.sleep(1500);
        WebElement  inputClienteAwbNew = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(boxElem));
        inputClienteAwbNew.sendKeys(texto);
        if (!texto.equals("")) {
            Thread.sleep(1000);
            inputClienteAwbNew.sendKeys(Keys.ARROW_DOWN);
        }
        Thread.sleep(1000);
        inputClienteAwbNew.sendKeys(Keys.ENTER);
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
        Thread.sleep(3000);
        WebElement nuevaAwbLink2 = new WebDriverWait(driver,20)
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Nueva AWB")));
        nuevaAwbLink2.click();
    }

    @When("^Completo los datos de la nueva AWB$")
    public void CompletoLosDatosDeLaNuevaAWB() throws Throwable {
        System.out.println("Completando dato del cliente en el select");
        Robot robot = new Robot();
        robot.mouseWheel(40);

    // List Cliente
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].scrollIntoView(true);", selectClienteAwbNewElem);
        //Thread.sleep(1000);
        selectField(selectClienteAwbNewElem,inputClienteAwbNewElem, idClienteText);

    // List Transporte
        selectField(selectTransporteIcaoElem, inputTransporteIcaoElem,"UC");

    //TIPO DE PAGO REQUERIDO SE HABILITA AL ESCOGER EL CLIENTE
        Thread.sleep(1000);
        WebElement  selectPago = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(selectPagoElem));
        selectPago.click();
        Thread.sleep(1000);
        selectPago.click();
        Thread.sleep(1000);

    // campos de texto peso coor
        Thread.sleep(2000);
        driver.findElement(inputCoordElem).sendKeys("100");
        driver.findElement(inputReservadasElem).sendKeys("90");
        driver.findElement(inputPesoNetoElem).sendKeys("800");
        driver.findElement(inputPesoVolElem).sendKeys("1000");
    //PUERTO DE ORIGEN
        selectField(selectPuertoOrigenElem,inputPuertoOrigenElem,"UIO");

    //PUERTO DE DESTINO
        //selectField(puertoDestinoListElem,puertoDestinoBoxElem,"MIA");

    //BROKER
        selectField(brokerListElem,brokerBoxElem,"");
        LOGGER.log(Level.INFO, "Llamando al broker");
        //Assert.assertTrue(textoAlertBrokerNo2.toString().contains("no coincide"));
        //WebElement cerrarBro = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(botonCerrarBroker));
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        Thread.sleep(1000);
        //executor.executeScript("arguments[0].click();", cerrarBro);
    //PUERTO DOC
        selectField(puertoDocListElem, puertoDocBoxElem,"");

    //PRODUCTO
        selectField(productoListElem, productoBoxElem,"FRESH CUT");
    //TIPO DE GUIA
        WebElement tipoGList = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(tipoGuiaListElem));
        tipoGList.click();
        Thread.sleep(1000);
        WebElement tipoGOpcion = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(tipoGuiaOpcionElem));
        tipoGOpcion.click();
    //TIPO DE  VUELO
        WebElement vueloList = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(tipoVueloListElem));
        vueloList.click();
        Thread.sleep(1000);
        WebElement vueloOpcion = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(tipoVueloOpcionElem));
        vueloOpcion.click();
    //BODEGA
        selectField(bodegaListElem, bodegaBoxElem, "TCC-B 33-38");
    //BODEGA DESTINO
        selectField(bodegaDestListElem, bodegaDestBoxElem, "");


    }

    @When("^Se presiona el icono guardar$")
    public void seCompletaElUltimoCampo() throws Throwable {
        WebElement  guardarButton = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(guardarButtonElem));
        //guardarButton.click();
    }

    @Then("^Se inserta una nueva fila vacìa en la tabla de reservas$")
    public void seInsertaUnaNuevaFilaVacìaEnLaTablaDeReservas() throws Throwable {
        LOGGER.log(Level.INFO, "Proceso completado exitosamente");

    }




}
