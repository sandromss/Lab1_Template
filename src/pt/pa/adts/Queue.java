
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
public interface Queue<T> {

    /**
     * Inserts the element at the end of the queue.
     *
     * @param element element to insert.
     * @throws FullQueueException if there is no capacity / memory for more elements.
     */
    void enqueue(T element) throws FullQueueException;

    /**
     * Removes the element at the start of the queue.
     *
     * @return the element at the start of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    T dequeue() throws EmptyQueueException;

    /**
     * Returns the element at the start of the queue without removing it from the queue
     *
     * @return the element at the start of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    T front() throws EmptyQueueException;

    /**
     * Returns the number of elements currently in the queue.
     *
     * @return Number of elements in the queue.
     */
    int size();

    /**
     * Checks if the queue does not have any elements in it.
     *
     * @return true if queue is empty, false if queue has ant elements.
     */
    boolean isEmpty();

    /**
     * Removes all elements from queue.
     */
    void clear();

}