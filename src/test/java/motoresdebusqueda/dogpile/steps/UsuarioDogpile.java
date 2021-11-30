package motoresdebusqueda.dogpile.steps;

import io.cucumber.java.Before;
import motoresdebusqueda.dogpile.pageObject.DogpilePaginaPrincipal;
import motoresdebusqueda.dogpile.pageObject.DogpilePaginaResultado;
import net.serenitybdd.core.steps.ScenarioActor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class UsuarioDogpile extends ScenarioActor {

    @Steps(shared = true)
    DogpilePaginaPrincipal paginaPrincipal;

    @Steps(shared = true)
    DogpilePaginaResultado paginaResultado;



    @Step("#actor ingresa a la pagina principal de pago online Coopeuch")
    public void ingresarAPagoOnline() {
        paginaPrincipal.setDefaultBaseUrl("https://d1vvg66q5618zg.cloudfront.net/pagoexpress/");
        paginaPrincipal.open();
    }

    @Step("#actor realiza una busqueda de: {0}")
    public void ingresaRut(String palabraClave) {
        paginaPrincipal.ingresarPalabraClave(palabraClave);
        paginaPrincipal.realizarBusqueda();

    }

    @Step("#actor realiza una busqueda de: {0}")
    public void clickACreditoHipotecario() {
        paginaPrincipal.clickCreditoHipotecario();
    }

    @Step("#actor deberia poder ver resultados que contenga el container de Captcha")
    public void deberiaVerCaptcha() {
        Boolean resultado = paginaResultado.validaCaptcha();
        assertThat(resultado, Matchers.equalTo(false));

    }
}
