import java.util.Iterator;

public class LinkedDeque<Item> implements Iterable<Item> {
	
	private Node first, last;
	
	private class Node {
		Item item;
		Node next;
	}
	
	// construct an empty deque
	public <T> LinkedDeque(){
		first = null;
		last = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// return an iterator over items in order from front to back
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
