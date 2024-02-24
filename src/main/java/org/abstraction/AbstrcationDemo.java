package org.abstraction;

public class AbstrcationDemo {

    public static void main(String[] args) {
        GmailPage gmailPage = new GmailPage();
        GoogleMainPage googleMainPage = new GoogleMainPage();
        GoogleMapsPage googleMapsPage = new GoogleMapsPage();

        gmailPage.loadPage();
        gmailPage.openGoogleApps();
        googleMainPage.loadPage();
        googleMainPage.openGoogleApps();
        googleMapsPage.loadPage();
        googleMapsPage.openGoogleApps();


    }
}
