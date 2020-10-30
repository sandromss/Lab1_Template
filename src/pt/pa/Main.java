package pt.pa;

import pt.pa.adts.PriorityQueue;
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


        Queue<PrintJob> priorityQueue = new PriorityQueue<>();

        PrintJob job1 = new PrintJob("Job1", Priority.NORMAL, 2);
        PrintJob job2 = new PrintJob("Job2", Priority.LOW, 5);
        PrintJob job3 = new PrintJob("Job3", Priority.HIGH, 3);
        PrintJob job4 = new PrintJob("Job4", Priority.LOW, 2);
        PrintJob job5 = new PrintJob("Job5", Priority.NORMAL, 1);
        PrintJob job6 = new PrintJob("Job6", Priority.HIGH, 2);
        PrintJob job7 = new PrintJob("Job7", Priority.NORMAL, 1);

        priorityQueue.enqueue(job1);
        priorityQueue.enqueue(job5);
        priorityQueue.enqueue(job2);
        priorityQueue.enqueue(job3);
        priorityQueue.enqueue(job6);
        priorityQueue.enqueue(job4);
        priorityQueue.enqueue(job7);

        try {

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nSize: \n" + priorityQueue.size());
        System.out.println("\nFront: \n" + priorityQueue.front());
        System.out.println("\nDequeued: \n" + priorityQueue.dequeue());
        System.out.println("\nSize: \n" + priorityQueue.size());
        System.out.println("\nFront: \n" + priorityQueue.front());
        System.out.println("\nDequeued: \n" + priorityQueue.dequeue());
        System.out.println("\nSize: \n" + priorityQueue.size());
        System.out.println("\nFront: \n" + priorityQueue.front());
        System.out.println("\nDequeued: \n" + priorityQueue.dequeue());
        System.out.println("IsEmpty: " + priorityQueue.isEmpty());
        priorityQueue.clear();
        System.out.println("IsEmpty: " + priorityQueue.isEmpty());
        try {
            System.out.println("Front: " + priorityQueue.front());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Dequeued: " + priorityQueue.dequeue());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}