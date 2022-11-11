package br.com.ifood.pages;

import org.openqa.selenium.By;
public class HomePage extends BasePage {

    private static final By campoEndereco =
            By.cssSelector("#__next > div:nth-child(1) > header > button");

    public String buscarCampoEndreco() {

        return getText(campoEndereco);
    }
}
