package part1;

import java.util.LinkedList;
import java.util.Queue;
public class task4 {
        public static void main(String[] args) {
            Queue<Integer> direction1Queue = new LinkedList<>();
            Queue<Integer> direction2Queue = new LinkedList<>();

            // Enqueue clients from both directions
            for (int i = 1; i <= 6; i++) {
                if (i % 2 == 1) {
                    direction1Queue.offer(i); // Odd numbers for direction 1
                } else {
                    direction2Queue.offer(i); // Even numbers for direction 2
                }
            }

            // Serve clients alternately from each direction
            int count = 0;
            while (!direction1Queue.isEmpty() && !direction2Queue.isEmpty()) {
                if (count % 2 == 0) { // Serve from direction 1
                    System.out.println("Serving client " + direction1Queue.poll() + " from direction 1");
                } else { // Serve from direction 2
                    System.out.println("Serving client " + direction2Queue.poll() + " from direction 2");
                }
                count++;

                if (count % 3 == 0) { // Call everyone after 3 clients are served
                    System.out.println("Calling everyone in turn:");
                    while (!direction1Queue.isEmpty()) {
                        System.out.println("Serving client " + direction1Queue.poll() + " from direction 1");
                    }
                    while (!direction2Queue.isEmpty()) {
                        System.out.println("Serving client " + direction2Queue.poll() + " from direction 2");
                    }
                }
            }

            // Serve remaining clients if any
            while (!direction1Queue.isEmpty()) {
                System.out.println("Serving client " + direction1Queue.poll() + " from direction 1");
            }
            while (!direction2Queue.isEmpty()) {
                System.out.println("Serving client " + direction2Queue.poll() + " from direction 2");
            }
        }

}
