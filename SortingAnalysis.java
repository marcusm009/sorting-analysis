import java.io.*;
import java.util.Scanner;

// Marcus Mills
// COP3530 - Project 2

/* This class is used to determine the time complexity of two different
sorting methods, namely QuickSort and TreeSort */

class SortingAnalysis
{
  public static void main(String[] args)
  {
    //Initializes size
    int size = 5000;

    //Creates randomly ordered arrays
    int[] arr1 = fileToArray(size, "");
    int[] arr2 = fileToArray(size, "");

    //Creates ascending ordered arrays
    int[] arr1_asc = fileToArray(size, "_asc");
    int[] arr2_asc = fileToArray(size, "_asc");

    //Creates descending ordered arrays
    int[] arr1_dsc = fileToArray(size, "_dsc");
    int[] arr2_dsc = fileToArray(size, "_dsc");

/*
    //Sorts and measures the sorting methods on randomly ordered arrays
    System.out.println("Random:");
    test(arr1, true);
    test(arr2, false);
    System.out.println();
*/
    //Sorts and measures the sorting methods on ascending ordered arrays
    System.out.println("Ascending:");
    test(arr1_asc, true);
    test(arr2_asc, false);
    System.out.println();
/*
    //Sorts and measures the sorting methods on descending ordered arrays
    System.out.println("Descending:");
    test(arr1_dsc, true);
    test(arr2_dsc, false);
    System.out.println();
    */
  }

  public static void test(int[] arr, boolean tree)
  {
    //Declares variables
    long start, end, elapsed;
    //If tree, use treeSort
    if(tree)
    {
      start = System.currentTimeMillis();
      TreeSort.treeSort(arr);
      end = System.currentTimeMillis();
      elapsed = end-start;
      System.out.println("BTS: " + elapsed + "ms");
    }
    //Otherwise, use quicksort
    else
    {
      start = System.currentTimeMillis();
      QuickSort.quickSort(arr);
      end = System.currentTimeMillis();
      elapsed = end-start;
      System.out.println("QS: " + elapsed + "ms");
    }
  }

  //Converts the files to an array for ease of use
  public static int[] fileToArray(int size, String postfix)
  {
    File file = new File(size + postfix + ".txt");
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

  //Method to print an array for debugging purposes
  public static void print(int[] arr)
  {
    for(int i = 0; i < arr.length; i++)
    {
      System.out.println(arr[i]);
    }
    System.out.println();
  }

}
