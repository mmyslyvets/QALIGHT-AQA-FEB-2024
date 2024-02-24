package org.abstraction;

public class GmailPage extends AbstractPage {

    public static final String URL = "https://gmail.com/";
    private final String s;


    public GmailPage() {
        super(URL);
        s = "s";
    }

    @Override
    public void openGoogleApps() {
        System.out.println("Open google apps from Gmail page");
    }
}
