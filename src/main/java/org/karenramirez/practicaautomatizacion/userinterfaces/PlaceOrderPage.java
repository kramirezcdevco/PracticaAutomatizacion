package org.karenramirez.practicaautomatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PlaceOrderPage {

    public static final Target INPUT_NAME = Target.the("Name field to place order").located(By.id("name"));

    public static final Target INPUT_COUNTRY = Target.the("Country field to place order").located(By.id("country"));

    public static final Target INPUT_CITY = Target.the("City field to place order").located(By.id("city"));

    public static final Target INPUT_CARD = Target.the("Card field to place order").located(By.id("card"));

    public static final Target INPUT_MONTH = Target.the("Month field to place order").located(By.id("month"));

    public static final Target INPUT_YEAR = Target.the("Year field to place order").located(By.id("year"));

    public static final Target BUTTON_PURCHASE = Target.the("Purchase button").locatedBy("//*[@onclick='purchaseOrder()']");

    public static final Target BUTTON_VALIDATE = Target.the("Validate button").locatedBy("//button[text()='OK']");

}
