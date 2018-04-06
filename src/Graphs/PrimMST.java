package Graphs;

import edu.princeton.cs.algs4.IndexMinPQ;
import fundamentals.Bag;

public class PrimMST {
	private Edge[] edgeTo;//距离树最近的边
	private double[] distTo;//distTo[w]=edgeTo[w].weight();
	private boolean[] marked;//如果v在树中则为true
	private IndexMinPQ<Double> pq;
	public PrimMST(EdgeWeigthGraph G) {
		edgeTo=new Edge[G.V()];
		distTo=new double[G.V()];
		marked=new boolean[G.V()];
		for(int v=0;v<G.V();v++)
			distTo[v]=Double.POSITIVE_INFINITY;//正无穷
		pq=new IndexMinPQ<Double>(G.V());
		distTo[0]=0.0;
		pq.insert(0, 0.0);//用顶点0和权重0初始化pq;
		while(!pq.isEmpty())
			visit(G,pq.delMin());//将最近的顶点添加到树中
	}
	private void visit(EdgeWeigthGraph G,int v) {
		//将顶点v添加树中，更新数据
		marked[v]=true;
		for(Edge e:G.adj(v)) {
			int w=e.other(v);
			if(marked[w]) continue;
			if(e.weight()<distTo[w])
			{//连接w和树
				
				edgeTo[w]=e;
				distTo[w]=e.weight();
				if(pq.contains(w)) pq.change(w,distTo);
				else pq.insert(w, distTo[w]);
			}
		}
	}
	public Iterable<Edge> edge(){
		Bag<Edge> mst=new Bag<Edge>();
		for(int v=1;v<edgeTo.length;v++)
			mst.add(edgeTo[v]);
		return mst;
	}
	public double weight() {
		return null;
	}
}
