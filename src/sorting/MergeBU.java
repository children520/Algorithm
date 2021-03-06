package sorting;

import edu.princeton.cs.algs4.StdOut;
/*
 * 对于长度为N的任意数组，自底向上的归并排序需要1/2NlgN至NlgN次比较 
 */
public class MergeBU {
	private static Comparable[] aux;//辅助数组
	public static void merge(Comparable[] a,int lo,int mid,int hi) {
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++)
			if(i>mid) a[k]=aux[j++];//左半边用完（取右边的元素）
			else if(j>hi) a[k]=aux[i++];//右半边用完（取左半边的元素）
			else if(less(aux[j], aux[i])) a[k]=aux[j++];//右半边元素小于左半边元素
			else a[k]=aux[i++];//右半边元素大于等于左半边元素
	}
	public static void sort(Comparable[] a) {
		//进行lgn次归并
		int N=a.length;
		aux=new Comparable[N];
		for(int sz=1;sz<N;sz=sz+sz)
			for(int lo=0;lo<N-sz;lo+=sz+sz)//sz子数组大小
				merge(a, lo,lo+sz-1, Math.min(lo+sz+sz-1, N-1));//lo:子数组索引
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
