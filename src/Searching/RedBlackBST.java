package Searching;

import javax.xml.soap.Node;
/*
 * 红链接：两个2-结点连接成一个3-结点
 * 黑链接：2-3树的普通链接
 * 红黑树等价定义：
 * 1.红链接均为左链接
 * 2.没有任何一个结点同时和两条红链接相连
 * 3.任意空连接到根结点的路径上的黑链接数量相同
 * 
 */
public class RedBlackBST<Key extends Comparable<Key>,Value>{
	private Node root;
	private static final boolean RED=true;//红链接将两个2-结点连接成一个3-结点
	private static final boolean BLACK=false;
	private class Node{
		Key key;//键
		Value val;//相关联的值
		Node left,right;//左右子树
		int N;//这棵子树中的结点总数
		boolean color;
		Node(Key key,Value val,int N,boolean color){
			//Node对象
			this.key=key;
			this.val=val;
			this.N=N;
			this.color=color;
		}
	}
	private boolean isRed(Node x) {
		if(x==null) return false;
		return x.color==RED;
	}
	private Node rotateLeft(Node h) {
		Node x=h.right;
		h.right=x.left;
		x.left=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.right)+size(h.left);
		return x;
	}
	private Node rotateRight(Node h) {
		Node x=h.left;
		h.left=x.right;
		x.right=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.left)+size(h.right);
		return x;
	}
	public int size(Node x) {
		if(x==null) return 0;
		else return x.N;
	}
}
