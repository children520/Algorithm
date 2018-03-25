package fundamentals;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class DoublintTest {
	public static double timeTrial(int N) {
		//为处理N个随机的六位整数的ThreeSum.count()记时
		int MAX=1000000;
		int[] a=new int[N];
		for(int i=0;i<N;i++)
			a[i]=StdRandom.uniform(-MAX,MAX);
		Stopwatch timer=new Stopwatch();//创建一个计时器
		int cnt=ThreeSum.count(a);
		return timer.elapsedTime();//返回对象创建以来所经过的时间
	}
	public static void main(String[] args) {
		double prev=timeTrial(125);
		for(int N=250;true;N+=N) {
			//打印运行时间的表格
			double time=timeTrial(N);//打印问题规模为N的程序
			StdOut.printf("%7d %5.1f", N,time);
			StdOut.printf("%5.1f\n", time/prev);//比值趋近于一个常数
			prev=time;
			
			
		}
			
	}
}
