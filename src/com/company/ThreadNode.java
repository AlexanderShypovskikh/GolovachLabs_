package com.company;

/**
 * Created by Al on 15.06.2016.
 */
public class ThreadNode {
    public final Thread thread;
    public final ThreadNode nextNode;

    public ThreadNode(Thread thread, ThreadNode nextNode) {
        this.thread = thread;
        this.nextNode = nextNode;
    }
}