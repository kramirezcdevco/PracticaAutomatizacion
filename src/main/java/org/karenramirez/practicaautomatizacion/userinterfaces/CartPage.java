package org.karenramirez.practicaautomatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target BUTTON_PLACE_ORDER = Target.the("Place order button").locatedBy("//*[@id='page-wrapper']/div/div[2]/button");

}
