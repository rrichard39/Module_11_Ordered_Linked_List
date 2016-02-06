//import dataStructures.*;
//import dataStructures.LinkedList.ListNode;
//
//package dataStructures;

/**
 *	Class OrderedLinkedList
 *
 *	This class functions as a linked list, but ensures items are stored in ascending order.
 *
 */
public class OrderedLinkedList
{
	
	/**************************************************************************
	 * Constants
	 *************************************************************************/
	
	/** return value for unsuccessful searches */
	private static final OrderedListNode NOT_FOUND = null;
	

	/**************************************************************************
	 * Attributes
	 *************************************************************************/

	/** current number of items in list */
	private int theSize;
	
	/** reference to list header node */
	private OrderedListNode head;
	
	/** reference to list tail node */
	private OrderedListNode tail;
	
	/** current number of modifications to list */
	private int modCount;
	
	
	/**************************************************************************
	 * Constructors
	 *************************************************************************/

	
	/**
	 *	Create an instance of OrderedLinkedList.
	 *
	 */
	public OrderedLinkedList()
	{
		// empty this OrderedLinkedList
		clear();
	}
	
	
	/**************************************************************************
	 * Methods
	 *************************************************************************/


	/*
	 *	Add the specified item to this OrderedLinkedList.
	 *
	 *	@param	obj		the item to be added
	 */
	public boolean add(Comparable obj)
	{
		OrderedListNode newItem = new OrderedListNode(obj, null, null);
		OrderedListNode nextItem = head.next;
		OrderedListNode previousItem = head;
		
		if (!head.next.equals(tail))
		{
			while (nextItem != null && nextItem.theItem.compareTo(obj) < 0)
			{
				previousItem = nextItem;
				nextItem = previousItem.next;
				if (nextItem.equals(tail))
				{
					break;
				}
			}
			previousItem.next = newItem;
			newItem.previous = previousItem;
			newItem.next = nextItem;
			nextItem.previous = newItem;
		}
		else
		{
			head.next = newItem;
			newItem.previous = head;
			tail.previous = newItem;
			newItem.next = tail;
		}
		theSize++;
		modCount++;
		return true;
	}

	
	/*
	 *	Remove the first occurrence of the specified item from this OrderedLinkedList.
	 *
	 *	@param	obj		the item to be removed
	 */
	public boolean remove(Comparable obj)
	{
		OrderedListNode nextItem = head.next;
		OrderedListNode previousItem = head;
		
		if (!head.next.equals(tail))
		{
			while (nextItem.theItem.compareTo(obj) < 0)
			{
				previousItem = nextItem;
				nextItem = previousItem.next;
				if (nextItem.equals(tail))
				{
					break;
				}
			}
			if (!nextItem.equals(tail) && nextItem.theItem.compareTo(obj) == 0)
			{
				previousItem.next = nextItem.next;
				nextItem.next.previous = previousItem;
				theSize--;
				modCount++;
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	
	/**
	 *	Empty this OrderedLinkedList.
	 */
	public void clear()
	{
		// reset header node
		head = new OrderedListNode("HEAD", null, null);
		
		// reset tail node
        tail = new OrderedListNode("TAIL", head, null);
        
        // header references tail in an empty LinkedList
        head.next = tail;
        
        // reset size to 0
		theSize = 0;
		
		// emptying list counts as a modification
		modCount++;
	}


	/**
	 *	Return true if this OrderedLinkedList contains 0 items.
	 */
	public boolean isEmpty()
	{
		return theSize == 0;
	}


	/**
	 *	Return the number of items in this OrderedLinkedList.
	 */
	public int size()
	{
		return theSize;
	}
	

	/*	
	 *	Return a String representation of this OrderedLinkedList.
	 *
	 *	(non-Javadoc)
     *	@see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
    	String s = "";
    	
    	OrderedListNode currentNode = head.next;
    	
    	while (currentNode != tail)
    	{
    		s += currentNode.theItem.toString();
    		
    		if (currentNode.next != tail)
    		{
    			s += ", ";
    		}
    		
    		currentNode = currentNode.next;
    	}
    	
    	return s;
    }

	
	/**************************************************************************
	 * Inner Classes
	 *************************************************************************/
	

	/**
	 *	Nested class OrderedListNode.
	 *
	 *	Encapsulates the fundamental building block of an OrderedLinkedList
	 *	contains a data item, and references to both the next and previous nodes
	 *	in the list
	 */
	
	
	// TODO: Implement the nested class OrderedListNode (5 points).  This nested class
	// should be similar to the nested class ListNode of the class LinkedList, but
	// should store a data item of type Comparable rather than Object.
    
    private class OrderedListNode
    {
    	Comparable theItem;
    	OrderedListNode next;
    	OrderedListNode previous;

    	public OrderedListNode()
    	{
    	}

    	public OrderedListNode(Comparable item, OrderedListNode previousNode, OrderedListNode nextNode)
    	{
    		theItem = item;
    		previous = previousNode;
    		next = nextNode;
    	}
    }
    
}
