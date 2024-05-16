package part1;

import java.util.ArrayList;  // Imports the ArrayList class from the java.util package
import java.util.LinkedList; // Imports the LinkedList class from the java.util package

public class task1 {

    public static void main(String[] args) {
        // Creates a new ArrayList object named 'arrayList'
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Creates a new LinkedList object named 'linkedList'
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Loop to add elements (0 to 9999) to both ArrayList and LinkedList
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Gets the current time in milliseconds before accessing elements in ArrayList
        Long start = System.currentTimeMillis();

        // Loop to iterate through all elements (but not actually using their values) in the ArrayList
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }

        // Gets the current time in milliseconds after accessing elements in ArrayList
        Long end = System.currentTimeMillis();

        // Calculates the time taken to access elements in ArrayList and prints the result
        System.out.println("Time taken for ArrayList is " + (end - start) + "ms");
    }
}
