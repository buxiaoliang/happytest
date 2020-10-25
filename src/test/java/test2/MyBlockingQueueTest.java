package test2;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MyBlockingQueueTest {

    @Test
    void testMyQuene() throws InterruptedException {
        final MyBlockingQueue queue = new MyBlockingQueue();

        // this thread is for putting data to queue
        Thread put = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i ++) {
                    MyData data = new MyData();
                    data.setData("Test" + i);
                    queue.put(data);
                    System.out.println("Writer: " + data.getData());
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // this thread is for getting data from queue
        Thread get = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i ++) {
                    System.out.println("Reader:" + queue.take());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        put.start();
        get.start();
        put.join();
        get.join();
    }
}