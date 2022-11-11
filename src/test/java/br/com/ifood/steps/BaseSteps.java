package br.com.ifood.steps;

import br.com.ifood.util.Browser;
import org.junit.After;
import org.junit.Before;

public class BaseSteps extends Browser {

    @Before
    public void abrirNavegador() {
        browserUp("https://www.ifood.com.br/inicio");
    }

    @After
    public void fecharNavegador() {
        browserDown();
    }
}