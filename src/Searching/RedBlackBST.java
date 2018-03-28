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
	//左旋转h的右链接
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
	//颜色变化
	private void flipColors(Node h) {
		h.color=RED;
		h.left.color=BLACK;
		h.right.color=BLACK;
		
	}
	public void put(Key key,Value val) {
		//查找key,找到则更新其值，否则为它新建一个结点
		root=put(root, key,val);
		root.color=BLACK;//根结点总是为黑色
	}
	private Node put(Node h,Key key,Value val) {
		if(h==null) //标准的插入操作
			return new Node(key, val, 1, RED);
		int cmp=key.compareTo(h.key);
		if(cmp<0) h.left=put(h.left, key, val);
		else if(cmp>0) h.right=put(h.right, key, val);
		else h.val=val;
		
		if(isRed(h.right)&&isRed(h.left)) h=rotateLeft(h);//右结点为红色，左结点黑色，进行左旋转
		if(isRed(h.left)&&isRed(h.left.left)) h=rotateRight(h);//左结点且它的左结点为红，进行右旋转
		if(isRed(h.left)&&isRed(h.right)) flipColors(h);//左右结点为红，进行颜色变化
		h.N=size(h.left)+size(h.right)+1;
		return h;
	}
}
