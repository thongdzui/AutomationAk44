package herokuapp;

import common.TestBase;
import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTest extends TestBase {

    ContextMenuPage contextMenuPage = new ContextMenuPage();
    @Test
    void verifyContextMenu() {
        contextMenuPage.open();
        contextMenuPage.contextMenu();

    }
}
