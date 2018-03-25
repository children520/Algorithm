package sorting;

import edu.princeton.cs.algs4.StdOut;

public class ShellSort {
	public static void sort(Comparable[] a) {
		int N=a.length;
		int h=1;
		while(h<N/3) h=3*h+1;
		while(h>=1) {
			for(int i=h;i<N;i++) {
				for(int j=i;j>=h&&less(a[j], a[j-h]);j-=h)
					exch(a, j, j-h);
			}
			h=h/3;
		}
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
