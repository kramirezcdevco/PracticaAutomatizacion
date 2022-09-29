package org.karenramirez.practicaautomatizacion.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.karenramirez.practicaautomatizacion.model.Product;
import org.karenramirez.practicaautomatizacion.model.Purchaser;
import org.karenramirez.practicaautomatizacion.task.Add;
import org.karenramirez.practicaautomatizacion.userinterfaces.DemoBlazeHomePage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.karenramirez.practicaautomatizacion.model.Purchaser.PURCHASER_INFORMATION;
import static org.karenramirez.practicaautomatizacion.model.PurchaserFactory.createByName;
import static org.karenramirez.practicaautomatizacion.questions.PurchaseSuccessful.thePurchaseIsSuccessful;
import static org.karenramirez.practicaautomatizacion.task.Authenticate.authenticate;
import static org.karenramirez.practicaautomatizacion.task.Buy.buy;
import static org.karenramirez.practicaautomatizacion.userinterfaces.MenuPage.MENU_LOG_OUT;
import static org.karenramirez.practicaautomatizacion.userinterfaces.PlaceOrderPage.*;

public class PurchaseStepDefinitions {

    private DemoBlazeHomePage homePage;
    private Purchaser aPurchaser;
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is authenticated$")
    public void Authenticate(String actorName) {
        aPurchaser = createByName(actorName);
        theActorCalled(aPurchaser.getName()).attemptsTo(
                Open.browserOn(homePage),
                authenticate(aPurchaser.getCredentials())
        );
        theActorInTheSpotlight().remember(PURCHASER_INFORMATION,aPurchaser);
    }

    @Given("^add from (.*) [a-z]{1,2} (.*)$")
    public void addToCart(String category, String product) {

        Product aProduct = Product.builder().category(category).name(product).build();

        theActorInTheSpotlight().wasAbleTo(
                Add.toCart(aProduct)
        );
    }

    @When("^[a-zA-Z]{3,40} makes the purchase$")
    public void Purchase() {
        theActorInTheSpotlight().attemptsTo(
                buy()
        );

    }

    @Then("should see the message Thank you for your purchase")
    public void shouldSeeTheMessageThankYouForYourPurchase() {
        theActorInTheSpotlight().should(seeThat(the(MENU_LOG_OUT), isVisible()));
        theActorInTheSpotlight().should(seeThat(thePurchaseIsSuccessful()));
        theActorInTheSpotlight().wasAbleTo(
                Click.on(BUTTON_VALIDATE)
        );
    }
}
