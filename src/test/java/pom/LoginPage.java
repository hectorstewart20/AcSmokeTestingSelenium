package pom;

import org.openqa.selenium.By;

public class LoginPage {

    private By usernameElem = By.id("UserName");
    private By passElem = By.id("Password");
    private By loginButtonElem = By.className("btnenviar");
    private String titleLoginPage = "Login - LAG";
    private String pass = "Hgonzalez.2021";
    private String user = "hgonzalez";

    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }

    public String getTitleLoginPage() {
        return titleLoginPage;
    }
    public By getUsernameElem() {
        return usernameElem;
    }
    public By getPassElem() {
        return passElem;
    }
    public By getLoginButtonElem() {
        return loginButtonElem;
    }

}
