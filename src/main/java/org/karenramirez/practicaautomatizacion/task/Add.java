package org.karenramirez.practicaautomatizacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.karenramirez.practicaautomatizacion.model.Product;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.karenramirez.practicaautomatizacion.userinterfaces.DemoBlazeHomePage.CATEGORY_MENU;
import static org.karenramirez.practicaautomatizacion.userinterfaces.DemoBlazeHomePage.PRODUCT;
import static org.karenramirez.practicaautomatizacion.userinterfaces.MenuPage.MENU_HOME;
import static org.karenramirez.practicaautomatizacion.userinterfaces.ProductPage.ADD_TO_CART_BUTTON;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Add implements Task {

    private final Product product;

    public Add(Product product) {
        this.product = product;
    }

    @Override
    @Step("{0} add to cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(MENU_HOME, isClickable()).forNoMoreThan(10).seconds(),
            Click.on(MENU_HOME),

            WaitUntil.the(CATEGORY_MENU.of(product.getCategory()), isVisible()).forNoMoreThan(10).seconds(),
            Click.on(CATEGORY_MENU.of(product.getCategory())),

            WaitUntil.the(PRODUCT.of(product.getName()), isVisible()).forNoMoreThan(10).seconds(),
            Click.on(PRODUCT.of(product.getName())),

            Click.on(ADD_TO_CART_BUTTON),

            WaitUntil.the(alertIsPresent()).forNoMoreThan(Duration.ofSeconds(10 )),
            Switch.toAlert()
        );
    }
    public static Add toCart(Product product)
    {
        return instrumented(Add.class, product);
    }


}
