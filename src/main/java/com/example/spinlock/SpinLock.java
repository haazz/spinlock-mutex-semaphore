package com.example.spinlock;

import com.example.CustomLock;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock implements CustomLock {
    private final AtomicBoolean locked = new AtomicBoolean(false);

    public void lock() {
        while (!locked.compareAndSet(false, true)) {
            Thread.onSpinWait();    // Java 9부터 추가된 JVM이 CPU에게 하드웨어적 최적화 힌트를 주는 메소드
        }
    }

    public void unlock() {
        locked.set(false);
    }
}
