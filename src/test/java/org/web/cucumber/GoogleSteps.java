package org.web.cucumber;

import io.cucumber.java.en.Given;
import org.collections.web.page.GooglePage;

import static org.web.cucumber.MySteps.googlePage;

public class GoogleSteps {


    @Given("I google the {string} Page")
    public void openeFinnairPageThroughGoogle(String alias){
        googlePage.setSearchText(alias);
        googlePage.performSearch();
        googlePage.getSearchHeaders().get(0).click();
    }
}
