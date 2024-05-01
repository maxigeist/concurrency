package org.example;



import java.util.ArrayList;
import java.util.Arrays;

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
    private static class Counter {
        private int value = 0;

        public void increment() {
            int temp = value;  // Read current value
            value = temp + 1;  // Modify the value
        }

        public int getValue() {
            return value;
        }
    }
    public static void startAll(Thread... threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void joinAll(Thread... threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("====== Hello Threads    =======");
//        nThreads(10);
//
////        hello();
//        System.out.println("====== Good Bye Threads =======");
        var counter = new Counter();

        // Two threads trying to increment the counter simultaneously
        Thread t1 = new Thread(counter::increment, "Thread 1");
        Thread t2 = new Thread(counter::increment, "Thread 2");
        Thread t3 = new Thread(counter::increment, "Thread 2");
        Thread t4 = new Thread(counter::increment, "Thread 2");
        Thread t5 = new Thread(counter::increment, "Thread 2");
        Thread t6 = new Thread(counter::increment, "Thread 2");

        startAll(t1, t2, t3, t4, t5, t6);
        joinAll(t1, t2, t3, t4, t5, t6);

        System.out.println("Expected value: 6, actual value: " + counter.getValue());

    }
}