package br.com.itera.pages;


import org.openqa.selenium.By;

public class MenuLateralPage extends BasePage {

    private static final By btnFormulario =
            By.cssSelector("body > div.row > div.col.s3 > ul > li:nth-child(1) > a");
    private static final By btnIteracoes=
            By.cssSelector("body > div.row > div.col.s3 > ul > li:nth-child(5) > a");
    private static final By btnOutros =
            By.cssSelector("body > div.row > div.col.s3 > ul > li:nth-child(6) > a");
    private static final By btnCriarUsuarios =
            By.cssSelector("body > div.row > div.col.s3 > ul > li.bold.active > div > ul > li:nth-child(1) > a");
    private static final By btnDragAndDrop =
            By.cssSelector("body > div.row > div.col.s3 > ul > li.bold.active > div > ul > li:nth-child(1) > a");

    public void clicarNoBotaoFormulario() {

        click(btnFormulario);
    }

    public void clicarNoBotaoIteracoes() {

        click(btnIteracoes);
    }

    public void clicarNoBotaoOutros() {

        click(btnOutros);
    }

    public void clicarNoBotaoCriarUsuarios() {

        click(btnCriarUsuarios);
    }

    public void clicarNoBotaoDragAndDrop() {

        click(btnDragAndDrop);
    }
}
