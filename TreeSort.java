import java.util.*;

// Marcus Mills
// COP3530 - Project 2

/* This sorting method sorts integers by creating a binary tree and performing
an in order traversal to sort the items. */

public class TreeSort
{
  //Declaring the root, and initializing an undeterminate length ArrayList
  private static Node root;
  private static ArrayList<Integer> sorted = new ArrayList<Integer>();

  //The nested Node class
  private static class Node
  {
    int num;
    Node left;
    Node right;

    //Constructor
    public Node(int num)
    {
      this.num = num;
      this.left = null;
      this.right = null;
    }

    public void addNode(int num)
    {
      //Adds the data to the left subtree when it is less than the current node
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

      //Adds the data to the right subtree when it is greater than the current node
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
    //If the root is null, it creates a new root
    if(root == null)
    {
      root = new Node(num);
    }
    //Otherwise, call the addNode function
    else
    {
      root.addNode(num);
    }
  }

  public static void treeSort(int[] arr)
  {
    //Adds each element in the array to the binary tree
    for(int i = 0; i < arr.length; i++)
    {
      add(arr[i]);
    }

    //Performs an in-order traversal
    traverse(root);

    //Adds each item back into array
    for(int i = 0; i < arr.length; i++)
    {
      arr[i] = sorted.get(i);
    }
  }

  private static void traverse(Node node)
  {
    //If the node is null, it must be a leaf
    if(node == null)
    {
      return;
    }
    //Traverses the left node, then adds the data to the sorted arr, then
    //traveres the right node
    traverse(node.left);
    sorted.add(node.num);
    traverse(node.right);
  }
}
