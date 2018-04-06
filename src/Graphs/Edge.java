package Graphs;

import javax.management.RuntimeErrorException;

public class Edge implements Comparable<Edge>{
	private final int v;//顶点之一
	private final int w;//另一个顶点
	private final double weight;//边的权重
	//用于初始化的构造函数
	public Edge(int v,int w,double weight) {
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	//边的权重
	public double weight() {
		return weight;
	}
	//边两端的顶点之一
	public int either() {
		return v;
	}
	//另一个顶点
	public int other(int vertex) {
		if(vertex==v) return w;
		else if(vertex==w) return v;
		else throw new RuntimeErrorException(null, "Inconsistent edge");
		
	}
	//将这条边与that比较
	public int compareTo(Edge that) {
		if(this.weight()<that.weight()) return -1;
		else if(this.weight()>that.weight()) return +1;
		else return 0;
	}
	public String toString() {
		return String.format("%d-%d %.2f", v,w,weight);
	}

}
