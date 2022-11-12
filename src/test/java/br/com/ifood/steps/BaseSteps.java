package br.com.ifood.steps;

import br.com.ifood.util.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseSteps extends Browser {

    @BeforeMethod
    public void abrirNavegador() {
        browserUp("https://www.ifood.com.br/inicio");
    }

    @AfterMethod
    public void fecharNavegador() {
        browserDown();
    }

}