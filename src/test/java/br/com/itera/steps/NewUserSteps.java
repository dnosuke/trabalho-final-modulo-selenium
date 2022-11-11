package br.com.itera.steps;

import br.com.itera.pages.MenuLateralPage;
import br.com.itera.pages.NewUserPage;
import br.com.itera.pages.UserPage;
import io.qameta.allure.Epic;
import org.junit.Assert;
import org.junit.Test;

public class NewUserSteps extends BaseSteps{

    MenuLateralPage menuLateralPage = new MenuLateralPage();
    NewUserPage newUserPage = new NewUserPage();
    UserPage userPage = new UserPage();



    @Test
    public void testeDeveCriarNovoUsuario() {

        menuLateralPage.clicarNoBotaoFormulario();
        menuLateralPage.clicarNoBotaoCriarUsuarios();

        String nome = newUserPage.preencherCampoNome();
        String ultimonome = newUserPage.preencherCampoUltimonome();
        String email = newUserPage.preencherCampoEmail();
        String endereco = newUserPage.preencherCampoEndereco();
        String universidade = newUserPage.preencherCampoUniversidade();
        String profissao = newUserPage.preencherCampoProfissao();
        String genero = newUserPage.preencherCampoGenero();
        String idade = newUserPage.preencherCampoIdade();

        newUserPage.clicarBotaoCriar();

        Assert.assertEquals("Nome: " + nome, userPage.buscarCampoNome());
        Assert.assertEquals("Ultimo Nome: " +ultimonome, userPage.buscarCampoUltimonome());
        Assert.assertEquals("Email: " +email, userPage.buscarCampoEmail());
        Assert.assertEquals("Address: " +endereco, userPage.buscarCampoEndereco());
        Assert.assertEquals("Univercidade: " +universidade, userPage.buscarCampoUniversidade());
        Assert.assertEquals("Profissão: " +profissao, userPage.buscarCampoProfissao());
        Assert.assertEquals("Gênero: " +genero, userPage.buscarCampoGenero());
        Assert.assertEquals("Idade: " +idade, userPage.buscarCampoIdade());
    }

    @Test
    public void testeDeveRetornarErroComCampoEmailVazio() {

        menuLateralPage.clicarNoBotaoFormulario();
        menuLateralPage.clicarNoBotaoCriarUsuarios();

        newUserPage.preencherCampoNome();
        newUserPage.preencherCampoUltimonome();
        newUserPage.preencherCampoEndereco();
        newUserPage.preencherCampoUniversidade();
        newUserPage.preencherCampoProfissao();
        newUserPage.preencherCampoGenero();
        newUserPage.preencherCampoIdade();

        newUserPage.clicarBotaoCriar();

        Assert.assertEquals("2 errors proibiu que este usuário fosse salvo:", newUserPage.buscarCampoError());
    }


}
