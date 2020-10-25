package test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * - Concurrency:
 * Use java concurrency packages to write a queue that supports multi-writer and multi-reader,
 * i.e. the writer pushes the stuff into the queue and the reader pops the stuff out the queue.
 * All the writer's stuff can't be lost and must be into the queue, and each reader can't pops out the same stuff.
 * Think of how you would simulate the situation and perform the testing. Using the java blocking queue is not allowed.
 * Design:
 * 1) Design LinkedList as Queue
 * 2）Use concurrency package "ReentrantLock" to implement detail lock
 */
public class MyBlockingQueue {

    private Queue<MyData> queue = new LinkedList<>();

    final ReentrantLock lock = new ReentrantLock();

    private final Condition putWaiting = lock.newCondition();

    private final Condition getWaiting = lock.newCondition();

    private int count;

    public void put(MyData myData) {
        lock.lock();

        try {
            while (queue.offer(myData)) {
                putWaiting.await();
            }
            getWaiting.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public MyData take() {
        lock.lock();
        try {
            while (queue.peek() == null) {
                getWaiting.await();
            }
            putWaiting.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            {
                lock.unlock();
            }
        }
        return queue.remove();
    }
}
