package com.company;

/**
 * Created by Al on 15.06.2016.
 */
public class InterruptBuffer {
    private ThreadNode producers = null;
    private ThreadNode consumers = null;
    private Integer elem = null;

    public synchronized void put(int newElem) {
        while (elem != null) {
            try {
                ThreadNode elemProducer = producers;
                producers = new ThreadNode(Thread.currentThread(),elemProducer);
                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        elem = newElem;
        if (consumers != null) {
            consumers.thread.interrupt();
            ThreadNode tmp = consumers;
            consumers = tmp.nextNode;

        }
    }

    public synchronized int get() {
        while (elem == null) {
            try {
                ThreadNode elemConsumer = consumers;
                consumers = new ThreadNode(Thread.currentThread(),elemConsumer);
                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        int result = elem;
        elem = null;
        if (producers != null) {
            producers.thread.interrupt();
            ThreadNode tmp = producers;
            producers = tmp.nextNode;
        }
        return result;
    }
}

