package br.com.itera.steps;

import br.com.itera.pages.DragAndDropPage;
import br.com.itera.pages.MenuLateralPage;
import org.junit.Assert;
import org.junit.Test;

public class DragDropSteps extends BaseSteps {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();
    MenuLateralPage menuLateralPage = new MenuLateralPage();

    @Test
    public void draganddrop() {

        menuLateralPage.clicarNoBotaoIteracoes();
        menuLateralPage.clicarNoBotaoDragAndDrop();

        dragAndDropPage.dragImage();


        Assert.assertEquals("background: rgb(0, 200, 0);", dragAndDropPage.verificarDragImage());
    }
}
