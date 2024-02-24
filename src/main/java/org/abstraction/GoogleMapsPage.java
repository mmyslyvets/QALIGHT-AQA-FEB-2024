package org.abstraction;

public final class GoogleMapsPage extends AbstractPage {

    public static final String URL = "https://maps.google.com/";

    public GoogleMapsPage() {
        super(URL);
    }

    @Override
    public void openGoogleApps() {
        System.out.println("Open google apps from Maps page");
    }
}
