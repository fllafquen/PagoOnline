package motoresdebusqueda.dogpile.pageObject;

import lombok.SneakyThrows;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.DefaultUrl;
import org.hamcrest.core.Is;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@DefaultUrl("https://d1vvg66q5618zg.cloudfront.net/pagoexpress/")
public class DogpilePaginaPrincipal extends PageObject {

    @FindBy(xpath = "//input[@id='rut']")
    WebElementFacade cajaDeBusqueda;

    @FindBy(xpath = "//body/div[@id='root']/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")
    WebElementFacade btnBusqueda;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]")
    WebElementFacade hipotecario;

    public void ingresarPalabraClave(String rut) {
        cajaDeBusqueda.type(rut);
    }

    @SneakyThrows
    public void realizarBusqueda() {
        btnBusqueda.click();
        Thread.sleep(30000);
    }

    public void clickCreditoHipotecario() {
        hipotecario.click();
    }
}
