import java.util.Currency;
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

    /**
     * selectionSort involves iteratively finding the minimum value in the elements to 
     * the left of it, then swapping the two (if they are not the same). We will do this
     * until there are no more elements from which to find a minimum.
     * 
     * @param arrayToSort the array to sort
     * @return int[] the selection sorted array
     */
    public static int[] selectionSort(int[] arrayToSort) {
        arrayToSort = deepcopyArray(arrayToSort);

        for (int i = 0; i < arrayToSort.length - 1; i++) {
            // find min value
            int minIndex = i;
            int minValue = arrayToSort[minIndex];
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if (arrayToSort[j] < minValue) {
                    minIndex = j;
                    minValue = arrayToSort[j];
                }
            }

            // swap 
            if (minIndex != i) {
                int tmp = arrayToSort[minIndex];
                arrayToSort[minIndex] = arrayToSort[i];
                arrayToSort[i] = tmp;
            }
        }

        return arrayToSort;
    }

    /**
     * mergeSort involves recursively splitting the array into smaller sub-arrays
     * and recombining them on the way back up the stack trace
     * 
     * @param arrayToSort the array to merge sort
     * @return int[], the merge sorted array
     */
    public static int[] mergeSort(int[] arrayToSort) {
        arrayToSort = deepcopyArray(arrayToSort);
        arrayToSort = mergeSort(arrayToSort, 0, arrayToSort.length - 1);
        
        return arrayToSort;
    }

    /**
     * mergeSort involves recursively splitting the array into smaller sub-arrays
     * and recombining them on the way back up the stack trace
     * 
     * @param arrayToSort the array to merge sort
     * @param leftIdx, the left side of the subarray
     * @param rightIdx, the right side of the subarray
     * @return int[], the merge sorted array
     */
    private static int[] mergeSort(int[] arrayToSort, int leftIdx, int rightIdx) {
        if (leftIdx < 0 || rightIdx >= arrayToSort.length || leftIdx > rightIdx) { 
            return new int[0];
        }
        else if (rightIdx == leftIdx) {
            return new int[] { arrayToSort[leftIdx] };
        }
        else {
            int midpoint = leftIdx + (rightIdx-leftIdx)/2;
            int[] leftMerge = mergeSort(arrayToSort, leftIdx, midpoint);
            int leftMergeIdx = 0;
            int[] rightMerge = mergeSort(arrayToSort, midpoint+1, rightIdx);
            int rightMergeIdx = 0;

            int[] merged = new int[rightIdx - leftIdx + 1];
            int mergedIdx = 0;
            while (leftMergeIdx < leftMerge.length && rightMergeIdx < rightMerge.length) {
                if (leftMerge[leftMergeIdx] < rightMerge[rightMergeIdx]) {
                    merged[mergedIdx] = leftMerge[leftMergeIdx];
                    leftMergeIdx = leftMergeIdx + 1;     
                }
                else {
                    merged[mergedIdx] = rightMerge[rightMergeIdx];
                    rightMergeIdx = rightMergeIdx + 1;
                }
                mergedIdx = mergedIdx + 1;
            }
            while (leftMergeIdx < leftMerge.length) {
                merged[mergedIdx++] = leftMerge[leftMergeIdx++];
            }
            while (rightMergeIdx < rightMerge.length) {
                merged[mergedIdx++] = rightMerge[rightMergeIdx++];
            }

            return merged;
        }
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
        if (arrayToPrint.length == 0) {
            System.out.println("{ }");
        }
        else {
            System.out.print("{ " +arrayToPrint[0]);
            for (int i = 1; i < arrayToPrint.length; i++) {
                System.out.print(", " +arrayToPrint[i]);
            }
            System.out.println(" }");
        }
    }

    //////////
    // MAIN //
    //////////
    public static void main(String[] args) {
        System.out.println("##### START MAIN #####\n");
        int arrayLength = 10;
        if (args.length == 1) {
            arrayLength = Integer.parseInt(args[0]);
        }

        // Initialize randomized array to sort
        int[] arrayToSort = new int[arrayLength];
        int upperBound = arrayLength * arrayLength;
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = random.nextInt(upperBound);
        }
        System.out.print("Array to sort: ");
        printArray(arrayToSort);

        // Perform bubble sort
        System.out.print("1. Bubble sorted: ");
        int[] bubbleSorted = bubbleSort(arrayToSort);
        printArray(bubbleSorted);

        System.out.print("2. Insertion sorted:");
        int[] insertionSorted = insertionSort(arrayToSort);
        printArray(insertionSorted);

        System.out.print("3. Selection sorted:");
        int[] selectionSorted = selectionSort(arrayToSort);
        printArray(selectionSorted);

        System.out.print("4. Merge sorted:");
        int[] mergeSorted = mergeSort(arrayToSort);
        printArray(mergeSorted);

        // System.out.print("Original Array Object: ");
        // printArray(arrayToSort);
        System.out.println("\n##### END MAIN #####");
    }
}