
package pt.pa.adts;

/**
 * Interface that defines the behavior of a queue in the Java language.
 *
 * A queue is a container of elements that guarantees a FIFO access policy.
 *
 * Implementations should implement this interface.
 *
 * @param <T> - Data type to be stored in the Queue.
 *
 * @author Sandro Santos
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;

    public QueueLinkedList() {
        this.header = new Node(null, null, null);
        this.trailer= new Node(null, header, null);
        header.next = trailer;
    }

    /**
     * Inserts the element at the end of the queue.
     *
     * @param element element to insert.
     * @throws FullQueueException if there is no capacity / memory for more elements.
     */
    @Override
    public void enqueue(T element) throws FullQueueException {
        try {
            Node curEnd = this.trailer.prev;
            this.trailer.prev = new Node(element, curEnd, this.trailer);
            curEnd.next = this.trailer.prev;
        } catch(OutOfMemoryError e) {
            throw new FullQueueException("No memory for more elements.");
        }
    }

    /**
     * Removes the element at the start of the queue.
     *
     * @return the element at the start of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    @Override
    public T dequeue() throws EmptyQueueException {

        if(isEmpty()) throw new EmptyQueueException();

        Node curStart = this.header.next;
        T element = curStart.element;

        Node newStart = curStart.next;

        this.header.next = newStart;
        newStart.prev = this.header;

        return element;
    }

    /**
     * Returns the element at the start of the queue without removing it from the queue
     *
     * @return the element at the start of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    @Override
    public T front() throws EmptyQueueException {

        if(isEmpty()) throw new EmptyQueueException();

        Node curStart = this.header.next;

        return curStart.element;
    }

    /**
     * Returns the number of elements currently in the queue.
     *
     * @return Number of elements in the queue.
     */
    @Override
    public int size() {
        int count = 0;
        Node current = this.header.next;
        while (current != this.trailer) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Checks if the queue does not have any elements in it.
     *
     * @return true if queue is empty, false if queue has any elements.
     */
    @Override
    public boolean isEmpty() {
        return this.header.next == this.trailer;
    }

    /**
     * Removes all elements from queue.
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}