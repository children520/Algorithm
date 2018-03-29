package Graphs;

import edu.princeton.cs.algs4.Queue;

public class BreadthFirstPaths {
	private boolean[] marked;//到达该顶点的最短路径已知么？
	private int[] edgeTo;//到达该顶点的已知路径上最后一个顶点
	private final int s;//起点
	public BreadthFirstPaths(Graph  G,int s) {
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		bfs(G,s);
	}
	private void bfs(Graph G, int s) {
		Queue<Integer> queue=new Queue<Integer>();
		marked[s]=true;//标记起点
		queue.enqueue(s);//将它加入队列
		while(!queue.isEmpty()) {
			int v=queue.dequeue();
		}
	}

}
