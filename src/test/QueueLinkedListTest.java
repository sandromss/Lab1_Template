package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.pa.adts.EmptyQueueException;
import pt.pa.adts.Queue;
import pt.pa.adts.QueueLinkedList;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {

    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new QueueLinkedList<>();
    }

    @Test
    void enqueue() {
        queue.enqueue(1);
        assertEquals(1, queue.front());

        queue.enqueue(2);
        assertNotEquals(2, queue.front());
        queue.dequeue();
        assertEquals(2, queue.front());
        queue.enqueue(3);
        queue.enqueue(4);
        assertEquals(3, queue.size());
    }

    @Test
    void dequeue() {
        queue.enqueue(1);
        assertEquals(1, queue.dequeue());
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(2, queue.dequeue());
        assertNotEquals(2, queue.dequeue());
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
    }

    @Test
    void front() {
        queue.enqueue(1);
        assertEquals(1, queue.front());

        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.front());
        assertNotEquals(2, queue.front());

        queue.clear();
        assertThrows(EmptyQueueException.class, () -> queue.front());
    }
}