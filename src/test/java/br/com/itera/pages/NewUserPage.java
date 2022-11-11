package br.com.itera.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import java.util.Locale;
import java.util.Random;

public class NewUserPage extends BasePage{

    Faker faker = new Faker(Locale.of("pt-br"));

    private static final By campoNome =
            By.id("user_name");
    private static final By campoUltimonome =
            By.id("user_lastname");
    private static final By campoEmail =
            By.id("user_email");
    private static final By campoEndereco =
            By.id("user_address");
    private static final By campoUniversidade =
            By.id("user_university");
    private static final By campoProfissao =
            By.id("user_profile");
    private static final By campoGenero =
            By.id("user_gender");
    private static final By campoIdade =
            By.id("user_age");
    private static final By campoError =
            By.cssSelector("#error_explanation > h2");

    private static final By btnCriar =
            By.cssSelector("#new_user > div:nth-child(7) > div > div > input[type=submit]");


    public String preencherCampoNome() {

        String nome = faker.name().firstName();
        sendKeys(campoNome, nome);

        return nome;
    }

    public String preencherCampoUltimonome() {

        String ultimoNome = faker.name().lastName();
        sendKeys(campoUltimonome, ultimoNome);

        return ultimoNome;
    }

    public String preencherCampoEmail() {

        String email = faker.internet().emailAddress();
        sendKeys(campoEmail, email);

        return email;
    }

    public String preencherCampoEndereco() {

        String endereco = faker.address().fullAddress();
        sendKeys(campoEndereco, endereco);

        return endereco;
    }

    public String preencherCampoUniversidade() {

        String universidade = faker.university().name();
        sendKeys(campoUniversidade, universidade);

        return universidade;
    }

    public String preencherCampoProfissao() {

        String profissao = faker.job().field();
        sendKeys(campoProfissao, profissao);

        return profissao;
    }

    public String preencherCampoGenero() {

        Random random = new Random();
        String gender = "";
        int x = random.nextInt(2);

        if(x == 0) {
            gender = "Masculino";
        } else {
            gender = "Feminino";
        }

        sendKeys(campoGenero, gender);

        return gender;
    }

    public String preencherCampoIdade() {

        String idade = String.valueOf(faker.number().numberBetween(18, 100));
        sendKeys(campoIdade, idade);

        return idade;
    }

    public String buscarCampoError() {

        String error = getText(campoError);

        return error;
    }

    public void clicarBotaoCriar() {

        click(btnCriar);
    }
}
