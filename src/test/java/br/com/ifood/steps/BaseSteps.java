package br.com.Ifood.steps;


import br.com.Ifood.util.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseSteps extends Browser {

    @BeforeTest
    public void abrirNavegador() {
        browserUp("https://www.ifood.com.br/inicio");
    }

    @AfterTest
    public void fecharNavegador() {
        browserDown();
    }

}