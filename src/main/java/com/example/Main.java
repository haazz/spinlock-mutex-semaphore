package com.example;

import com.example.mutex.Mutex;
import com.example.semaphore.BinarySemaphore;
import com.example.spinlock.SpinLock;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        final Executor spinLockExecutor = new Executor(new SpinLock());
        final Executor mutexExecutor = new Executor(new Mutex());
        final Executor binarySemaphoreExecutor = new Executor(new BinarySemaphore());

        spinLockExecutor.run();
        mutexExecutor.run();
        binarySemaphoreExecutor.run();
    }
}