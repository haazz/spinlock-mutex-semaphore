package com.example.semaphore;

import com.example.CustomLock;
import java.util.concurrent.Semaphore;

public class BinarySemaphore implements CustomLock {
    private static final Semaphore semaphore = new Semaphore(1);

    @Override
    public void lock() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void unlock() {
        semaphore.release();
    }
}
