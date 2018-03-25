package sorting;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
/*
 * 插入排序：将其他元素在插入之前都向右移一位
 */
public class Insertion {
	public static void sort(Comparable[] a) {
		int N=a.length;
		for(int i=1;i<N;i++) {
			//将a[i]插入到a[i-1],a[i-2],a[i-3]
			for(int j=i;j>0&&less(a[j],a[j-1]);j--) {
				exch(a, j, j-1);
			}
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
