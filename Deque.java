import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
   
   private Node first = null;
   private Node last  = null;
   private int size = 0;
   
   private class Node
   {
       Item item;
       Node next;
       Node previous;
   }
   
   public Deque() {}                  // construct an empty deque

   public boolean isEmpty()           // is the deque empty?   
   {
       return  (first == null);
   }
   
   public int size()                  // return the number of items on the deque   
   {
       return size;
   }
   
   public void addFirst(Item item)    // insert the item at the front     
   {
       if (item == null) { throw new java.lang.NullPointerException("Cannot insert a null."); }
       else {
       
           Node oldfirst = first;
           first = new Node();
           first.item = item;
           first.next = oldfirst;
           first.previous = null;
           
           // check whether linked list was empty
           if (oldfirst == null) {
               last = first;
           }
           else {
               oldfirst.previous = first;
           }
                 
           size++;
           return;
       }
   }
   
   public void addLast(Item item)     // insert the item at the end
   {
       if (item == null) { throw new java.lang.NullPointerException("Cannot insert a null."); }
       else {
           
           Node oldlast = last;
           last = new Node();
           last.item = item;
           last.next = null;

           // check whether linked list was empty
           if (oldlast == null) {
               first = last;
               last.previous = null;
           }
           else {
               oldlast.next = last;
               last.previous = oldlast;
           }
           
           size++;
           return;
       }
   }    
       
   public Item removeFirst()          // delete and return the item at the front
   {
       if (first == null) { throw new java.util.NoSuchElementException("Cannot remove item from empty deque"); }
       else {
           Item ret = first.item;
           first = first.next; 
           
           if (first != null) { first.previous = null; }
           
           size--;
           return ret;
       }
   }
   
   public Item removeLast()           // delete and return the item at the end
   {
       if (last == null) { throw new java.util.NoSuchElementException("Cannot remove item from empty deque"); }
       else {
           Item ret = last.item;
           last = last.previous;
           
           if (last != null) {last.next = null;}
           size--;
           return ret;
       }       
   }
       
   public Iterator<Item> iterator()   // return an iterator over items in order from front to end
   {
       return new DequeIterator();
   }
   
   private class DequeIterator implements Iterator<Item> {
       private Node current = first;
       
       public boolean hasNext() {return (current != null); }
       public void remove() { throw new java.lang.UnsupportedOperationException ("Unsupported operation."); }
       
       public Item next() 
       { 
           if (current == null) {throw new java.util.NoSuchElementException("No more elements.");}
           
           else { 
               Item ret = current.item;
               current = current.next;
               return ret; 
           }
       }
   }
   
   public static void main(String[] args) {
       return;
   }
}