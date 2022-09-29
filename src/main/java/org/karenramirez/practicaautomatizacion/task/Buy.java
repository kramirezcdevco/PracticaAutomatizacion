package org.karenramirez.practicaautomatizacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.karenramirez.practicaautomatizacion.model.Purchaser;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.karenramirez.practicaautomatizacion.model.Purchaser.PURCHASER_INFORMATION;
import static org.karenramirez.practicaautomatizacion.userinterfaces.CartPage.BUTTON_PLACE_ORDER;
import static org.karenramirez.practicaautomatizacion.userinterfaces.MenuPage.MENU_CART;
import static org.karenramirez.practicaautomatizacion.userinterfaces.PlaceOrderPage.*;

public class Buy implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Purchaser purchaser = actor.recall(PURCHASER_INFORMATION);
        actor.attemptsTo(
                Click.on(MENU_CART),

                WaitUntil.the(BUTTON_PLACE_ORDER, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BUTTON_PLACE_ORDER),

                WaitUntil.the(INPUT_NAME, isVisible()).forNoMoreThan(10).seconds(),

                Enter.theValue(purchaser.getName()).into(INPUT_NAME),
                Enter.theValue(purchaser.getCountry()).into(INPUT_COUNTRY),
                Enter.theValue(purchaser.getCity()).into(INPUT_CITY),
                Enter.theValue(purchaser.getCard()).into(INPUT_CARD),
                Enter.theValue(purchaser.getMonth()).into(INPUT_MONTH),
                Enter.theValue(purchaser.getYear()).into(INPUT_YEAR),

                Click.on(BUTTON_PURCHASE)
        );
    }

    public static Buy buy()
    {
        return instrumented(Buy.class);
    }
}
