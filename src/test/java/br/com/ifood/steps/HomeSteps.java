package br.com.ifood.steps;

import br.com.ifood.pages.HomePage;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeSteps extends BaseSteps {

    HomePage homePage = new HomePage();


    @Test
    public void testeVerificarImagemTrocaDeTamanho() {

        homePage.entrarPaginaHome();
        homePage.hoverBigBannerImage();

        Assert.assertNotEquals("none", homePage.pegarTamanhoBannerImage());
    }

    @Test
    public void testeVerficarQuartoBannerEstaAtivo() {

        homePage.entrarPaginaHome();
        homePage.mudarParaQuartoElementoCarrosselBanner();

        Assert.assertEquals("swiper-slide swiper-slide-active", homePage.verificarClasseQuartoBanner());
    }

    @Test
    public void testeVerificarBotaoSwipeDisabledCasoAListaAcabe() {

        homePage.entrarPaginaHome();

        Assert.assertEquals("swiper-button-prev swiper-button-disabled", homePage.retonarEstadoBotaoEsquerdo());

        homePage.clicarCincoVezesBotaoDireito();

        Assert.assertEquals("swiper-button-next swiper-button-disabled", homePage.retonarEstadoBotaoDireito());
    }

    @Test(description = "Teste clicar botão 'Ver mais' da lista Lojas.")
    @Description("Descrição Teste: Validar clicar no botão 'Ver mais' carrega mais itens a lista de Lojas na home.")
    public void testeVerificarSeListaAumentaAoClicarVerMais() {

        homePage.entrarPaginaHome();

        Integer listaAntesClickProdutosOuLojas = homePage.verificarListaLojasOuItens();
        homePage.clicarBtnVerMais();
        Integer listaDepoisClickProdutosOuLojas = homePage.verificarListaLojasOuItens();

        Assert.assertNotEquals(listaAntesClickProdutosOuLojas, listaDepoisClickProdutosOuLojas);
    }

    @Test(description = "Teste redirecionar para página da Loja.")
    @Description("Descrição Teste: Validar clicar numa loja da lista Lojas redireciona para página com detalhes da loja.")
    public void testeDeveRedirecionarParaAPaginaDaLoja() {

        homePage.entrarPaginaHome();
        homePage.clicarCardLoja();

        String tituloLoja = homePage.buscarCampoTituloLoja();
        tituloLoja.replaceAll(" ", "-");

        String urlAtual = driver.getCurrentUrl();

        Assert.assertTrue(urlAtual.contains(tituloLoja));
    }


}
