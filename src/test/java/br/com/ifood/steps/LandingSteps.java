package br.com.ifood.steps;

import br.com.ifood.pages.HomePage;
import br.com.ifood.pages.LandingPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class LandingSteps extends BaseSteps{

    LandingPage landingPage = new LandingPage();

    HomePage homePage = new HomePage();

    @Test
    public void deveInformarEnderecoEscolhidoNavBar () {

        landingPage.preencherCampoEndereco();
        landingPage.clicarPrimeiroItemDaLista();
        landingPage.clicarBotaoConfirmarLocalizacao();
        landingPage.clicarSalvarEndereco();

        Assert.assertEquals("R. Uberlândia,\n" +
                "588", homePage.buscarCampoEndreco());
    }

    @Test
    public void deveInformarUsuarioParaBuscarEnderecoCasoCampoEstejaVazio() {

        String campoVazio = landingPage.buscarCampoEndereco();

        Assert.assertEquals("Buscar endereço e número", campoVazio);
    }

    @Test
    public void deveRetornarMensagemErroAoInformarEnderecoInvalido() throws InterruptedException {

        landingPage.preencherCampoEnderecoInvalido();
        String mensagemErro = landingPage.buscarCampoMensagemErroEnderecoInvalido();

        Assert.assertEquals("Verifique o nome e número do local e busque novamente", mensagemErro);
    }
}
