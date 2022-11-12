package br.com.ifood.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class NavbarPage extends BasePage {

    private static final By btnCarrinho =
            By.cssSelector("#__next > div:nth-child(1) > header > div.responsive-header__button-wrapper > button");

    private static final By msgErroCarrinhoVazio =
            By.cssSelector("body > div.drawer > div > div > div > div > div > span.restaurant-cart__empty--large");

    private static final By campoBuscarItemOuLoja =
            By.cssSelector("#__next > div:nth-child(1) > header > div.search-input > form > div > input");

    private static final By nomePrimeiroProdutoDaLista =
            By.cssSelector("div > section > section > article > section:nth-child(1) > ul > li:nth-child(1) > article > div > div > div.swiper-wrapper > div.swiper-slide.swiper-slide-active > li > div > h4");
    private static final By msgErroNenhumProduto =
            By.className("cardstack-info-card__title");

    private static final By primeiroItemDaLista =
            By.cssSelector("div > section > section > article > section:nth-child(1) > ul > li:nth-child(1) > article > div > div > div.swiper-wrapper > div");
    private static final By btnAdicionarAoCarrinho =
            By.xpath("/html/body/div[11]/div/div/div/div/section/div[2]/div[5]/div/button");

    private static final By btnFecharModalProduto =
            By.xpath("/html/body/div[11]/div/div/div/div/div[2]/div[3]/button");
    private static final By primeiroProdutoDoCarrinho =
            By.xpath("/html/body/div[12]/div/div/div/div/div/div[2]/div/div/div[2]/div/div[1]/span[1]");
    private static final By btnMudarBuscaPorItem =
            By.id("marmita-tab1-1");
    public void preencherCampoBuscar(String item) {

        sendKeys(campoBuscarItemOuLoja, item);
    }
    public void pressionarTeclaEnter() {

        WebElement campoBuscar = element(campoBuscarItemOuLoja);
        campoBuscar.sendKeys(Keys.ENTER);
    }

    public String buscarCampoMsgErroBuscaProduto() {

        return getText(msgErroNenhumProduto);
    }

    public void clicarNoPrimeiroItemDaLista() {

        click(primeiroItemDaLista);
    }

    public String buscarNomePrimeiroItemDaLista() {

        return getText(nomePrimeiroProdutoDaLista);
    }

    public String buscarPrimeiroItemListaCarrinho() {

        return getText(primeiroProdutoDoCarrinho);
    }

    public void clicarBotaoFecharModalProduto() {

        click(btnFecharModalProduto);
    }

    public void clicarAdicionarAoCarrinho() {

        click(btnAdicionarAoCarrinho);
    }

    public void clicarBtnCarrinho() {

        click(btnCarrinho);
    }

    public void clicarBtnBuscarPorItem() {

        click(btnMudarBuscaPorItem);
    }
}
