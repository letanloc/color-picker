package com.paking.team.colorpopup.modal;

/**
 * Created by fcsdev on 1/8/17.
 */

public class ColorModal {
    private String color;
    private int position ;
    private boolean isCheck;

    public ColorModal() {

    }

    public ColorModal(String color, int position, boolean isCheck) {
        this.color = color;
        this.position = position;
        this.position = position;
        this.isCheck = isCheck;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    @Override
    public String toString() {
        return "color " + color + " pos" + position + "isCheck" + isCheck;
    }
}
