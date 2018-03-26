package Searching;

import javax.xml.soap.Node;
/*
 * 符号表基于链表的实现
 */
public class SequentialSearchST<Key,Value> {
	private Node first;//首结点
	private class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key,Value val,Node next) {
			this.key=key;
			this.val=val;
			this.next=next;
		}
	}
	public Value get(Key key) {
		//查找给定的键，返回相关的值
		for(Node x=first;x!=null;x=x.next)
			if(key.equals(x.key))
				return x.val;
		return null;
	}
	public void put(Key key,Value val) {
		//查找给定的键，找到并更新其值，否则在表中新建结点
		for(Node x=first;x!=null;x=x.next)
			if(key.equals(x.key)) {
				x.val=val;
				return;
			}
		first=new Node(key, val, first);
	}
	

}
