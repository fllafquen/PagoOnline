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



    @Step("#actor ingresa a la pagina principal de dogpile")
    public void ingresarADdogpile() {
        paginaPrincipal.setDefaultBaseUrl("https://www.dogpile.com/");
        paginaPrincipal.open();
    }

    @Step("#actor realiza una busqueda de: {0}")
    public void buscaPorPalabraClave(String palabraClave) {
        paginaPrincipal.ingresarPalabraClave(palabraClave);
        paginaPrincipal.realizarBusqueda();
    }

    @Step("#actor deberia poder ver resultados que contengan la palabra: {0}")
    public void deberiaVerResultadosConPalabra(String palabraEsperada) {
        List<String> resultados = paginaResultado.obtenerResultados();
        resultados.replaceAll(String::toLowerCase);

        for(int i=0; i< resultados.size();i++){
            System.out.println(resultados.get(i));
        }

        assertThat(resultados, Matchers.everyItem(Matchers.containsString(palabraEsperada)));
    }

    @Step("#actor deberia ver un texto: {0} relevante con el titulo: {1}")
    public void deberiaVerResultadoTituloConTextoCorrecto(String textoDeResultado, String tituloDeResultado) {
        String texto = paginaResultado.obtenerTextoDeTituloResultado(tituloDeResultado);
        System.out.println(texto);
        assertThat(texto, Matchers.containsString(textoDeResultado));
    }
}
