package br.com.ifood.steps;

import br.com.ifood.pages.HomePage;
import br.com.ifood.pages.NavbarPage;

import io.qameta.allure.Description;

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
        navbarPage.pressionarTeclaEnterCampoEnter();

        String ulrAtual = driver.getCurrentUrl();

        Assert.assertEquals(ulrAtual, urlBusca+produtoBuscado);
    }

    @Test(description = "Teste buscar produto inexistente.")
    @Description("Descrição Teste: Validar buscar produto inexistente redireciona para página com mensagem.")
    public void testeDeveRetornarProdutoNaoEncontrado() {

        homePage.entrarPaginaHome();

        String produtoInexistente = "nenhumproduto";
        navbarPage.preencherCampoBuscar(produtoInexistente);
        navbarPage.pressionarTeclaEnterCampoEnter();

        String msgErro = navbarPage.buscarCampoMsgErroBuscaProduto();


        Assert.assertEquals("Nenhum resultado encontrado", msgErro);
    }

    @Test(description = "Teste adicionar produto ao carrinho")
    @Description("Descrição Teste: Validar adicionar item ao carrinho .")
    public void testeDeveAdicionarItemAoCarrinho() {

        homePage.entrarPaginaHome();
        navbarPage.preencherCampoBuscar("Cerveja");
        navbarPage.pressionarTeclaEnterCampoEnter();
        navbarPage.clicarBtnBuscarPorItem();
        navbarPage.clicarNoPrimeiroItemDaLista();
        navbarPage.clicarAdicionarAoCarrinho();
        navbarPage.clicarBotaoFecharModalProduto();
        navbarPage.clicarBtnCarrinho();
        Boolean msgError = navbarPage.verificarMsgCarrinhoVazioEstaPresente();

        Assert.assertFalse(msgError);
    }

    @Test(description = "Teste carrinho vazio")
    @Description("Descrição Teste: Validar que o carrinho está vazio.")
    public void testeDeveInformarQueOCarrinhoEstaVazio() {

        homePage.entrarPaginaHome();
        navbarPage.clicarBtnCarrinho();
        String msgErro = navbarPage.buscarMesnagemCarrinhoVazio();

        Assert.assertEquals("Sua sacola está vazia", msgErro);
    }

    @Test(description = "Teste adicionar cupom inválido")
    @Description("Descrição Teste: Validar adicionar cupom inválido retorna mensagem de erro.")
    public void testeDeveInformarErroCasoDigiteCupomInvalido() throws InterruptedException {

        homePage.entrarPaginaHome();

        navbarPage.preencherCampoBuscar("Cerveja");
        navbarPage.pressionarTeclaEnterCampoEnter();
        navbarPage.clicarBtnBuscarPorItem();
        navbarPage.clicarNoPrimeiroItemDaLista();
        navbarPage.clicarAdicionarAoCarrinho();
        navbarPage.clicarBotaoFecharModalProduto();
        navbarPage.clicarBtnCarrinho();
        navbarPage.clicarBtnCupom();
        navbarPage.preencherCampoCupom("AAAA");
        navbarPage.clicarBtnAdicionarCupom();
        Thread.sleep(1000);
        String msgErro = navbarPage.buscarMsgToastCupom();

        Assert.assertEquals(msgErro, "Cupom inválido.");
    }

    @Test(description = "Teste remover produto")
    @Description("Descrição Teste: Validar remover item do carrinho com sucesso .")
    public void testeDeveRemoverProdutoDoCarrinhoComSucesso() {

        homePage.entrarPaginaHome();

        navbarPage.preencherCampoBuscar("Cerveja");
        navbarPage.pressionarTeclaEnterCampoEnter();
        navbarPage.clicarBtnBuscarPorItem();
        navbarPage.clicarNoPrimeiroItemDaLista();
        navbarPage.clicarAdicionarAoCarrinho();
        navbarPage.clicarBotaoFecharModalProduto();
        navbarPage.clicarBtnCarrinho();
        navbarPage.clicarBtnRemoverProdutoCarrinho();

        Boolean msgError = navbarPage.verificarMsgCarrinhoVazioEstaPresente();

        Assert.assertTrue(msgError);
    }
}
