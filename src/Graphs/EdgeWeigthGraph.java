package Graphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class EdgeWeigthGraph {
	private final int V;//顶点总数
	private int E;//边的总数
	private Bag<Edge>[]  adj;//邻接表
	public EdgeWeigthGraph(int V) {
		this.V=V;
		this.E=0;
		adj=(Bag<Edge>[]) new Bag[V];
		for(int v=0;v<V;v++)
			adj[v]=new Bag<Edge>();
	}
	public EdgeWeigthGraph(In in) {
		this(in.readInt());
		int E=in.readInt();
		for(int i=0;i<E;i++) {
			int v=in.readInt();
			int w=in.readInt();
			double weight=in.readDouble();
			Edge e=new Edge(v,w,weight);
			addEdge(e);
		}
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public void addEdge(Edge e) {
		int v=e.either(),w=e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
		}
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	public Iterable<Edge> edges(){
		Bag<Edge> b=new Bag<Edge>();
		for(int v=0;v<V;v++)
			for(Edge e:adj[v])
				if(e.other(v)>v) b.add(e);
		return b;
		}
}
