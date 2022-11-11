package br.com.ifood.steps;

import br.com.ifood.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;



public class HomeSteps extends BaseSteps{

    HomePage teset = new HomePage();

    @Test
    public void teste() throws InterruptedException {

        Thread.sleep(500000);
        String teste = driver.getCurrentUrl();

        Assert.assertEquals("https://www.ifood.com.br/inicio", teste);
    }
}
