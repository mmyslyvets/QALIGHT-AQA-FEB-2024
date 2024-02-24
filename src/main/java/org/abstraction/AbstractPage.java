package org.abstraction;

public abstract class AbstractPage {

    protected String url;

    public AbstractPage(String url) {
        this.url = url;
    }

    public abstract void openGoogleApps();

    public void refreshPage() {

    }

    public final void loadPage() {
        System.out.println("Loading " + url);
    }
}
