import java.util.Random;
import java.util.Arrays;

public class CompareSort
{
    public static void main(String[] args)
    {
        // Parameters for array creation.
        int size = 100; 
        int start = 1;
        int end = 100;
        int[] randomArray = RandomizedArray(size, start, end);

        // Record time when program begins. 
        long startTime = System.nanoTime();

        // Calling bubble sort function. 
        BubbleSort(randomArray);
        
        long endTime = System.nanoTime();
        // Subtracting the end time from the start time for total run time.
        long elapsedTime = endTime - startTime;
        
        
        long startTime1 = System.nanoTime();

        // Calling selection sort function. 
        SelectionSort(randomArray);
        
        long endTime1 = System.nanoTime();
        long elapsedTime1 = endTime1 - startTime1;
        
        
        long startTime2 = System.nanoTime();

        // Calling insertion sort function. 
        InsertionSort(randomArray);
        
        long endTime2 = System.nanoTime();
        long elapsedTime2 = endTime2 - startTime2;
        
        System.out.println("Sorting a random array size of " + size + " took bubble sort " + elapsedTime + " nanoseconds to complete.");
        System.out.println("Sorting a random array size of " + size + " took selection sort " + elapsedTime1 + " nanoseconds to complete.");
        System.out.println("Sorting a random array size of " + size + " took insertion sort " + elapsedTime2 + " nanoseconds to complete.");
    }
    public static int[] RandomizedArray(int size, int start, int end)
    {
        // Creating an array of size "size". 
        int[] arrayResult = new int[size];
        Random random = new Random(); 
        
        for(int i = 0; i < size; i++)
        {
            // Filling the array with random values between start and end. 
            int randomVal = random.nextInt(end) + start;
            arrayResult[i] = randomVal;
        }
        return arrayResult;
    }
    public static void BubbleSort(int[] arr)
    {
        boolean swap; 
        int n = arr.length;
        
        for(int i = 0; i < n -1; i++)
        {
            swap = false;
            for(int j = 0; j < n - i - 1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    // If array needs to be changed, temp holds spot at j, and j and j+1 are flipped. 
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // Boolean is reset to true to tell program to keep going. 
                    swap = true;
                }
            }
            if(swap == false)
            {
                // When there is no more swaps to be made, code ends. 
                break;
            }
        }
        
        System.out.println(Arrays.toString(arr));
    }
    public static void SelectionSort(int[] arr)
    {
        int n = arr.length;
        
        for(int i = 0; i < n - 1; i++)
        {
            // Start with assuming i is the lowest value.
            int min = i;
            
            for(int j = i + 1; j < n; j++)
            {
                if(arr[j] < arr[min])
                {
                    // Lowest value is changed based on if a lower value is found going through the array. 
                    min = j;
                }
            }
            // The first spot in the array is filled with the lowest found number. 
            int temp1 = arr[i];
            arr[i] = arr[min];
            arr[min] = temp1;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void InsertionSort(int[] arr)
    {
        int n = arr.length;
        
        for(int i = 1; i < n -1; i++)
        {
            // The number we are comparing is the spot in the array at i. 
            int key = arr[i]; 
            // J is the spot in the array to the left of i. 
            int j = i - 1;
            
            while(j >= 0 && arr[j] > key)
            {
                // If the spot to the left of i in the array is larger, they are flipped. 
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}
