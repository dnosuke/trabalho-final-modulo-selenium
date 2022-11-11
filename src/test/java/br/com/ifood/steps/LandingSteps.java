package br.com.Ifood.steps;

import br.com.Ifood.pages.HomePage;
import br.com.Ifood.pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;


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
