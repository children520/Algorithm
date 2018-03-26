package sorting;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
/*
 * 对于一个含有N个元素的基于堆的优先队列
 * 插入元素操作只需不超过（lgN+1)次比较
 * 删除最大元素的操作不超过2lgN次比较
 */
public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;//基于堆的完全二叉树
	private int N=0;
	public MaxPQ(int maxN) {
		pq=(Key[]) new Comparable[maxN+1];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	public void insert(Key v) {
		pq[++N]=v;
		swim(N);
	}
	public Key delMax() {
		Key max=pq[1];//从根结点得到最大元素
		exch(1,N--);//和最后一个结点交换
		pq[N+1]=null;//防止对象游离
		sink(1);//恢复堆的有序性
		return max;
	}
	private void sink(int i) {
		while(2*i<=N) {
			int j=2*i;//子节点
			if(j<N&&less(j, j+1)) j++;//比较左右子结点
			if(!less(i, j)) break;//父节点不比子节点小
			exch(i, j);//否则交换
			i=j;
		}
	}
	private  void sink(Comparable[] a,int i,int k) {
			while(2*i<=N) {
				int j=2*i;//子节点
				if(j<N&&less(j, j+1)) j++;//比较左右子结点
				if(!less(i, j)) break;//父节点不比子节点小
				exch(i, j);//否则交换
				i=j;
			}	
	}
	
	private void exch(int i, int j) {
		Key t=pq[i];pq[i]=pq[j];pq[j]=t;
	}
	private void swim(int k) {
		while(k>1&&less(k/2, k)) {
			exch(k/2, k);//父节点比子节点小时，交换数值
			k=k/2;
		}
		
	}
	private boolean less(int i,int j) {
		return pq[i].compareTo(pq[j])<0;
				 
	}
	private static void exch(Comparable[] a,int i,int j) {
		//交换两个数
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void sort(Comparable[] a) {
		int N=a.length;
		for(int k=N/2;k>=1;k--)
			sink(a,k,N);//递归的建立堆的秩序
		while(N>1) {
			exch(a, 1, N--);//下沉排序
			sink(a, 1, N);
		}
	}

}
