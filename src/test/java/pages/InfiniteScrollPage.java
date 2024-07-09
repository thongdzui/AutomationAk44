package pages;

import supports.Browser;

public class InfiniteScrollPage {
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/infinite_scroll");
    }
    public void infiniteScroll() throws InterruptedException {
        Browser.infiniteScroll();
    }
}
