package pom;

import org.openqa.selenium.By;

public class HomePage {

    private By menuButtonElem = By.xpath("//*[@id=\"botonMenu\"]");
    private By expandReservaElem = By.xpath("/html/body/div[2]/div[1]/div/div[1]/ul/li[23]/div/span");
    private By gestionReservaMenuElem = By.partialLinkText("n Reservas");

    public By getMenuButtonElem() {
        return menuButtonElem;
    }

    public By getExpandReservaElem() {
        return expandReservaElem;
    }

    public By getGestionReservaMenuElem() {
        return gestionReservaMenuElem;
    }

}
