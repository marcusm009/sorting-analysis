import java.util.*;
import java.io.*;

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

    //Constructor that initializes values
    private Node(int num)
    {
      this.num = num;
      this.left = null;
      this.right = null;
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
    clear();
  }

  //Clears the TreeSort object for subsequent use
  private static void clear()
  {
    root = null;
    sorted = new ArrayList<Integer>();
  }

  private static void add(int num)
  {
    //If the root is null, it creates a new root
    if(root == null)
    {
      root = new Node(num);
      return;
    }

    //Initializes curNode to root
    Node curNode = root;
    //Iterates through tree until it finds a leaf and adds a new node to
    //the appropriate spot
    while(true)
    {
      if(num < curNode.num)
      {
        if(curNode.left == null)
        {
          curNode.left = new Node(num);
          return;
        }
        else
        {
          curNode = curNode.left;
        }
      }
      else
      {
        if(curNode.right == null)
        {
          curNode.right = new Node(num);
          return;
        }
        else
        {
          curNode = curNode.right;
        }
      }
    }
  }

  private static void traverse(Node node)
  {
    //If the node is null, there is nothing to traverse
    if(node == null)
    {
      return;
    }

    //Creates a stack in order to avoid StackOverflow exception in the case of
    //deep recursion caused by an uneven tree
    Stack<Node> stack = new Stack<Node>();
    Node curNode = node;

    //Iterates down the left subtree to get initial stack
    while(curNode != null)
    {
      stack.push(curNode);
      curNode = curNode.left;
    }

    //While the stack is greater than zero, it pops the last element off the
    //stack, adds it to the sorted list, then traverses down its right subtree
    while(stack.size() > 0)
    {
      curNode = stack.pop();
      sorted.add(curNode.num);
      if(curNode.right != null)
      {
        curNode = curNode.right;

        while(curNode != null)
        {
          stack.push(curNode);
          curNode = curNode.left;
        }
      }
    }
  }
}
