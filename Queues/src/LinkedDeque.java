import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<Item> implements Iterable<Item> {
	
	private int n; // the size of the deque
	private Node first, last; // the front and rear of the deque
	
	private class Node {
		Item item;
		Node next;
		Node previous;
	}
	
	/**
	 * Construct an empty deque
	 * @param <T>
	 */
	public <T> LinkedDeque() {
		first = null;
		last = null;
	}
	
	/**
	 * Is the deque empty?
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return first == null; // Constant worst-case time
	}
	
	/**
	 * Get the number of items on the deque
	 * @return integer representing number of items in deque
	 */
	public int size() {
		return n; // Constant worst-case time
	}	
	
	/**
	 * Add the item to the front
	 */
	public void addFirst(Item item) {		
		if(item == null)
			throw new IllegalArgumentException("Null argument provided.");
			
		Node oldFirst = first;
		
		Node newNode = new Node();
		newNode.item = item;
		
		if(isEmpty()) {
			// case for first item inserted,
			// next and previous pointers are null
			// this is also the last node
			newNode.next = null;
			newNode.previous = null;
			last = newNode;
		}
		else {
			newNode.next = oldFirst;
			newNode.previous = null; // first node doesn't have a previous
			oldFirst.previous = newNode; // update oldFirst 'previous' to newNode
		}
		
		first = newNode; // update first pointer to newNode
		
		n++; // increment node count
	}
		
	/**
	 * Add item to the back
	 * @param item: the item to insert into the deque
	 */
	public void addLast(Item item) {		
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldLast.next = last; // Constant worst-case time
	}
	
	/**
	 * Remove and return the item from the front
	 * @return
	 */
	public Item removeFirst() {		
		if(isEmpty()) {
			throw new NoSuchElementException("Deque is empty.");
		}
		
		Item item = first.item; // pointer to the item, not to the node
		first = first.next;
		n--;
		
		if(isEmpty()) last = null;
		
		return item;
	}
	
	// public Item removeLast() {
		// Item lastItem = last.item;
		
		// need to implement a doubly-linked list
	// }
	
	
	public static void main(String[] args) {		
		LinkedDeque<String> d = new LinkedDeque<String>();
		
		d.addFirst("a");
		d.addFirst("b");
		d.addFirst("c");
		d.removeFirst();
		d.removeFirst();
		d.removeFirst();		
		System.out.println(d.size());
		d.addFirst("a");
		d.removeFirst();
		// d.removeFirst(); Deque is empty()
	}

	// return an iterator over items in order from front to back
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
