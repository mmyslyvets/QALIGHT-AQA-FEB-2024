package org.collections.web.selectors;

import org.openqa.selenium.By;

public enum PageSelector {
    GOOGLE_COOKIES_BTNS(
            By.xpath("//a[contains(@href,'https://policies.google.com/technologies/cookies')]/../../../..//button")),
    GOOGLE_SEARCH_INPUT(By.name("q")),
    GOOGLE_SEARCH_HEADERS(By.xpath("//a/h3"));

    private By selector;

    PageSelector(By selector) {
        this.selector = selector;
    }


    public By getSelector() {
        return selector;
    }
}
