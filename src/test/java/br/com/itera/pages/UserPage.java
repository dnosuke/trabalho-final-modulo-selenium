package br.com.itera.pages;

import org.openqa.selenium.By;

public class UserPage extends BasePage {

    private static final By campoNome =
            By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[1]");
    private static final By campoUltimonome =
            By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[2]");
    private static final By campoEmail =
            By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[3]");
    private static final By campoUniversidade =
            By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[4]");
    private static final By campoGenero =
            By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[5]");
    private static final By campoProfissao =
            By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[6]");
    private static final By campoIdade =
            By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[7]");
    private static final By campoEndereco =
            By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[8]");


    public String buscarCampoNome() {

        return getText(campoNome);
    }

    public String buscarCampoUltimonome() {

        return getText(campoUltimonome);
    }

    public String buscarCampoEmail() {

        return getText(campoEmail);
    }

    public String buscarCampoUniversidade() {

        return getText(campoUniversidade);
    }

    public String buscarCampoGenero() {

        return getText(campoGenero);
    }

    public String buscarCampoProfissao() {

        return getText(campoProfissao);
    }

    public String buscarCampoIdade() {

        return getText(campoIdade);
    }

    public String buscarCampoEndereco() {

        return getText(campoEndereco);
    }
}
