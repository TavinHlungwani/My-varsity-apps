package Interfaces;

import Graph.Edge;
import Graph.Vertex;
/**
 * 
 * @author Hlungwani, T 215021437
 *
 */
public interface IGraph {
	 public boolean addEdge(Vertex v1, Vertex v2, int length);
	 public Edge removeEdge(Edge edge);
	 public boolean containsEdge(Edge edge);
	 public boolean containsVertex(Vertex v);
	 public Vertex getVertex(String name);
	 public boolean addVertex(Vertex v, boolean overWrite);
	 public Vertex removeVertex(String name);
	 public String toString();
}
