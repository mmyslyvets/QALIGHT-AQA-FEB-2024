package org.collections.web.page;

import org.openqa.selenium.WebDriver;

public class WikiPage extends AbstractPage {

    public final static String WIKI_URL = "https://www.wikipedia.org/";

    public WikiPage(WebDriver driver) {
        super(driver, WIKI_URL);
    }
}
