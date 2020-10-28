package pt.pa;

import pt.pa.adts.Queue;
import pt.pa.adts.QueueLinkedList;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new QueueLinkedList<>();

        try {
            for (int i=0; i<100; i++) {
                queue.enqueue(i);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Size: " + queue.size());
        System.out.println("Front: " + queue.front());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Size: " + queue.size());
        System.out.println("Front: " + queue.front());
        System.out.println("IsEmpty: " + queue.isEmpty());
        queue.clear();
        System.out.println("IsEmpty: " + queue.isEmpty());
        try {
            System.out.println("Front: " + queue.front());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Dequeued: " + queue.dequeue());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}