package part2;
public class part2_task1 {

        public static void main(String[] args) {
            int arr[] = {33, 606, 335, 26, 457, 32660, 566, 27, 45, 36620, 555};

            System.out.println("Original Array:");
            printArray(arr);

            bubbleSort(arr);

            System.out.println("\nSorted Array:");
            printArray(arr);
        }

        // Bubble Sort algorithm
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Swap arr[j] and arr[j + 1]
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
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
