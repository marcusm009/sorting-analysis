// Marcus Mills
// COP3530 - Project 2

/* This sorting method uses partitions and recursion to sort an array of
integers. Quicksort is regarded as one of the most efficient sorting methods */

public class QuickSort
{
  //A helper method for the initial call
  public static void quickSort(int[] arr)
  {
    quickSort(arr, 0, arr.length - 1);
  }

  //The main sorting method
  public static void quickSort(int[] arr, int start, int end)
  {
    //Initializes the midpoint of the partition at zero
    int mid = 0;

    //If the start index is greater than the end, it returns
    if(start >= end)
    {
      return;
    }

    //Calculates the new midpoint of the partition by calling the partition
    //function
    mid = partition(arr, start, end);

    //Calls quicksort on both partitions
    quickSort(arr, start, mid);
    quickSort(arr, mid + 1, end);

    return;
  }

  private static int partition(int[] arr, int start, int end)
  {
    //Declares and initializes variables
    int low, high, midpoint, pivot;
    boolean done = false;
    int temp = 0;

    //Initializes the low and high indices to the start and end
    low = start;
    high = end;

    //Calculates the midpoint and pivot
    midpoint = low + (high - low) / 2;
    pivot = arr[midpoint];

    while(!done)
    {
      //Increments the low index as long as each number is less than the pivot
      while(arr[low] < pivot)
      {
        low++;
      }

      //Decrements the high index as long as each number is greater than the pivot
      while(arr[high] > pivot)
      {
        high--;
      }

      //If low is greater than high, the data is successfully partitioned
      if(low >= high)
      {
        done = true;
      }
      //Otherwise, it swaps the two numbers and moves the low and high indices
      //along
      else
      {
        temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;

        low++;
        high--;
      }
    }
    return high;
  }
}
