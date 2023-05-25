import java.util.Random;

public class SortingAlgorithms {
    private static Random random = new Random();

    /**
     * bubbleSort is a naive sorting algorithm that involves iteratively 
     * 'bubbling' the i-th largest value in the array by comparing the i-th
     * value to the (i+1)-st. If the ith value is greater, the values are
     * swapped. It has approximately O(n**2) time complexity.
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

    /**
     * insertionSort involves finding the correct spot for a target item in an array
     * by swapping it with the left neighbor until either the neighbor is smaller than
     * the target or the left end of the array has been reached. After that, move to 
     * the right neighbor of the target's orignal position and repeat until there are
     * no more items to 'insert'
     * 
     * @param arrayToSort, the array to be sorted
     * @return int[], the insertion sorted array
     */
    public static int[] insertionSort(int[] arrayToSort) {
        arrayToSort = deepcopyArray(arrayToSort);

        for (int i = 1; i < arrayToSort.length; i++) {
            int currIdx = i - 1;
            while (currIdx >= 0 && arrayToSort[currIdx] > arrayToSort[currIdx + 1]) {
                int tmp = arrayToSort[currIdx];
                arrayToSort[currIdx] = arrayToSort[currIdx + 1];
                arrayToSort[currIdx + 1] = tmp;
                currIdx = currIdx - 1;
            }
        }

        return arrayToSort;
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
        int arrayLength = 10;
        if (args.length == 1) {
            arrayLength = Integer.parseInt(args[0]);
        }

        // Initialize randomized array to sort
        int[] arrayToSort = new int[arrayLength];
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = random.nextInt(arrayToSort.length * arrayToSort.length);
        }
        System.out.print("Array to sort: ");
        printArray(arrayToSort);

        // Perform bubble sort
        System.out.print("Bubble sorted: ");
        int[] bubbleSorted = bubbleSort(arrayToSort);
        printArray(bubbleSorted);

        System.out.print("Insertion sorted:");
        int[] insertionSorted = insertionSort(arrayToSort);
        printArray(insertionSorted);

        System.out.println("##### END MAIN #####");
    }
}