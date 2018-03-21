import java.io.*;
import java.util.Random;

// Marcus Mills
// COP3530 - Project 2

/* This class is used to generate lists of random integers in random,
ascending, and descending order */

class ListGenerator
{
  //Generates all the filesizes listed
  public static void main(String[] args)
  {
    generate(10);
    generate(5000);
    generate(10000);
    generate(20000);
    generate(50000);
  }

  public static void generate(int size)
  {
    //Initializes an array and a random object
    int[] arr = new int[size];
    Random random = new Random();

    //Generates array
    for(int i = 0; i < size; i++)
    {
      arr[i] = random.nextInt(size);
    }

    //Writes to file
    write(arr);

    //Sorts for ascending order using quickSort and writes to a file
    QuickSort.quickSort(arr);
    write(arr, "_asc");

    //Reverses array for descending order and writes to a file
    reverse(arr);
    write(arr, "_dsc");

  }

  //Helper method
  public static void write(int[] arr)
  {
    write(arr, "");
  }

  //Writes to file
  public static void write(int[] arr, String postfix)
  {
    File file = new File(arr.length+postfix+".txt");
    try
    {
      PrintWriter pw = new PrintWriter(file);
      for(int i = 0; i < arr.length; i++)
      {
        pw.println(arr[i]);
      }
      pw.flush();
      pw.close();
    }
    catch(IOException e)
    {
      System.out.println("Error");
    }
  }

  //Reverses an array
  public static void reverse(int[] arr)
  {
    for(int i = 0; i < arr.length / 2; i++)
    {
      int temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = temp;
    }
  }
}
