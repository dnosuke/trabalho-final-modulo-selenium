package br.com.ifood.steps;

import br.com.ifood.pages.HomePage;
import br.com.ifood.pages.LandingPage;
import br.com.ifood.pages.NavbarPage;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavbarSteps extends BaseSteps{

    NavbarPage navbarPage = new NavbarPage();

    HomePage homePage = new HomePage();

    String urlBusca = "https://www.ifood.com.br/busca?q=";

    @Test
    public void testeListarProdutoOuLojaBuscada() {

        homePage.entrarPaginaHome();

        String produtoBuscado = "cerveja";
        navbarPage.preencherCampoBuscar(produtoBuscado);
        navbarPage.pressionarTeclaEnter();

        String ulrAtual = driver.getCurrentUrl();

        Assert.assertEquals(ulrAtual, urlBusca+produtoBuscado);
    }

    @Test
    public void testeDeveRetornarProdutoNaoEncontrado() {

        homePage.entrarPaginaHome();

        String produtoInexistente = "nenhumproduto";
        navbarPage.preencherCampoBuscar(produtoInexistente);
        navbarPage.pressionarTeclaEnter();

        String msgErro = navbarPage.buscarCampoMsgErroBuscaProduto();


        Assert.assertEquals("Nenhum resultado encontrado", msgErro);
    }

    @Test
    public void testeDeveAdicionarItemAoCarrinho() {

        homePage.entrarPaginaHome();
        navbarPage.preencherCampoBuscar("Cerveja");
        navbarPage.pressionarTeclaEnter();
        navbarPage.clicarBtnBuscarPorItem();
        String nomeProduto = navbarPage.buscarNomePrimeiroItemDaLista();
        navbarPage.clicarNoPrimeiroItemDaLista();
        navbarPage.clicarAdicionarAoCarrinho();
        navbarPage.clicarBotaoFecharModalProduto();
        navbarPage.clicarBtnCarrinho();
        String nomeProdutoCarrinho = navbarPage.buscarPrimeiroItemListaCarrinho();

        Assert.assertEquals(nomeProdutoCarrinho, "1x "+nomeProduto);
    }
}
