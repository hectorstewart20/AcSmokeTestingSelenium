package pom;

import org.openqa.selenium.By;

public class GestionReservasPage {
    private By selectClienteAwbNewElem = By.xpath("//td[@data-container-for=\"nombreCliente\"]/span[@aria-owns=\"idCliente_listbox\"]");
    private By inputClienteAwbNewElem = By.xpath("//input[@aria-owns='idCliente_listbox']");
    private By selectTransporteIcaoElem = By.xpath("//span[contains(text(),'Seleccionar ...')]");
    private By inputTransporteIcaoElem = By.xpath("//input[@aria-owns='idTransporte_listbox']");
    private By selectPuertoOrigenElem = By.xpath("//tbody/tr[1]/td[26]/span[1]/span[1]/span[2]/span[1]");
    private By inputPuertoOrigenElem = By.xpath("//input[@aria-owns='idPuertoOrigen_listbox']");
    private By inputCoordElem = By.xpath("//input[@id='bxsCoordinadas']");
    private By inputReservadasElem = By.xpath("//input[@id='cajasReservadas']");
    private By inputPesoNetoElem = By.xpath("//input[@id='pesoNetoCajasReservadas']");
    private By inputPesoVolElem = By.xpath("//input[@id='pesoVolumenCajasReservadas']");
    private By selectPagoElem = By.xpath("//td[@data-container-for='tipoPago']/span[@aria-owns='tipoPago_listbox']");

    public By getTipoPagoOpcionElem() {
        return tipoPagoOpcionElem;
    }

    private By tipoPagoOpcionElem = By.xpath("//ul[@id='tipoPago_listbox']//li[1]");//1CC, 2PP

    public String getIdClienteText() {
        return idClienteText;
    }

    private String idClienteText = "PASSION GROWERS WEST LLCMIA";
    public By getSelectClienteAwbNewElem() {
        return selectClienteAwbNewElem;
    }

    public By getInputClienteAwbNewElem() {
        return inputClienteAwbNewElem;
    }

    public By getSelectTransporteIcaoElem() {
        return selectTransporteIcaoElem;
    }

    public By getInputTransporteIcaoElem() {
        return inputTransporteIcaoElem;
    }

    public By getSelectPuertoOrigenElem() {
        return selectPuertoOrigenElem;
    }

    public By getInputPuertoOrigenElem() {
        return inputPuertoOrigenElem;
    }

    public By getInputCoordElem() {
        return inputCoordElem;
    }

    public By getInputReservadasElem() {
        return inputReservadasElem;
    }

    public By getInputPesoNetoElem() {
        return inputPesoNetoElem;
    }

    public By getInputPesoVolElem() {
        return inputPesoVolElem;
    }

    public By getSelectPagoElem() {
        return selectPagoElem;
    }


}
