package Graphs;

import edu.princeton.cs.algs4.In;
import fundamentals.Bag;

public class EdgeWeightedDigraph {
	private final int V;//顶点总数
	private int E;//边的总数
	private Bag<DirectedEdge>[] adj;//邻接表
	public EdgeWeightedDigraph(int V) {
		this.V=V;
		this.E=E;
		adj=(Bag<DirectedEdge>[]) new Bag[V];
		for(int v=0;v<V;v++)
			adj[v]=new Bag<DirectedEdge>(); 
	}
	public EdgeWeightedDigraph(In in) {
		this(in.readInt());
		int E=in.readInt();
		for(int i=0;i<E;i++) {
			int v=in.readInt();
			int w=in.readInt();
			double weight=in.readDouble();
			DirectedEdge e=new DirectedEdge(v, w, weight);
			addEdge(e);
		}
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	//添加边
	public void addEdge(DirectedEdge e) {
		adj[e.from()].add(e);
		E++;
	}
	//从v指出的边
	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}
	//该有向图的所有边
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> bag=new Bag<DirectedEdge>();
		for(int v=0;v<V;v++)
			for(DirectedEdge e:adj[v])
				bag.add(e);
		return bag;
	}
	
	
}
