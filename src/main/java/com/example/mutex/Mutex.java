package com.example.mutex;

import com.example.CustomLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mutex implements CustomLock {
    private final Lock lock = new ReentrantLock();  // Java 내부적으로 구현해 놓은 ReentrantLock == Mutex

    public void lock() {
        lock.lock();
    }
    public void unlock() {
        lock.unlock();
    }
}
