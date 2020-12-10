package motoresdebusqueda.dogpile.pageObject;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

public class DogpilePaginaResultado extends PageObject {

    public static final String TITULO_RESULTADO = "a.web-bing__title";
    public static final String DESCRIPCION_DE_TEXTO = "..//span[contains(@class,'web-bing__description')]";
    public static final String DESCRIPCION_DE_TITULO = "//a[contains(@class, 'web-bing__title') and contains(.,'{0}')]";

    public List<String> obtenerResultados(){

        return findAll(TITULO_RESULTADO)
                .stream()
                .map(element -> element.getAttribute("textContext"))
                .collect(Collectors.toList());
    }

    public String obtenerTextoDeTituloResultado(String tituloDeResultado) {

        return findBy(DESCRIPCION_DE_TITULO, tituloDeResultado)
                .then().findBy(DESCRIPCION_DE_TEXTO)
                .then().getText();
    }
}
