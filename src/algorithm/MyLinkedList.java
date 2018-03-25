package algorithm;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	private int theSize;
	private int modCount=0;//�����Դӹ��췽������������ı�Ĵ���
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	/*
	 * �������ӵ�ǰһ��Node��������һ��Node����
	 */
	private static class Node<AnyType>{
		public Node(AnyType d,Node<AnyType> p,Node<AnyType> n) {
			data=d;prev=p;next=n;
		}
		public AnyType data;
		public Node<AnyType> prev;//ǰһ�����
		public Node<AnyType> next;//��һ�����
	}
	public void clear() {
		doClear();
	}
	private void doClear() {
		beginMarker=new Node<AnyType>(null, null, null);
		endMarker=new Node<AnyType>(null, beginMarker, null);
		beginMarker.next=endMarker;//���:ͷ�ڵ�ĺ�һ����㼴Ϊβ�ڵ�
		
		theSize=0;
		modCount++;
	}
	public int size() {
		return theSize;
	}
	public boolean isEmpty() {
		return size()==0;
	}
	public boolean add(AnyType x) {
		add(size(),x);
		return true;
	}
	public void add(int idx,AnyType x) {
		addBefore(getNode(idx,0,size()),x);
	}
	public AnyType get(int idx) {
		return getNode(idx).data;
	}
	/*
	 * �û��µ���ֵ
	 */
	public AnyType set(int idx,AnyType newVal) {
		Node<AnyType> p=getNode(idx);
		AnyType oldVal=p.data;
		p.data=newVal;
		return newVal;
	}
	public AnyType remove(int idx) {
		return remove(getNode(idx));
	}
	private AnyType remove(Node<AnyType> p) {
		p.next.prev=p.prev;//ǰһ��������ָ����һ�������
		p.prev.next=p.next;//��һ��������ָ��ǰһ�������
		theSize--;
		modCount++;
		
		return p.data;
	}
	private Node<AnyType> getNode(int idx) {
		return getNode(idx, 0, size()-1);
	}
	private void addBefore(Node<AnyType> p, AnyType x) {
		Node<AnyType> newNode=new Node<>(x, p.prev, p);
		newNode.prev.next=newNode;//��������Ϊǰһ�����������һ��
		p.prev=newNode;//��������Ϊ��ʼ���ǰһ��
		theSize++;
		modCount++;
	}
	private Node<AnyType> getNode(int idx, int lower, int upper) {
		Node<AnyType> p;
		if(idx<lower||idx>upper)
			throw new IndexOutOfBoundsException();
		//��ǰ����
		if(idx<size()/2) {
			p=beginMarker.next;
			for(int i=0;i<idx;i++)
				p=p.next;
		}
		else {
			//�Ӻ�����
			p=endMarker;
			for(int i=size();i>idx;i--)
				p=p.prev;
		}
		return p;
		
		
	}
	@Override
	public Iterator<AnyType> iterator() {
		return (Iterator<AnyType>) new LinkedListIterator();
	}
	private class LinkedListIterator implements Iterable<AnyType>{
		private Node<AnyType> current=beginMarker.next;
		private int expectedModCount=modCount;
		private boolean okToRemove=false;
		public boolean hasNext() {
			return current!=endMarker;//û�е����ڵ�һֱΪtrue
		}
		public AnyType next() {
			if(modCount!=expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if (!hasNext()) 
				throw new java.util.NoSuchElementException();
			AnyType nextItem=current.data;
			current=current.next;
			okToRemove=true;//���next�Ѿ���ִ�ж�û�к����remove
			return nextItem;
			
		}
		public void remove() {
			if(modCount!=expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if(!okToRemove)
				throw new IllegalStateException();
			MyLinkedList.this.remove(current.prev);
			expectedModCount++;
			okToRemove=false;
		}
		@Override
		public Iterator<AnyType> iterator() {
			return null;
		}
		
	}
}
