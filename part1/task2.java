package part1;

import java.util.ArrayList;
import java.util.LinkedList;
public class task2 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 10000; i++){
            arrayList.add(i);
            linkedList.add(i);
        }

        Long start = System.currentTimeMillis();

        for(int i = 0; i < arrayList.size(); i++)
            arrayList.get(i);
        Long end = System.currentTimeMillis();
        System.out.println("Time taken for arraylist is " + (end - start) + "ms");

        start = System.currentTimeMillis();
        for(int i = 0; i < linkedList.size(); i++)
            linkedList.get(i);
        end = System.currentTimeMillis();
        System.out.println("Time taken for linkedlist is " + (end - start) + "ms");
    }


}
