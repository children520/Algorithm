package fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
	private int[] id;//分量id
	private int count;//分量数量
	//初始化分量id数组
	public UF(int N) {
		count=N;
		id=new int[N];
		for(int i=0;i<N;i++)
			id[i]=i;
	}
	public int count() {
		return count;
	}
	//如果p和q存在同一个分量则返回true
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	//p所在的分量的标识符
	public int find(int p) {
		return id[p];
	}
	//在p和q之间添加一条链接
	public void  union(int p,int q) {
		int pID=find(p);
		int qID=find(q);
		if(pID==qID)
			return;
		for(int i=0;i<id.length;i++)
			if(id[i]==pID) id[i]=qID;
		count--;
	}
	public static void main(String[] args) {
		int N=StdIn.readInt();//读取触点数量
		UF uf=new UF(N);//初始化N个分量
		while(!StdIn.isEmpty()) {
			int p=StdIn.readInt();
			int q=StdIn.readInt();//读取整数
			if(uf.connected(p, q)) continue;//如果连通则忽略
			uf.union(p, q);//归并分量
			StdOut.println(p+" "+q);
		}
		StdOut.println(uf.count+"components");
	}
	private int quickunionfind(int p) {
		while(p!=id[p]) p=id[p];
		return p;
	}
	public void quickunionfindunion(int p,int q) {
		//p和q的根结点统一
		int pRoot=quickunionfind(p);
		int qRoot=quickunionfind(q);
		if(pRoot==qRoot) return;
		id[pRoot]=qRoot;
		count--;
		
	}
}
