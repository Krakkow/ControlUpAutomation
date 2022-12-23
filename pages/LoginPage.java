package pages;

import org.openqa.selenium.WebElement;

public class LoginPage {

    String username;
    String password;

    public static String usernameFieldLocator = "";
    public static String passwordFieldLocator = "";
    public static String LogInButtonLocator = "";

    WebElement usernameField;
    WebElement passwordField;
    WebElement LogInButton;

    public LoginPage(String username, String password) {
        this.username = username;
        this.password = password;
    }





}
