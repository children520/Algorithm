package sorting;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);//消除对输入的依赖
		sort(a,0,a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a, lo, j-1);
		sort(a,j+1,hi);
		
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i=lo,j=hi+1;//左右扫描指针
		Comparable v=a[lo];//切分元素
		while(true) {
			//扫描左右，检查扫描是否结束并交换元素
			while(less(a[++i], v)) if(i==hi) break;
			while(less(v, a[--j])) if(j==lo) break;
			if(i>=j) break;
			exch(a, i, j);
		}
		return 0;
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
