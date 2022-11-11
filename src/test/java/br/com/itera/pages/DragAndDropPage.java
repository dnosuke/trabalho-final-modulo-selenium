package br.com.itera.pages;
;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class DragAndDropPage extends BasePage {

    private static final By image =
            By.id("winston");

    private static final By dropZone =
            By.id("dropzone");
    public void dragImage() {
        Actions action = new Actions(driver);

        action.dragAndDrop(element(image), element(dropZone)).perform();
    }

    public String verificarDragImage() {

        return getStyleAttributeText(dropZone);
    }
}
