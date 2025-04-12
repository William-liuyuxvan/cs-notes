package com.base.thread.four;

/**
 * @ClassName ThreadBankSynchronized
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/4/12 17:39
 */
public class ThreadBankSynchronized {
    public static void main(String[] args) {
        Account account = new Account("基金", 100);

        new Bank(account, 50, "男生").start();
        new Bank(account, 100, "女生").start();
    }
}

class Account {
    private String accountName;
    private int money;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Account(String accountName, int money) {
        this.accountName = accountName;
        this.money = money;
    }
}

class Bank extends Thread {

    private Account account; // 取钱账户
    private int drawingMoney; // 取钱数
    private int nowMoney; // 手里的钱数

    public Bank(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {

        synchronized (account) {
            if (account.getMoney() - drawingMoney < 0) {
                System.out.println(account.getAccountName() + "账户没有那么多钱");
                return;
            }

            nowMoney += drawingMoney;
            account.setMoney(account.getMoney() - drawingMoney);
        }

        System.out.println(this.getName() + "取走：" + drawingMoney);
        System.out.println(this.getName() + "手上有：" + nowMoney);

        System.out.println(account.getAccountName() + "还剩" + account.getMoney());
    }
}
