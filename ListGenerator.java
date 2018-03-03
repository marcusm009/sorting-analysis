import java.io.*;
import java.util.Random;
class ListGenerator
{
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
    File file = new File(size+".txt");
    try
    {
      PrintWriter pw = new PrintWriter(file);
      Random random = new Random();
      for(int i = 0; i < size; i++)
      {
        pw.println(random.nextInt(size));        
        //pw.println(random.nextInt(2 * size) - size + 1);
      }
      pw.flush();
      pw.close();
    }
    catch(IOException e)
    {
      System.out.println("Error");
    }
  }
}
