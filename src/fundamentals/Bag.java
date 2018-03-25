package fundamentals;

import java.util.Iterator;

import javax.xml.soap.Node;

import org.omg.CORBA.Current;

public class Bag<Item> implements Iterable<Item>{
	private Node first;
	private class Node{
		Item item;
		Node next;
	}
	public void add(Item item) {
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node Current =first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return Current!=null;
		}

		@Override
		public Item next() {
			Item item =Current.item;
			Current=Current.next;
			return item;
		}
		
	}

}
