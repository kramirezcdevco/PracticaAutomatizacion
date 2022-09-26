package org.karenramirez.practicaautomatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CategoriesPage {
    public static final Target CATEGORY_LAPTOP = Target.the("Option laptops in categories menu").locatedBy("//a[text()='Laptops']");//*[@onclick="byCat('phone')"]

    public static final Target CATEGORY_MONITOR = Target.the("Option monitors in categories menu").locatedBy("//a[text()='Monitors']");
}
