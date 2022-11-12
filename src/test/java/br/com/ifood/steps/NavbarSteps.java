package br.com.ifood.steps;

import br.com.ifood.pages.HomePage;
import br.com.ifood.pages.LandingPage;
import br.com.ifood.pages.NavbarPage;
import io.qameta.allure.Description;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavbarSteps extends BaseSteps{

    NavbarPage navbarPage = new NavbarPage();

    HomePage homePage = new HomePage();

    String urlBusca = "https://www.ifood.com.br/busca?q=";

    @Test(description = "Teste buscar produto.")
    @Description("Descrição Teste: Validar buscar produto redireciona para página com lista de produtos.")
    public void testeListarProdutoOuLojaBuscada() {

        homePage.entrarPaginaHome();

        String produtoBuscado = "cerveja";
        navbarPage.preencherCampoBuscar(produtoBuscado);
        navbarPage.pressionarTeclaEnter();

        String ulrAtual = driver.getCurrentUrl();

        Assert.assertEquals(ulrAtual, urlBusca+produtoBuscado);
    }

    @Test(description = "Teste buscar produto inexistente.")
    @Description("Descrição Teste: Validar buscar produto inexistente redireciona para página com mensagem.")
    public void testeDeveRetornarProdutoNaoEncontrado() {

        homePage.entrarPaginaHome();

        String produtoInexistente = "nenhumproduto";
        navbarPage.preencherCampoBuscar(produtoInexistente);
        navbarPage.pressionarTeclaEnter();

        String msgErro = navbarPage.buscarCampoMsgErroBuscaProduto();


        Assert.assertEquals("Nenhum resultado encontrado", msgErro);
    }

    @Test(description = "Teste adicionar produto ao carrinho")
    @Description("Descrição Teste: Validar adicionar item ao carrinho .")
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
