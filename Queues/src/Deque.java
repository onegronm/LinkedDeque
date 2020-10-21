import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
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
	public <T> Deque() {
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
		last.previous = oldLast;
		
		if(isEmpty()) first = last;
		else oldLast.next = last; // Constant worst-case time
		
		n++;
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
	
	public Item removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException("Deque is empty.");
		}
		
		Item item = last.item;
		last = last.previous;
		n--;
		
		return item;
	}
	
	
	public static void main(String[] args) {		
		Deque<String> d = new Deque<String>();
		
		String item = new String();
		d.addFirst("a");
		d.addFirst("b");
		d.addFirst("c");
		//System.out.println(d.size());
		item = d.removeFirst();
		item = d.removeFirst();
		item = d.removeFirst();		
		//System.out.println(d.size());
		d.addFirst("a");
		item = d.removeFirst();
		// d.removeFirst(); Deque is empty()
		d.addLast("a");
		d.addLast("b");
		d.addLast("c");
		//System.out.println(d.size());
		item = d.removeLast();
		item = d.removeLast();
		item = d.removeLast();
		//System.out.println(d.size());
		item = null;
		
		for(String s: d)
			System.out.println(s);
	}

	// return an iterator over items in order from front to back
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (current == null)
				throw new NoSuchElementException();
			
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}		
	}
}
