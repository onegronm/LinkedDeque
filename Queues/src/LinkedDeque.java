import java.util.Iterator;

public class LinkedDeque<Item> implements Iterable<Item> {
	
	private Node first = null, last = null;
	
	private class Node {
		Item item;
		Node next;
	}
	
	// construct an empty deque
	public <T> LinkedDeque(){

		System.out.println("Hello World!");
	}
	
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
