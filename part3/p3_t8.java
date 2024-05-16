package part3;
import java.util.LinkedList;
public class p3_t8 {
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

    // HashTable class containing methods to add elements to the hash table and calculate sum of elements
    static class HashTable<K, V> {
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

        // Method to calculate the sum of elements in the hash table
        public int calculateSum() {
            int sum = 0;
            for (LinkedList<HashNode<K, V>> bucket : buckets) {
                for (HashNode<K, V> node : bucket) {
                    if (node.value instanceof Integer) {
                        sum += (Integer) node.value;
                    } else if (node.value instanceof Double) {
                        sum += ((Double) node.value).intValue();
                    } else if (node.value instanceof Float) {
                        sum += ((Float) node.value).intValue();
                    } else {
                        // Handle other types as needed
                    }
                }
            }
            return sum;
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
    }

    public class Main {
        public static void main(String[] args) {
            HashTable<String, Integer> hashtable = new HashTable<>(10);

            // Adding elements to the hash table
            hashtable.put("apple", 10);
            hashtable.put("banana", 20);
            hashtable.put("cherry", 30);
            hashtable.put("orange", 40);

            // Displaying the hash table
            System.out.println("Hash Table:");
            hashtable.display();

            // Calculating and displaying the sum of elements in the hash table
            int sum = hashtable.calculateSum();
            System.out.println("\nSum of elements in the hash table: " + sum);
        }
    }

}
