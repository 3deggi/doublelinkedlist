/*
 * Sandy Eggi (sandclow@gmail.com)
 * Double linked list implementation 
 */

import java.util.*;
import java.lang.*;
import java.io.*;

//main class for testing the list implementation
class Driver
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//creating list and adding elements
		Node <Integer>item = new Node<Integer>(2, null, null);
    item.print();     
    for (int i=0;i<10;i++)
    {
         Node <Integer>nitem = new Node<Integer>(i, null, null);
         item.append(nitem);
    }
    Node <Integer>nitem = new Node<Integer>(2, null, null);
    item.append(nitem);
		Node <Integer>middle = new Node<Integer>(999, null, null);
    item.append(middle);
    item.print();
    
    for (int i=0;i<10;i++)
    {
         Node <Integer>nitem2 = new Node<Integer>(i, null, null);
         middle.append(nitem2);
    }
    
    System.out.println("Printing from the beginning");
    item.print();

    //test printing using the middle node
    System.out.println("Printing from the middle");
    middle.print();
    
    //delete the original node
    Node newnode = item.delete();
		System.out.println("After deletion");       
		newnode.print();
		
		//insert elements after deleted element
		newnode.insertNext(new Node<Integer>(100,null,null));
		System.out.println("After insertion");       
		newnode.print();
		
		//reversing
    middle.reverse();
    System.out.println("After reverse");
    middle.print();
	}
}

//node of a list
class Node<T>
{
	  public T data;
    public Node next;
    public Node prev;
    
    public Node(T data, Node next, Node prev)
    {
      this.data = data;
      this.next = next;
      this.prev = prev;
    }
    
    public Node(Node<T> other)
    {
    	this.data = other.data;
    	this.next = other.next;
    	this.prev = other.prev;
    }
    
   //printing the element of list, comma separated format
   public void print()
   {
        String out = "";
        Node fItem = this;
        while (fItem!=null)
		{
            out += (fItem.data + ((fItem.next!=null)?",":""));
            fItem = fItem.next;
		}
		
		if (prev!=null)
			out = "," + out;
			
		fItem = prev;
        while (fItem!=null)
		{
            out = (((fItem.prev!=null)?",":"")+ fItem.data) + out;
            fItem = fItem.prev;
		}
       System.out.println(out);
   }
  
   //adding an element at the end of the list
   public void append(Node item)
   {
        Node fItem = this;
        while (fItem.next!=null)
		{
            fItem = fItem.next;
		}
        fItem.next = item;
        item.prev = fItem;
   }

   public void insertNext(Node inserted)
   {
 		if (next==null)
		{
			//add as the last element
			Node nitem = new Node(inserted);

			next=nitem;
			nitem.prev = this;
		} else
		{
			//insert in the middle
			Node nitem = new Node(inserted);

			nitem.next = next;
			next.prev = nitem;
			
			next = nitem;
			nitem.prev = this;
		}
   }

   //delete the node from the list and return the node with the same index
   public Node delete()
   {
		if (next==null)
		{
			prev.next = null;
			return null;
		} else
		{
			next.prev = prev;
			if (prev!=null)
				prev.next = next;
			return next;
		}
   }

   public void reverse()
   {
   		Node origprev = prev;
   	    Node fItem = this;
        Node p = prev;
        Node n = next;
        while (fItem!=null) //traversing next
		{
            n  = fItem.next;  
   			fItem.next = p;  
   			fItem.prev = n;
   			
   			p = fItem;   
   			fItem = n;
		}
		
		if (origprev!=null)//traversing prev
		{
			fItem = origprev;
			p = fItem.prev;
	        n = fItem.next;
	        while (fItem!=null)
			{
	            p  = fItem.prev;  
	   			fItem.next = p;  
	   			fItem.prev = n;
	   			
	   			n = fItem;   
	   			fItem = p;
			}
		}
   }
}