package Graphs;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {
	private boolean[] marked;//这个顶点是否调用过dfs()
	private int[] edgeTo;//从起点到一个顶点的已知路径
	private final int s;//起点
	public DepthFirstPaths(Graph G,int s) {
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		dfs(G,s);
	}
	private void dfs(Graph G, int v) {
		marked[v]=true;
		for(int w:G.adj(v))
			if(!marked[w]) {
				edgeTo[w]=v;
				dfs(G, w);
			}
		
	}
	//是否存在s到v的路径
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	//s到v的路径，如果不存在则返回null
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path=new Stack<Integer>();
		for(int x=v;x!=s;x=edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
}
