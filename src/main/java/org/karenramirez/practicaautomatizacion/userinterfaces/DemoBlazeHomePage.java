package org.karenramirez.practicaautomatizacion.userinterfaces;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.demoblaze.com/index.html")
public class DemoBlazeHomePage extends PageObject {

    public static final Target CATEGORY_MENU = Target.the("Category of {0}")
            .locatedBy("//a[@id='itemc'][text()='{0}']");
    public static final Target PRODUCT = Target.the("Product {0}")
            .locatedBy("//div[contains(@class,'card')]//a[text()='{0}']");
}
