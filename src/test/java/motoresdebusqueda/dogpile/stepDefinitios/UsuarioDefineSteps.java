package motoresdebusqueda.dogpile.stepDefinitios;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
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

    @Dado("^Que (.*) entra en dogpile$")
    public void ingresar_a_dogpile(String nombreUsuario) {
        actor.isCalled(nombreUsuario);
        actor.ingresarADdogpile();
    }

    @Cuando("^(.*) realiza una busqueda de: (.*)$")
    public void busca_por_palabra_clave(String nombreUsuario, String palabraClave) {
        actor.isCalled(nombreUsuario);
        actor.buscaPorPalabraClave(palabraClave);
    }

    @Entonces("^(.*) deberia poder ver resultados que contengan la palabra: (.*)$")
    public void deberia_ver_resultados_con_palabra(String nombreUsuario, String palabraEsperada) {
        actor.isCalled(nombreUsuario);
        actor.deberiaVerResultadosConPalabra(palabraEsperada);
    }

    @Entonces("^(.*) deberia ver un texto: (.*) relevante con el titulo: (.*)$")
    public void deberia_ver_resultado_titulo_con_texto_correcto(String nombreUsuario, String textoDeResultado, String tituloDeResultado) {
        actor.isCalled(nombreUsuario);
        actor.deberiaVerResultadoTituloConTextoCorrecto(textoDeResultado, tituloDeResultado);
    }
}
