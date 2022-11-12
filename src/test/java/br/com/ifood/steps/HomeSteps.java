package br.com.ifood.steps;

import br.com.ifood.pages.HomePage;

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

    @Test
    public void testeVerificarSeListaAumentaAoClicarVerMais() {

        homePage.entrarPaginaHome();

        Integer listaAntesClickProdutosOuLojas = homePage.verificarListaLojasOuItens();
        homePage.clicarBtnVerMais();
        Integer listaDepoisClickProdutosOuLojas = homePage.verificarListaLojasOuItens();

        Assert.assertNotEquals(listaAntesClickProdutosOuLojas, listaDepoisClickProdutosOuLojas);
    }

    @Test
    public void testeDeveRedirecionarParaAPaginaDaLoja() {

        homePage.entrarPaginaHome();
        homePage.clicarCardLoja();

        String tituloLoja = homePage.buscarCampoTituloLoja();
        tituloLoja.replaceAll(" ", "-");

        String urlAtual = driver.getCurrentUrl();

        Assert.assertTrue(urlAtual.contains(tituloLoja));
    }


}
