package org.karenramirez.practicaautomatizacion.userinterfaces;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.demoblaze.com/index.html")
public class DemoBlazeHomePage extends PageObject {
    public static final Target MENU_LOG_IN = Target.the("Log in menu").located(By.id("login2"));

    public static final Target MENU_HOME = Target.the("Home menu").locatedBy("//a[text()='Home ']");

    public static final Target MENU_CART = Target.the("Cart menu").located(By.id("cartur"));
}
