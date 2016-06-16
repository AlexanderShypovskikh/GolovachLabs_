package com.company;

/**
 * Created by Al on 15.06.2016.
 */
public class InterruptedConsumer  implements Runnable {
    private final InterruptBuffer buffer;

    public InterruptedConsumer(InterruptBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            int elem = buffer.get();
            System.out.println(elem + " consumed");
        }
    }
}
