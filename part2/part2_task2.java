package part2;

public class part2_task2 {

        public static void main(String[] args) {
            int arr[] = {33, 606, 335, 26, 457, 32660, 566, 27, 45, 36620, 555};

            System.out.println("Original Array:");
            printArray(arr);

            heapSort(arr);

            System.out.println("\nSorted Array:");
            printArray(arr);
        }

        // Heap Sort algorithm
        public static void heapSort(int[] arr) {
            int n = arr.length;

            // Build max heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }

            // Extract elements from heap one by one
            for (int i = n - 1; i > 0; i--) {
                // Swap root (max element) with the last element
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // Heapify the reduced heap
                heapify(arr, i, 0);
            }
        }

        // Heapify a subtree rooted at index i in the heap of size n
        public static void heapify(int[] arr, int n, int i) {
            int largest = i; // Initialize largest as root
            int leftChild = 2 * i + 1; // Left child index
            int rightChild = 2 * i + 2; // Right child index

            // If left child is larger than root
            if (leftChild < n && arr[leftChild] > arr[largest]) {
                largest = leftChild;
            }

            // If right child is larger than largest so far
            if (rightChild < n && arr[rightChild] > arr[largest]) {
                largest = rightChild;
            }

            // If largest is not root
            if (largest != i) {
                // Swap arr[i] and arr[largest]
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;

                // Recursively heapify the affected sub-tree
                heapify(arr, n, largest);
            }
        }

        // Utility method to print an array
        public static void printArray(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

}
