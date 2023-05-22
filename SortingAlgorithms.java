import java.util.Random;

public class SortingAlgorithms {
    private static Random random = new Random();

    /**
     * bubbleSort is a naive sorting algorithm that involves iteratively 
     * 'bubbling' the i-th largest value in the array by comparing the i-th
     * value to the (i+1)-st. If the ith value is greater, the values are
     * swapped. It was approximately O(n**2) time complexity.
     * 
     * @param arrayToSort the array to be sorted. this will get deep copied
     *                    before being sorted
     * @return int[], a deep copy of the original array, sorted via bubble sort
     */
    public static int[] bubbleSort(int[] arrayToSort) {
        arrayToSort = deepcopyArray(arrayToSort);

        int itersLeft = arrayToSort.length - 1;
        while (itersLeft >= 0) {
            for (int index = 0; index < itersLeft; index++) {
                int left = arrayToSort[index];
                int right = arrayToSort[index+1];
                if (left > right) {
                    arrayToSort[index] = right;
                    arrayToSort[index+1] = left;
                }
            }

            itersLeft--;
        }

        return arrayToSort;
    }

    // Insertion sort
    // TODO: Implement
    // TODO: Document
    public static int[] insertionSort(int[] arrayToSort) {
        return null;
    }

    // Selection sort
    // TODO: Implement
    // TODO: Document
    public static int[] selectionSort(int[] arrayToSort) {
        return null;
    }

    // Merge sort
    // TODO: Implement
    // TODO: Document
    public static int[] mergeSort(int[] arrayToSort) {
        return null;
    }

    // Quick sort
    // TODO: Implement
    // TODO: Document
    public static int[] quickSort(int[] arrayToSort) {
        return null;
    }

    // Heapsort
    // TODO: Implement
    // TODO: Document
    public static int[] heapSort(int[] arrayToSort) {
        return null;
    }

    // Radix sort
    // TODO: Implement
    // TODO: Document
    public static int[] radixSort(int[] arrayToSort) {
        return null;
    }

    // Counting sort
    // TODO: Implement
    // TODO: Document
    public static int[] countingSort(int[] arrayToSort) {
        return null;
    }

    // Bucket sort
    // TODO: Implement
    // TODO: Document
    public static int[] bucketSort(int[] arrayToSort) {
        return null;
    }

    // Shell sort
    // TODO: Implement
    // TODO: Document
    public static int[] shellSort(int[] arrayToSort) {
        return null;
    }

    private static int[] deepcopyArray(int[] arrayToCopy) {
        int[] copiedArray = new int[arrayToCopy.length];
        for (int i = 0; i < arrayToCopy.length; i++) {
            copiedArray[i] = arrayToCopy[i];
        }
        arrayToCopy = copiedArray;

        return copiedArray;
    }

    private static void printArray(int[] arrayToPrint) {
        System.out.print("{ " +arrayToPrint[0]);
        for (int i = 1; i < arrayToPrint.length; i++) {
            System.out.print(", " +arrayToPrint[i]);
        }
        System.out.println("}");
    }

    //////////
    // MAIN //
    //////////
    public static void main(String[] args) {
        System.out.println("##### START MAIN #####");

        // Initialize randomized array to sort
        int[] arrayToSort = new int[20];
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = random.nextInt(arrayToSort.length * arrayToSort.length);
        }
        System.out.print("Array to sort: ");
        printArray(arrayToSort);

        // Perform bubble sort
        int[] bubbleSortedArray = bubbleSort(arrayToSort);
        System.out.print("Bubble sorted: ");
        printArray(bubbleSortedArray);

        System.out.println("##### END MAIN #####");
    }
}