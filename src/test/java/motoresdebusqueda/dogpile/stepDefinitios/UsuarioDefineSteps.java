package motoresdebusqueda.dogpile.stepDefinitios;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import motoresdebusqueda.dogpile.steps.UsuarioDogpile;

public class UsuarioDefineSteps {

    @Steps(shared = true)
    UsuarioDogpile actor;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^Que (.*) entra en pago online Coopeuch$")
    public void ingresar_a_dogpile(String nombreUsuario) {
        actor.isCalled(nombreUsuario);
        actor.ingresarAPagoOnline();
    }

    @Cuando("^(.*) ingresa rut: (.*)$")
    public void busca_por_palabra_clave(String nombreUsuario, String palabraClave) {
        actor.isCalled(nombreUsuario);
        actor.ingresaRut(palabraClave);
    }

    @Y("^(.*) hace click en credito hipotecario$")
    public void click_a_credito_hipotecario(String nombreUsuario) {
        actor.isCalled(nombreUsuario);
        actor.clickACreditoHipotecario();
    }

    @Entonces("^(.*) deberia poder ver el container de Captcha$")
    public void deberia_ver_resultados_con_palabra(String nombreUsuario) {
        actor.isCalled(nombreUsuario);
        actor.deberiaVerCaptcha();
    }
}
