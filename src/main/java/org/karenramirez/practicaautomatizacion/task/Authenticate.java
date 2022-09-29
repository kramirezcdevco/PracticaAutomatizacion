package org.karenramirez.practicaautomatizacion.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.karenramirez.practicaautomatizacion.exceptions.AuthenticationError;
import org.karenramirez.practicaautomatizacion.model.Credentials;
import org.karenramirez.practicaautomatizacion.userinterfaces.MenuPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.karenramirez.practicaautomatizacion.exceptions.AuthenticationError.MESSAGE_FAILED_AUTHENTICATION;
import static org.karenramirez.practicaautomatizacion.userinterfaces.LoginPage.*;
import static org.karenramirez.practicaautomatizacion.userinterfaces.MenuPage.*;

public class Authenticate implements Task {

    private final Credentials credentials;

    public Authenticate(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    @Step("{0} performs an authentication")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MenuPage.MENU_LOG_IN),
                Enter.keyValues(credentials.getUsername()).into(INPUT_USERNAME),
                Enter.keyValues(credentials.getPassword()).into(INPUT_PASSWORD),
                Click.on(BUTTON_LOGIN)
        );
        actor.should(seeThat(the(MENU_LOG_OUT), isVisible()).orComplainWith(AuthenticationError.class, MESSAGE_FAILED_AUTHENTICATION));
    }

    public static Authenticate authenticate(Credentials credentials)
    {
        return instrumented(Authenticate.class, credentials);
    }
}
