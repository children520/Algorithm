package Graphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
	private final int V;//顶点数目
	private int E;//边的数目
	private Bag<Integer>[] adj;//邻接表
	//创建一个含有V个顶点但不含有边的tu
	public Graph(int V) {
		this.V=V;
		this.E=0;
		adj=(Bag<Integer>[]) new Bag[V];//创建邻接表
		for(int v=0;v<V;v++)
			adj[v]=new Bag<Integer>();
	}
	//从标准输入流in读入一副图
	public Graph(In in) {
		this(in.readInt());//读取V并将图初始化
		int E=in.readInt();//读取
		for(int i=0;i<E;i++) {
			//添加一条边
			int v=in.readInt();//读取一个顶点
			int w=in.readInt();//读取另一个顶点
			addEdge(v,w);//添加一条连接他们的边
		}
	}
	//顶点数
	public int V() {
		return V;
	}
	//边数
	public int E() {
		return E;
	}
	//向图中添加一条边v-w
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
		
	}
	//返回和v相邻的所有顶点
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	
}
