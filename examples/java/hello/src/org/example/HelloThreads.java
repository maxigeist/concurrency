package org.example;


import java.util.ArrayList;

public class HelloThreads {
    private static void hello() throws InterruptedException {
        var t1 = new Thread(() -> System.out.println("Hello from thread 1"));
        var t2 = new Thread(() -> System.out.println("Hello from thread 2"));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void nThreads(int number) throws InterruptedException {
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < number; i++) {
            threads.add(new Thread(() -> System.out.println("Hello from thread " + Thread.currentThread().getId())));
        }

        for (Thread thread: threads){
            thread.start();
        }
        for (Thread thread: threads) {
            thread.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("====== Hello Threads    =======");
        nThreads(10);

//        hello();
        System.out.println("====== Good Bye Threads =======");
    }
}