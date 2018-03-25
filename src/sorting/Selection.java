package sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
/*
 * 选择 排序：找到数组最小的元素
 * 将它和数组的第一个元素交换位置
 * 以此类推，第二个元素交换位置
 */
public class Selection {
	public static void sort(Comparable[] a) {
		int N=a.length;
		for(int i=0;i<N;i++) {
			int min=i;
			for(int j=i+1;j<N;j++)
				if(less(a[j],a[min])) min=j;
			exch(a,i,min);
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
	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		String[] a=In.readStrings("https://algs4.cs.princeton.edu/21elementary/tiny.txt");
		sort(a);
		show(a);		
		}
}
