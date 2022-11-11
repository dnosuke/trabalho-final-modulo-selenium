package br.com.ifood.steps;

import br.com.ifood.pages.HomePage;
import br.com.ifood.util.ListenersTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.Listeners;


@Listeners(ListenersTest.class)
public class HomeSteps extends BaseSteps{

    HomePage teset = new HomePage();

    @Test
    public void teste(){

        String teste = driver.getCurrentUrl();

        Assert.assertEquals("https://www.ifood.com.br/inicio", teste);
    }
}
