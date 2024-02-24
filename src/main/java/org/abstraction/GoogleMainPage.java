package org.abstraction;

public class GoogleMainPage extends AbstractPage {

    public static final String URL = "https://google.com/";

    public GoogleMainPage() {
        super(URL);
    }


    @Override
    public void openGoogleApps() {
        System.out.println("Open google apps from Main page");
    }
}
