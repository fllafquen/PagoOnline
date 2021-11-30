package motoresdebusqueda.dogpile.pageObject;

import lombok.SneakyThrows;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class DogpilePaginaResultado extends PageObject {

    @FindBy(xpath = "//h2[contains(text(),'Crédito Hipotecario')]")
    WebElementFacade tituloResultado;

    @FindBy(id = "rc-imageselect")
    WebElementFacade captchaContainer;


    public String obtenerResultados(){
        return tituloResultado.getText();
    }

    @SneakyThrows
    public Boolean validaCaptcha(){
        Thread.sleep(2000);
        return captchaContainer.isPresent();
    }

}
