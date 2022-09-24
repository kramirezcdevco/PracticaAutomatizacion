package org.karenramirez.practicaautomatizacion.runner;

import com.ibm.icu.impl.ICUCurrencyMetaInfo;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/purchase.feature",
        glue = {"org.karenramirez.practicaautomatizacion.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class PurchaseRunner {

}
