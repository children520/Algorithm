package sorting;

import edu.princeton.cs.algs4.StdOut;

public class Quick3way {
	private static void sort(Comparable[] a,int lo,int hi) {
		if(hi<=lo) return;
		int lt=lo,i=lo+1,gt=hi;
		Comparable v=a[lo];
		while(i<=gt) {
			int cmp=a[i].compareTo(v);
			if(cmp<0) exch(a, lt++, i++);
			else if(cmp>0) exch(a, i, gt--);
			else i++;
		}
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}
	private static boolean less(Comparable v,Comparable w) {
		////表示v<w
		return v.compareTo(w)<0;
	}
	private static void show(Comparable[] a) {
		// 从单行打印数组
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}
	private static boolean isSorted(Comparable[] a) {
		//测试数组是否有序
		for(int i=1;i<a.length;i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}
	private static void exch(Comparable[] a,int i,int j) {
		//交换两个数
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
}
