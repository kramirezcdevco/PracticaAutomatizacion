package org.karenramirez.practicaautomatizacion.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.karenramirez.practicaautomatizacion.userinterfaces.DemoBlazeHomePage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.karenramirez.practicaautomatizacion.userinterfaces.DemoBlazeHomePage.MENU_LOG_IN;

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
                Click.on(MENU_LOG_IN)
                //authenticateWithUsername("admin").andPassword("****")
        );
        throw new io.cucumber.java.PendingException();
    }

    @Given("^add from (.*) [a-z]{1,2} (.*)$")
    public void addToCart(String category, String product) {
        theActorInTheSpotlight().wasAbleTo(

        );
        throw new io.cucumber.java.PendingException();
    }

    @When("^[a-zA-Z]{3,40} makes the purchase$")
    public void Purchase() {
        throw new io.cucumber.java.PendingException();
    }
    @Then("should see the message Thank you for your purchase")
    public void shouldSeeTheMessageThankYouForYourPurchase() {
        throw new io.cucumber.java.PendingException();
    }

}
