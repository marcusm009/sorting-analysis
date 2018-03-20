import java.io.*;
import java.util.Scanner;

class SortingAnalysis
{

  public static void main(String[] args)
  {
    int size = 10;
    ListGenerator.generate(size);
    int[] arr1 = fileToArray(size);
    int[] arr2 = fileToArray(size);

    print(arr1);
    System.out.println("\n");
    print(arr2);
    System.out.println("\n");

    long start1 = System.currentTimeMillis();
    TreeSort.treeSort(arr1);
    long end1 = System.currentTimeMillis();

    long start2 = System.currentTimeMillis();
    QuickSort.quickSort(arr2, 0, arr2.length - 1);
    long end2 = System.currentTimeMillis();

    long elapsed1 = end1 - start1;
    long elapsed2 = end2 - start2;

    print(arr1);
    System.out.println("\n");
    print(arr2);
    System.out.println("\n");

    System.out.println("BTS: " + elapsed1 + "ms");
    System.out.println("QS: " + elapsed2 + "ms");


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

  public static void print(int[] arr)
  {
    for(int i = 0; i < arr.length; i++)
    {
      System.out.println(arr[i]);
    }
  }
}
