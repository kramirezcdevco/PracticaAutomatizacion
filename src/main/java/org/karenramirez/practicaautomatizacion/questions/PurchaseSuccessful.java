package org.karenramirez.practicaautomatizacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static org.karenramirez.practicaautomatizacion.userinterfaces.PlaceOrderPage.MESSAGE_SUCCESS_PURCHASE;

@Subject("The Purchase Is Successful")
public class PurchaseSuccessful implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor)
    {
        return MESSAGE_SUCCESS_PURCHASE.isVisibleFor(actor);
    }

    public static PurchaseSuccessful thePurchaseIsSuccessful()
    {
        return new PurchaseSuccessful();
    }
}
