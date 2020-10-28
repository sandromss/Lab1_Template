package pt.pa.adts;

import sun.invoke.empty.Empty;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {

    private Queue<Integer> queue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        queue = new QueueLinkedList<>();
    }

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
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