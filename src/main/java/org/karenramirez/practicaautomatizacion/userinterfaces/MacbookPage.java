package org.karenramirez.practicaautomatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class MacbookPage {

    public static final Target BUTTON_ADD = Target.the("Button add to car").locatedBy("//a[@onclick='addToCart(11)']");//a[text()='Add to cart']
}
