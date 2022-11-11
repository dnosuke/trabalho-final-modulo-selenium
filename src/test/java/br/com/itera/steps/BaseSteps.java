package br.com.itera.steps;

import br.com.itera.util.Browser;
import org.junit.After;
import org.junit.Before;

public class BaseSteps extends Browser {

    @Before
    public void abrirNavegador() {
        browserUp("https://automacaocombatista.herokuapp.com/treinamento/home");
    }

    @After
    public void fecharNavegador() {
        browserDown();
    }
}