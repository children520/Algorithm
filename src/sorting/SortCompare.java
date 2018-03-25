package sorting;

import edu.princeton.cs.algs4.BinaryInsertion;
import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.InsertionX;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
/*
 * 比较插入排序和选择排序
 */
public class SortCompare {
	public static double time(String alg,Comparable[] a) {
		Stopwatch timer=new Stopwatch();//计时器
		if(alg.equals("Insertion")) Insertion.sort(a);
		else if(alg.equals("Selection")) Selection.sort(a);
		else if(alg.equals("Shell")) Shell.sort(a);
		else if(alg.equals("Merge")) Merge.sort(a);
		else if(alg.equals("Quick")) Quick.sort(a);
		else if(alg.equals("Heap")) Heap.sort(a);
		return timer.elapsedTime();
	}
	public static double timeRandomInput(String alg,int N,int T) {
		double total=0.0;
		Double[] a=new Double[N];
		for(int t=0;t<T;t++) {
			//进行一次测试（生成一个数组并排序）
			for(int i=0;i<N;i++)
				a[i]=StdRandom.uniform();
			total+=time(alg, a);
		}
		return total;
	}
	public static void main(String[] args) {
		String alg1="Shell";
		String alg2="Insertion";
		int N=1000;
		int T=100;
		double t1=timeRandomInput(alg1, N, T);
		double t2=timeRandomInput(alg2, N, T);
		StdOut.printf("For %d random Double\n  %s is ",N,alg1);
		StdOut.printf("%.1f times faster than %s \n", t2/t1,alg2);
	}
}
