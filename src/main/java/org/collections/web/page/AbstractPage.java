package org.collections.web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected final WebDriver driver;
    private final String url;

    protected AbstractPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public void loadPage() {
        driver.get(url);
    }

    public boolean isPageLoaded(String partialUrl) {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.urlContains(partialUrl));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void navigateBack() {
        driver.navigate().back();
    }
}
