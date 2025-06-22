package com.example.singleton;

public class LoggerTest {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        System.out.println("Instance 1 hash: " + System.identityHashCode(l1));
        System.out.println("Instance 2 hash: " + System.identityHashCode(l2));
        System.out.println("Same instance? " + (l1 == l2));

        // Simulate multithreaded access
        Runnable r = () -> {
            Logger logger = Logger.getInstance();
            logger.log("Logging from thread.");
        };
        Thread t1 = new Thread(r, "T1");
        Thread t2 = new Thread(r, "T2");
        t1.start();
        t2.start();
    }
}
