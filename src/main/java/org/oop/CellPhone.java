package org.oop;

public class CellPhone {

    String color = "green";

    public void acceptCall() {
        pressAcceptCallButton();
        talkToCaller();
    }

    private void pressAcceptCallButton() {
        System.out.println("Pressing pick up button");
    }

    private void talkToCaller() {
        System.out.println("Talking");
    }

    public boolean checkColor(String color) {
        System.out.println(this.color.equals(color));
        return this.color.equals(color);
    }

    public void setColor(String color) {
        if (color == null) {
            System.out.println("Color cannot be null");
        } else {
            this.color = color;
        }
    }

    public String getColor() {
        return color;
    }
}
