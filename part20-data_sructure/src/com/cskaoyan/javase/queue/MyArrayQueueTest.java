package com.cskaoyan.javase.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyArrayQueueTest {
    private MyArrayQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new MyArrayQueue<>();
    }

    @Test
    public void testEnQueue() {
        assertTrue(queue.enQueue(1));
        assertEquals(1, (int) queue.peek());
    }

    @Test
    public void testDeQueue() {
        queue.enQueue(1);
        queue.enQueue(2);
        assertEquals(1, (int) queue.deQueue());
        assertEquals(2, (int) queue.peek());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enQueue(1);
        assertFalse(queue.isEmpty());
        queue.deQueue();
        assertTrue(queue.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testDeQueueEmpty() {
        queue.deQueue();
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekEmpty() {
        queue.peek();
    }


}
