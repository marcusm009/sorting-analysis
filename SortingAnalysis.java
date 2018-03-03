import java.io.*;
import java.util.Scanner;

class SortingAnalysis
{

  public static void main(String[] args)
  {
    int size = 5000;
    int[] arr = fileToArray(size);
    printArray(arr);

    System.out.println("\n");

    RadixSort.radixsort(arr, size);
    printArray(arr);
  }

  public static int[] fileToArray(int size)
  {
    File file = new File(size + ".txt");
    int[] arr = new int[size];

    try
    {
      Scanner scan = new Scanner(file);

      for(int i = 0; i < size; i++)
      {
        arr[i] = scan.nextInt();
      }
      scan.close();
    }
    catch(FileNotFoundException ex)
    {
      System.out.println("error");
    }

    return arr;
  }

  public static void printArray(int[] arr)
  {
    for(int i = 0; i < arr.length; i++)
    {
      System.out.println(arr[i]);
    }
  }
}
