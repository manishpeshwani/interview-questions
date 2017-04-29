package com.manish.graph;

public class Edge {
	
	public Vertex source;
	
	public Vertex destination;
	
	public int weight;
	
	public Edge(Vertex s, Vertex d, int weight){
		this.source = s;
		this.destination = d;
		this.weight = weight;
	}
	
	public Edge(){}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "E [s=" + source + ", d=" + destination + ", w=" + weight + "]";
	}
	
	

}
