package org.karenramirez.practicaautomatizacion.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.karenramirez.practicaautomatizacion.userinterfaces.DemoBlazeHomePage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.karenramirez.practicaautomatizacion.userinterfaces.CartPage.*;
import static org.karenramirez.practicaautomatizacion.userinterfaces.CategoriesPage.*;
import static org.karenramirez.practicaautomatizacion.userinterfaces.DemoBlazeHomePage.*;
import static org.karenramirez.practicaautomatizacion.userinterfaces.LaptopsPage.*;
import static org.karenramirez.practicaautomatizacion.userinterfaces.LoginPage.*;
import static org.karenramirez.practicaautomatizacion.userinterfaces.PlaceOrderPage.*;

public class PurchaseStepDefinitions {

    private DemoBlazeHomePage homePage;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is authenticated$")
    public void Authenticate(String actorName) {

        theActorCalled(actorName).attemptsTo(
                Open.browserOn(homePage),
                Click.on(MENU_LOG_IN),
                Enter.keyValues("admin").into(INPUT_USERNAME),
                Enter.keyValues("admin").into(INPUT_PASSWORD),
                Click.on(BUTTON_LOGIN)
        );
    }

    @Given("^add from (.*) [a-z]{1,2} (.*)$")
    public void addToCart(String category, String product) {
        theActorInTheSpotlight().wasAbleTo(
                Click.on(CATEGORY_LAPTOP),
                Click.on(LAPTOP_MACBOOK)
        );
        throw new io.cucumber.java.PendingException();
    }

    @When("^[a-zA-Z]{3,40} makes the purchase$")
    public void Purchase() {
        theActorInTheSpotlight().wasAbleTo(
                Click.on(MENU_CART),
                Click.on(BUTTON_PLACE_ORDER),
                Enter.keyValues("Juan").into(INPUT_NAME),
                Enter.keyValues("Colombia").into(INPUT_COUNTRY),
                Enter.keyValues("Medellin").into(INPUT_CITY),
                Enter.keyValues("123456789").into(INPUT_CARD),
                Enter.keyValues("05").into(INPUT_MONTH),
                Enter.keyValues("25").into(INPUT_YEAR),
                Click.on(BUTTON_PURCHASE)
        );
    }
    @Then("should see the message Thank you for your purchase")
    public void shouldSeeTheMessageThankYouForYourPurchase() {
        theActorInTheSpotlight().wasAbleTo(
                Click.on(BUTTON_VALIDATE)
        );
    }

}
