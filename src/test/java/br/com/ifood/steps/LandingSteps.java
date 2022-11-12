package br.com.ifood.steps;

import br.com.ifood.pages.HomePage;
import br.com.ifood.pages.LandingPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Landing Teste")
public class LandingSteps extends BaseSteps{
    LandingPage landingPage = new LandingPage();

    HomePage homePage = new HomePage();

    @Test(description = "Teste com endereço válido.")
    @Description("Descrição Teste: Validar exibir endereço correto após preencher com endereço válido.")
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

    @Test(description = "Teste com endereço inválido.")
    @Description("Descrição Teste: Validar preencher com endereço inválido exibe mensagem de erro.")
    public void deveRetornarMensagemErroAoInformarEnderecoInvalido() {
        landingPage.preencherCampoEnderecoInvalido();
        String mensagemErro = landingPage.buscarCampoMensagemErroEnderecoInvalido();

        Assert.assertEquals("Verifique o nome e número do local e busque novamente", mensagemErro);
    }


    @Test
    public void devePedirNumeroDoEnderecoCasoNaoSejaInformado() {

        landingPage.preencherEnderecoSemNumero();
        landingPage.clicarPrimeiroItemDaLista();
        String msg = landingPage.buscarCampoErrorEnderecoSemNumero();

        Assert.assertEquals("Você não informou o número de endereço", msg);

    }

    @Test
    public void deveDesabilitarBtnSalvarEnderecoCasoNumeroNaoSejaInformado() {

        landingPage.preencherEnderecoSemNumero();
        landingPage.clicarPrimeiroItemDaLista();

        String btnBuscarEnderecoDisabled = landingPage.verificarBtnEstaDesabilitado();

        Assert.assertEquals("true", btnBuscarEnderecoDisabled);
    }

    @Test
    public void deveExiberMensagemErroCasoUsuarioInformeLetrasNoCampoNumero() {

        landingPage.preencherEnderecoSemNumero();
        landingPage.clicarPrimeiroItemDaLista();
        landingPage.preencherCampoNumeroComLetras();

        String btnBuscarEnderecoDisabled = landingPage.verificarBtnEstaDesabilitado();

        Assert.assertEquals("true", btnBuscarEnderecoDisabled);
    }
}
