package com.example.criticalsection;

public class CriticalSection {
    int counter ;

    public CriticalSection() {
        counter = 0;
    }

    public void run() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
