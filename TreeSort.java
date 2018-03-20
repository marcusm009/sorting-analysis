import java.util.*;

public class TreeSort
{
  private static Node root;
  private static ArrayList<Integer> sorted = new ArrayList<Integer>();

  private static class Node
  {
    int num;
    Node left;
    Node right;

    public Node(int num)
    {
      this.num = num;
      this.left = null;
      this.right = null;
    }

    public void addNode(int num)
    {
      if(num < this.num)
      {
        if(left == null)
        {
          left = new Node(num);
        }
        else
        {
          left.addNode(num);
        }
      }
      if(num >= this.num)
      {
        if(right == null)
        {
          right = new Node(num);
        }
        else
        {
          right.addNode(num);
        }
      }
    }
  }

  public static void add(int num)
  {
    if(root == null)
    {
      root = new Node(num);
    }
    else
    {
      root.addNode(num);
    }
  }

  public static void treeSort(int[] list)
  {

    for(int i = 0; i < list.length; i++)
    {
      add(list[i]);
    }

    traverse(root);

    for(int i = 0; i < list.length; i++)
    {
      list[i] = sorted.get(i);
    }
  }

  private static void traverse(Node node)
  {
    if(node == null)
    {
      return;
    }
    traverse(node.left);
    sorted.add(node.num);
    traverse(node.right);
  }
}
