package Graphs;

import java.beans.Visibility;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimMST {
	private boolean[] marked;//最小生成树的顶点
	private Queue<Edge> mst;//最小生成树的边
	private MinPQ<Edge> pq;
	public LazyPrimMST(EdgeWeigthGraph G) {
		pq=new MinPQ<Edge>();
		marked=new boolean[G.V()];
		mst=new Queue<Edge>();
		visit(G,0);
		while(!pq.isEmpty()) {
			Edge e=pq.delMin();//得到权重最小的边
			int v=e.either(),w=e.other(v);
			if(marked[v]&&marked[w]) continue;//跳过失效的边
			mst.enqueue(e);//添加边到树
			if(!marked[v]) visit(G,v);//添加顶点
			if(!marked[w]) visit(G,w);
					
		}
	}
	private void visit(EdgeWeigthGraph G,int v) {
		//标记顶点v并将所有连接v和未被标记顶点的边加入pq
		marked[v]=true;
		for(Edge e:G.adj(v))
			if(!marked[e.other(v)]) pq.insert(e);
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight() {
		
	}
}
