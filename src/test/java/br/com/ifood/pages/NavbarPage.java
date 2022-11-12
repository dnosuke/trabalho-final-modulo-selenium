package br.com.ifood.pages;

import org.openqa.selenium.By;

public class NavbarPage extends BasePage {

    private static final By btnCarrinho =
            By.cssSelector("#__next > div:nth-child(1) > header > div.responsive-header__button-wrapper > button");

    private static final By msgErroCarrinhoVazio =
            By.cssSelector("body > div.drawer > div > div > div > div > div > span.restaurant-cart__empty--large");

    
}
