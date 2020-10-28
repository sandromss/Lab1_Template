
package pt.pa.adts;

/**
 * TODO: Fornecer documentação da classe.
 *
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;

    public QueueLinkedList() {
        //TODO: construtor deve inicializar uma fila vazia
        this.header = new Node(null, null, trailer);
        this.trailer= new Node(null, header, null);
    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida

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

    @Override
    public T front() throws EmptyQueueException {

        if(isEmpty()) throw new EmptyQueueException();

        Node curStart = this.header.next;
        T element = curStart.element;

        return element;
    }

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

    @Override
    public boolean isEmpty() {
        return (this.header.next == this.trailer) ? true : false;
    }

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