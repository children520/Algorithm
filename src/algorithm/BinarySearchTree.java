package algorithm;


public class BinarySearchTree extends Comparable<? super AnyType>{
	private static class BinaryNode<AnyType>{
		public BinaryNode(AnyType theElement) {
			this(theElement,null,null);
		}
		public BinaryNode(AnyType theElement,BinaryNode lt,BinaryNode rt) {
			element=theElement;
			left=lt;
			right=rt;
		}
		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
	}
	private BinaryNode<AnyType> root;
	public BinarySearchTree() {
		root=null;
	}
	public void makeEmpty() {
		root=null;
	}
	public boolean isEmpty() {
		return root==null;
	}
	public boolean contains(AnyType x) {
		return contains(x,root);
	}
	//返回最小元的引用
	public AnyType findMin() {
		if(isEmpty()) throw new UnderflowException();
		return findMin(root).element;
	}
	//返回最大元的引用
	public AnyType findMax() {
		if(isEmpty()) throw new UnderflowException();
		return findMax(root).element;
	}
	public void insert(AnyType x) {
		root=insert(x,root);
	}
	public void remove(AnyType x) {
		root=remove(x,root);
	}
	public void printTree() {
		
	}
	/*
	 * 树中存在含有项X的节点，返回true,反之。
	 */
	private boolean contains(AnyType x,BinaryNode<AnyType> t) {
		//首先对空树进行测试
		if(t==null)
			return false;
		int compareResult=x.compareTo(t.element);
		if(compareResult<0)
			return contains(x, t.left);
		else if(compareResult>0)
			return contains(x, t.right);
		else 
			return true;
	}
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
		if(t==null)
			return null;
		else if(t.left==null) 
			return  t;
		return findMin(t.left);
	}
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
		if(t!=null)
			while(t.right!=null)
				t=t.right;
		return t;
	}
	private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
		if(t==null)
			return new BinaryNode<>(x,null,null);
		int compareResult=x.compareTo(t.element);
		if(compareResult<0)
			t.left=insert(x, t.left);
		if(compareResult>0)
			t.right=insert(x, t.right);
		else;
		return t;
	}
	private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t){
		if(t==null)
			return t;
		int compareResult=x.compareTo(t.element);
		if(compareResult<0)
			t.left=remove(x,t.left);
		else if(compareResult>0)
			t.right=remove(x, t.right);
		else if(t.left!=null&&t.right!=null) {
			t.element=findMin(t.right).element;
			t.right=remove(t.element, t.right);
		}
		else 
			t=(t.left!=null)?t.left:t.right;
		return t; 
	}
}
