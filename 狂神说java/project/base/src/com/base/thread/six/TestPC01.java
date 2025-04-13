package com.base.thread.six;

/**
 * @ClassName TestPC
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/13 12:57
 */
public class TestPC01 {

    public static void main(String[] args) {
        SynProduct synProduct = new SynProduct();

        new Thread(new Producer(synProduct)).start();
        new Thread(new Consumer(synProduct)).start();
    }
}


class SynProduct {

    private Product[] products;
    private int length;

    public SynProduct() {
        init();
    }

    private void init() {
        this.products = new Product[10];
        this.length = 0;
    }

    // 添加商品
    public synchronized void addProduct(Product product) {
        while (this.length >= this.products.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.products[length++] = product;

        this.notifyAll();
    }

    public synchronized Product getProduct() {
        while (this.length == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Product product = this.products[--length];

        this.notifyAll();

        return product;
    }


}

class Producer implements Runnable {

    private final SynProduct synProduct;

    public Producer(SynProduct synProduct) {
        this.synProduct = synProduct;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synProduct.addProduct(new Product(i));
            System.out.println("生产了：" + i + "个产品");
        }
    }
}

class Consumer implements Runnable {

    private final SynProduct synProduct;

    Consumer(SynProduct synProduct) {
        this.synProduct = synProduct;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("消费了第 " + synProduct.getProduct().getId());
        }
    }
}

class Product {

    private int id;

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
