import java.util.*;

public class MergeSort {
    public static void mergeSort(int[] inputArray) 
    {
        if (inputArray.length > 1) 
        {
            int middleIndex = inputArray.length / 2;
            int[] leftHalf = Arrays.copyOfRange(inputArray, 0, middleIndex);
            int[] rightHalf = Arrays.copyOfRange(inputArray, middleIndex, inputArray.length);

            mergeSort(leftHalf);
            mergeSort(rightHalf);

            int leftIndex = 0;
            int rightIndex = 0;
            int mergedIndex = 0;
            while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) 
            {
                if (leftHalf[leftIndex] <= rightHalf[rightIndex]) 
                {
                    inputArray[mergedIndex] = leftHalf[leftIndex];
                    leftIndex++;
                } 
                else 
                {
                    inputArray[mergedIndex] = rightHalf[rightIndex];
                    rightIndex++;
                }
                mergedIndex++;
            }

            while (leftIndex < leftHalf.length) 
            {
                inputArray[mergedIndex] = leftHalf[leftIndex];
                leftIndex++;
                mergedIndex++;
            }

            while (rightIndex < rightHalf.length) 
            {
                inputArray[mergedIndex] = rightHalf[rightIndex];
                rightIndex++;
                mergedIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] inputArray = new int[100];
        Random random = new Random();
        for (int i = 0; i < inputArray.length; i++)
        {
        	inputArray[i] = random.nextInt(1000);
        }
        long start_time = System.currentTimeMillis();
        System.out.println("Unsorted: " + Arrays.toString(inputArray));
        mergeSort(inputArray);
        long end_time = System.currentTimeMillis();
        long difference = end_time-start_time;
        System.out.println("Sorted: " + Arrays.toString(inputArray));
        System.out.println("Time in milliseconds: " + difference);
    }
}
