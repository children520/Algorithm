package Searching;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>,Value> {
	private Key[] keys;
	private Value[] values;
	private int N;
	public BinarySearchST(int capacity) {
		keys=(Key[]) new Comparable[capacity];
		values=(Value[]) new Object[capacity];
	}
	public int size() {
		return N;
	}
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i=rank(key);
		if(i<N&&keys[i].compareTo(key)==0) return values[i];
		else return null;
	}
	public int rank(Key key) {
		int lo=0,hi=N-1;
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			int cmp=key.compareTo(keys[mid]);
			if (cmp<0) {
				hi=mid-1;
			}
			if(cmp>0) {
				lo=mid+1;
			}
			else return mid;
					
		}
		return lo;
	}
	public void put(Key key,Value val) {
		//查找键，找到更新值，否则创建新的元素
		int i=rank(key);
		if(i<N&&keys[i].compareTo(key)==0) {
			values[i]=val;
			return;
		}
		for(int j=N;j>i;j--) {
			keys[j]=keys[j-1];
			values[j]=values[j-1];
			keys[i]=key;
			values[i]=val;
			N++;
		}
		
	}
	
	public boolean isEmpty() {
		return values[0]==null;
	}
	public Key min() {
		return keys[0];
	}
	public Key max() {
		return keys[N-1];
	}
	public Key select(int k) {
		return keys[k];
	}
	//大于等于key的最小键
	public Key ceiling(Key key) {
		int i=rank(key);
		return keys[i];
	}
	//小于等于key的最大键
	public Key floor(Key key) {
		int i=rank(key);
		return keys[i];
	}
	public void delete(Key key) {
		int i=rank(key);
		for(int j=i;j<N-i;j++) {
			keys[j]=keys[++j];
			values[j]=values[j++];
		}
		
	}
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> q=new Queue<Key>();
		for(int i=rank(lo);i<rank(hi);i++)
			q.enqueue(keys[i]);
		if(contains(hi))
			q.enqueue(keys[rank(hi)]);
		return q;
	}
	public boolean contains(Key key) {
		int i=rank(key);
		if(values[i]==null)
			return false;
		else {
			return true;
		}
	}
}
