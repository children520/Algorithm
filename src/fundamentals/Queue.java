package fundamentals;

import java.util.Iterator;

import javax.xml.soap.Node;

public class Queue<Item> implements Iterable<Item>{
	private Node first;//指向最早添加的结点的链接
	private Node last;//指向最近添加的结点的链接
	private int N;//队列元素的数量
	//定义结点的嵌套类
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return first==null;
	}
	public int size() {
		return N;
	}
	//表尾添加元素
	public void enqueue(Item item) {
		Node oldlast=last;//保存指向链表的链接
		last=new Node();//创建新的首结点
		last.item=item;//设置新结点的实例变量
		last.next=null;
		if(isEmpty()) first=last;
		else oldlast.next=last;
		N++;
	}
	//表头删除元素
	public Item dequeue() {
		Item item=first.item;//保存结点的数据
		first=first.next;//将下一个指针指向第一个
		if(isEmpty()) last=null;
		N--;
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current=first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			Item item =current.item;
			current=current.next;
			return item;
		}
		public void remove() {}
		
	}
}
