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

    public void smth(String s){}
    public void smth(Object s){}
    public void smth(Object s, String s1){}
    public void smth(String s1, Object o){}
}
