package part3;
import java.util.LinkedList;
public class p3_t10 {
    // HashNode class representing a node in the hash table
    static class HashNode<K, V> {
        K key;
        V value;

        // Constructor to initialize key and value
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    // HashTable class containing methods to add elements to the hash table and display odd/even elements
    static class HashTable<K, V extends Number> {
        private int capacity; // Capacity of the hash table
        private LinkedList<HashNode<K, V>>[] buckets; // Array of LinkedLists to store hash nodes

        // Constructor to initialize the hash table with a given capacity
        public HashTable(int capacity) {
            this.capacity = capacity;
            buckets = new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        // Method to calculate the hash code of a key
        private int getHash(K key) {
            return Math.abs(key.hashCode()) % capacity;
        }

        // Method to add a key-value pair to the hash table
        public void put(K key, V value) {
            int hash = getHash(key);
            LinkedList<HashNode<K, V>> bucket = buckets[hash];

            for (HashNode<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    node.value = value; // Update value if key already exists
                    return;
                }
            }

            bucket.add(new HashNode<>(key, value)); // Add new key-value pair
        }

        // Method to display the hash table
        public void display() {
            for (int i = 0; i < capacity; i++) {
                System.out.print("Bucket " + i + ": ");
                LinkedList<HashNode<K, V>> bucket = buckets[i];
                for (HashNode<K, V> node : bucket) {
                    System.out.print("(" + node.key + ", " + node.value + ") ");
                }
                System.out.println();
            }
        }

        // Method to display odd elements in the hash table
        public void displayOddElements() {
            System.out.println("Odd Elements:");
            for (LinkedList<HashNode<K, V>> bucket : buckets) {
                for (HashNode<K, V> node : bucket) {
                    if (node.value.intValue() % 2 != 0) {
                        System.out.println("(" + node.key + ", " + node.value + ")");
                    }
                }
            }
        }

        // Method to display even elements in the hash table
        public void displayEvenElements() {
            System.out.println("Even Elements:");
            for (LinkedList<HashNode<K, V>> bucket : buckets) {
                for (HashNode<K, V> node : bucket) {
                    if (node.value.intValue() % 2 == 0) {
                        System.out.println("(" + node.key + ", " + node.value + ")");
                    }
                }
            }
        }
    }
        public static void main(String[] args) {
            HashTable<String, Integer> hashtable = new HashTable<>(10);

            // Adding elements to the hash table
            hashtable.put("apple", 10);
            hashtable.put("banana", 20);
            hashtable.put("cherry", 30);
            hashtable.put("orange", 45);
            hashtable.put("grape", 55);
            hashtable.put("kiwi", 70);
            hashtable.put("mango", 85);

            // Displaying the hash table
            System.out.println("Hash Table:");
            hashtable.display();

            // Displaying odd elements in the hash table
            hashtable.displayOddElements();

            // Displaying even elements in the hash table
            hashtable.displayEvenElements();
        }


}
