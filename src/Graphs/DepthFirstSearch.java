package Graphs;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	public DepthFirstSearch(Graph G,int s) {
		marked=new boolean[G.V()];
		dfs(G,s);
	}
	private void dfs(Graph G, int v) {
		marked[v]=true;
		count++;
		for(int w:G.adj(v))
			//访问v相邻的结点，如果已标记，则回退
			if(!marked[w]) dfs(G, w);
		
	}
	public boolean marked(int w) {
		return marked[w];
	}
	public int count() {
		return count;
	}
}
