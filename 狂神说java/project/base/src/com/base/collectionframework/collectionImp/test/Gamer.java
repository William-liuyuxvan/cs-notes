package com.base.collectionframework.collectionImp.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Gamer
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/30 21:43
 */
public class Gamer {
    private String name;
    private List<Card> cards = new ArrayList<>();
    private double size; // 抢地主牌的大小比较

    public Gamer(String name) {
        this.name = name;
        initSize();
    }

    public Gamer(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    private void initSize() {
        size = Math.random() ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                ", size=" + size +
                '}';
    }
}
