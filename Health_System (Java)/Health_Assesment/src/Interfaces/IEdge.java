package Interfaces;

import Graph.Edge;
import Graph.Vertex;
/**
 * 
 * @author Hlungwani, T 215021437
 *
 */
public interface IEdge {
	public Vertex getFriends(Vertex current);
	public int compareTo(Edge e);
	public String toString();
	public int hashCode();
	public boolean equals(Object e);
	
}
