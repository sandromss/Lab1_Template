package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.pa.PrintJob;
import pt.pa.Priority;
import pt.pa.adts.EmptyQueueException;
import pt.pa.adts.PriorityQueue;
import pt.pa.adts.Queue;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    private Queue<PrintJob> queue;
    private PrintJob job1, job2, job3, job4, job5, job6, job7;

    @BeforeEach
    void setUp() {
        queue = new PriorityQueue<>();
        job1 = new PrintJob("Job1", Priority.NORMAL, 2);
        job2 = new PrintJob("Job2", Priority.LOW, 5);
        job3 = new PrintJob("Job3", Priority.HIGH, 3);
        job4 = new PrintJob("Job4", Priority.LOW, 2);
        job5 = new PrintJob("Job5", Priority.NORMAL, 1);
        job6 = new PrintJob("Job6", Priority.HIGH, 2);
        job7 = new PrintJob("Job7", Priority.NORMAL, 1);
    }

    @Test
    void enqueue() {
        queue.enqueue(job1);
        assertEquals(job1, queue.front());

        queue.enqueue(job2);
        assertNotEquals(job2, queue.front());
        queue.dequeue();
        assertEquals(job2, queue.front());
        queue.enqueue(job3);
        queue.enqueue(job4);
        assertEquals(3, queue.size());
        queue.enqueue(job5);
        queue.enqueue(job6);
        queue.dequeue();
        assertEquals(job6, queue.front());
    }

    @Test
    void dequeue() {
        queue.enqueue(job1);
        assertEquals(job1, queue.dequeue());
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
        queue.enqueue(job2);
        queue.enqueue(job3);
        queue.enqueue(job4);
        queue.enqueue(job5);
        assertEquals(job3, queue.dequeue());
        assertNotEquals(job4, queue.dequeue());
        assertEquals(job2, queue.dequeue());
        assertEquals(job4, queue.dequeue());
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
    }

    @Test
    void front() {
        queue.enqueue(job1);
        assertEquals(job1, queue.front());

        queue.enqueue(job2);
        queue.enqueue(job3);
        queue.enqueue(job4);
        assertEquals(job3, queue.front());
        queue.dequeue();
        assertNotEquals(job2, queue.front());
        queue.dequeue();
        assertEquals(job2, queue.front());
        queue.dequeue();
        assertEquals(job4, queue.front());

        queue.clear();
        assertThrows(EmptyQueueException.class, () -> queue.front());
    }
}