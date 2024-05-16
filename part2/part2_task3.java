package part2;
public class part2_task3 {
        public static void main(String[] args) {
            int arr[] = {33, 606, 335, 26, 457, 32660, 566, 27, 45, 36620, 555};

            System.out.println("Original Array:");
            printArray(arr);

            mergeSort(arr, 0, arr.length - 1);

            System.out.println("\nSorted Array:");
            printArray(arr);
        }

        // Merge Sort algorithm
        public static void mergeSort(int[] arr, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2;

                // Sort first and second halves recursively
                mergeSort(arr, left, mid);
                mergeSort(arr, mid + 1, right);

                // Merge the sorted halves
                merge(arr, left, mid, right);
            }
        }

        // Merge two subarrays of arr[]
        public static void merge(int[] arr, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            // Create temporary arrays
            int[] leftArr = new int[n1];
            int[] rightArr = new int[n2];

            // Copy data to temporary arrays
            for (int i = 0; i < n1; i++) {
                leftArr[i] = arr[left + i];
            }
            for (int j = 0; j < n2; j++) {
                rightArr[j] = arr[mid + 1 + j];
            }

            // Merge the temporary arrays
            int i = 0, j = 0;
            int k = left;
            while (i < n1 && j < n2) {
                if (leftArr[i] <= rightArr[j]) {
                    arr[k] = leftArr[i];
                    i++;
                } else {
                    arr[k] = rightArr[j];
                    j++;
                }
                k++;
            }

            // Copy remaining elements of leftArr[], if any
            while (i < n1) {
                arr[k] = leftArr[i];
                i++;
                k++;
            }

            // Copy remaining elements of rightArr[], if any
            while (j < n2) {
                arr[k] = rightArr[j];
                j++;
                k++;
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
