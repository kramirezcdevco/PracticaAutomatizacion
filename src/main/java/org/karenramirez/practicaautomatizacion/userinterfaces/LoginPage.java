package org.karenramirez.practicaautomatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target INPUT_USERNAME = Target.the("Username field to login").located(By.id("loginusername"));
    public static final Target INPUT_PASSWORD = Target.the("Password field to login").located(By.id("loginpassword"));
    public static final Target BUTTON_LOGIN = Target.the("Login button").locatedBy("//button[@onclick='logIn()']");
}
