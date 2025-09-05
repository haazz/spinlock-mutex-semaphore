package com.example;

import com.example.criticalsection.CriticalSection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor {
    private final ExecutorService executor;
    private final CriticalSection criticalSection;
    private final CustomLock lock;


    public Executor(CustomLock lock) {
        this.executor = Executors.newFixedThreadPool(3); // 스레드 풀 크기 = 3
        this.criticalSection = new CriticalSection();
        this.lock = lock;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 10_000; i++) {
            executor.execute(() -> {
                lock.lock();
                try {
                    criticalSection.run();
                } finally {
                    lock.unlock();
                }
            });
        }
        executor.shutdown();
        if (!executor.awaitTermination(10000, TimeUnit.SECONDS)) {
            System.out.println("시간 내에 종료되지 않아 강제 종료합니다.");
            executor.shutdownNow(); // 남은 작업 강제 종료
        }

        String result = "****** " + lock.getClass().getSimpleName() + " ******\n"
            + "counter: " + criticalSection.getCounter() + "\n";
        System.out.println(result);
    }
}
