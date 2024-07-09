package herokuapp;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InfiniteScrollPage;
import supports.Browser;

public class InfiniteScrollTest extends TestBase {

    @Test
    void TC_01_InfiniteScroll() throws InterruptedException {
        InfiniteScrollPage infiniteScrollPage = new InfiniteScrollPage();
        infiniteScrollPage.open();
        infiniteScrollPage.infiniteScroll();
    }
}
