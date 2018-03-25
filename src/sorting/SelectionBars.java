package sorting;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
/*
 * 选择排序的可视轨迹
 */
public class SelectionBars {
	public static void sort(double[] a) {
		int n=a.length;
		for(int i=0;i<n;i++) {
			int min=i;
			for(int j=i+1;j<n;j++)
				if(less(a[j], a[min])) min=j;
			show(a,i,min);
			exch(a, i, min);
		}
	}
	private static boolean less(Comparable v,Comparable w) {
		////表示v<w
		return v.compareTo(w)<0;
	}
	private static void show(double[] a,int i,int min) {
		StdDraw.setYscale(-a.length+i+1,i);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		for(int k=0;k<i;k++)
			StdDraw.line(k,0, k, a[k]*0.6);
		StdDraw.setPenColor(StdDraw.BLACK);
		for(int k=i;k<a.length;k++)
			StdDraw.line(k, 0, k, a[k]*0.6);
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.line(min, 0, min, a[min]*0.6);
	}
	private static void exch(double[] a,int i,int j) {
		double t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	public static void main(String[] args) {
		int n=5;
		StdDraw.setCanvasSize(160,800);
		StdDraw.setXscale(-1,n+1);
		StdDraw.setPenRadius(0.006);
		double[] a=new double[n];
		for(int i=0;i<n;i++)
			a[i]=StdRandom.uniform(0.0,1.0);
		sort(a);
	}
}
