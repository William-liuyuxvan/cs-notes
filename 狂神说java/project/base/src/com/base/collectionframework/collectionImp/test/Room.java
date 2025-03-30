package com.base.collectionframework.collectionImp.test;

import java.util.*;

/**
 * @ClassName Room
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/3/30 21:43
 */
public class Room {
    private static final List<Card> cardList = new ArrayList<>();
    private static final Gamer[] gamers = new Gamer[3];

    static {
        // 在启动游戏房间的时候，应该提前准备好54张牌
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors = {"♣","♦","♥","♠"};
        int size = 0; // 初始化比较大小

        for (String number : numbers) {
            size++;
            for (String color : colors) {
                Card card = new Card(number, color, size);
                cardList.add(card);
            }
        }

        // 添加大小王  按照大小顺序 先添加小王 再添加大王  小写joker表示小王，大写JOKER表示大王
        cardList.add(new Card("", "joker", ++size));
        cardList.add(new Card("", "JOKER", ++size));
        System.out.println("牌数：" + cardList.size());
        System.out.println("洗牌前：" + cardList);

        // 洗牌
        Collections.shuffle(cardList);
        System.out.println("洗牌后：" + cardList);

        // 发牌
        for (int i = 0; i < gamers.length; i++) {
            gamers[i] = new Gamer("gamer" + 1);
        }

        // 注解来抑制类型安全警告，因为这种强制转换在运行时是安全的，但编译器会发出警告。
        @SuppressWarnings("unchecked")
        List<Card>[] cards = (List<Card>[]) new ArrayList[3];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new ArrayList<>();
        }

        for (int i = 0; i < cardList.size() - 3; i++) {
            if (i % 3 == 0) {
                cards[0].add(cardList.get(i));
            } else if (i % 3 == 1) {
                cards[1].add(cardList.get(i));
            } else {
                cards[2].add(cardList.get(i));
            }
        }

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("抢地主前：");
        for (int i = 0; i < cards.length; i++) {
            System.out.println("玩家" + (i + 1) + ": " + cards[i] + " 牌数：" + cards[i].size());
        }

        // 抢地主牌
        double size1 = gamers[0].getSize();
        double size2 = gamers[1].getSize();
        double size3 = gamers[2].getSize();
        List<Card> lastThreeCards = cardList.subList(cardList.size() - 3, cardList.size()); // 地主牌
        if (size1 > size2 && size1 > size3) {
            cards[0].addAll(lastThreeCards);
        } else if (size2 > size1 && size2 > size3) {
            cards[1].addAll(lastThreeCards);
        } else if (size3 > size1 && size3 > size2) {
            cards[2].addAll(lastThreeCards);
        }

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("抢地主后：");
        for (int i = 0; i < cards.length; i++) {
            System.out.println("玩家" + (i + 1) + ": " + cards[i] + " 牌数：" + cards[i].size());
        }


        // 对牌排序
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("排序后：");
        for (int i = 0; i < cards.length; i++) {
            cards[i].sort((o1, o2) -> o1.getSize() - o2.getSize());
            gamers[i].setCards(cards[i]);
            // 看牌
            System.out.println("玩家" + (i + 1) + ": " + gamers[i].getCards() + " 牌数：" + gamers[i].getCards().size());
        }
    }

    public Room() {}
}
