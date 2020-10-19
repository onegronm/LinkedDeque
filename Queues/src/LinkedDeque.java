import java.util.Iterator;

public class LinkedDeque<Item> implements Iterable<Item> {
	
	private int n; // the size of the deque
	private Node first, last; // the front and rear of the deque
	
	private class Node {
		Item item;
		Node next;
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
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst; // Constant worst-case time
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
		Item item = first.item; // Pointer to the item, not to the node!
		first = first.next;
		if(isEmpty()) last = null;
		return item;
	}
	
	// public Item removeLast() {
		// Item lastItem = last.item;
		
		// need to implement a doubly-linked list
	// }
	
	
	public static void main(String[] args) {
		
		LinkedDeque<Integer> d = new LinkedDeque<Integer>();
		
	}

	// return an iterator over items in order from front to back
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
