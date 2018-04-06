package Graphs;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Digraph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	private int[] indegree;
	public Digraph(int V) {
		this.V=V;
		this.E=E;
		adj=(Bag<Integer>[]) new Bag[V];
		for(int v=0;v<V;v++)
			adj[v]=new Bag<Integer>();
	}
	public Digraph(In in) {
		try {
			this.V=in.readInt();
			if(V<0) throw new IllegalArgumentException();
			indegree=new int[V];
			adj=(Bag<Integer>[]) new Bag[V];
			for(int v=0;v<V;v++) {
				adj[v]=new Bag<Integer>();
			}
			int E=in.readInt();
			if(E<0) throw new IllegalArgumentException();
			for(int i=0;i<E;i++) {
				int v=in.readInt();
				int w=in.readInt();
				addEdge(v, w);
			}
			
		}catch (NoSuchElementException e) {
			throw new IllegalArgumentException("invalid input format in Digraph constructer",e);
		}
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public void addEdge(int v,int w) {
		adj[v].add(w);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	//有向图取反
	public Digraph reverse() {
		Digraph R=new Digraph(V);
		for(int v=0;v<V;v++)
			for(int w:adj(v))
				R.addEdge(w, v);
		return R;
	}

}
