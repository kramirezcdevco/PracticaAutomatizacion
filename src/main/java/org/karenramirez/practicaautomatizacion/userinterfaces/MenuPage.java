package org.karenramirez.practicaautomatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPage {
    public static final Target MENU_LOG_IN = Target.the("Log in menu").located(By.id("login2"));
    public static final Target MENU_HOME = Target.the("Home menu").locatedBy("//a[text()='Home ']");
    public static final Target MENU_CART = Target.the("Cart menu").located(By.id("cartur"));
    public static final Target MENU_LOG_OUT = Target.the("Log out Menu").located(By.id("logout2"));
}