public class QuickSort
{
  public static void quickSort(int[] list, int start, int end)
  {
    int mid = 0;

    if(start >= end)
    {
      return;
    }

    mid = partition(list, start, end);

    quickSort(list, start, mid);
    quickSort(list, mid + 1, end);

    return;
  }

  private static int partition(int[] list, int start, int end)
  {
    int low, high, midpoint, pivot;
    boolean done = false;
    int temp = 0;

    low = start;
    high = end;

    midpoint = low + (high - low) / 2;
    pivot = list[midpoint];

    while(!done)
    {
      while(list[low] < pivot)
      {
        low++;
      }

      while(list[high] > pivot)
      {
        high--;
      }

      if(low >= high)
      {
        done = true;
      }
      else
      {
        //Swaps the two numbers
        temp = list[low];
        list[low] = list[high];
        list[high] = temp;

        low++;
        high--;
      }
    }
    return high;
  }
}
