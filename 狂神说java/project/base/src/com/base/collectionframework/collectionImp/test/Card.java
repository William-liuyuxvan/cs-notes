package com.base.collectionframework.collectionImp.test;

/**
 * @ClassName Cards
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/30 21:43
 */
public class Card {
    private String number; // 点数："3","4","5","6","7","8","9","10","J","Q","K","A","2"
    private String color; // 花色："♣","♦","♥","♠"
	private int size; // 数字大小

    public Card(String number, String color, int size) {
        this.number = number;
        this.color = color;
        this.size = size;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return color + number;
    }
}
