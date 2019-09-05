package com.atguigu.java2;

/**
 * @author : dk
 * @date : 2019/8/12 18:11
 * @description :
 */

class Clerk1{
    private int num = 0;

    public synchronized void pro() {

        if (num<20)
        {
            num++;

            notify();
        }
        else
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }






    public synchronized void cut() {
    }
}
class Product extends Thread
{
    private Clerk1 clerk1;

    public Product(Clerk1 clerk1) {
        this.clerk1 = clerk1;
    }

    @Override
    public void run() {

        while (true)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk1.pro();
        }

    }
}
class Customer extends  Thread {
    private Clerk1 clerk1;

    public Customer(Clerk1 clerk1) {
        this.clerk1 = clerk1;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk1.cut();
        }

    }

    public static class TestClerk {
        public static void main(String[] args) {
            Clerk1 clerk1 = new Clerk1();

            Product product = new Product(clerk1);
            product.setName("s1");

            Customer customer = new Customer(clerk1);
            customer.setName("c1");

            product.start();
            customer.start();
        }

    }
}
