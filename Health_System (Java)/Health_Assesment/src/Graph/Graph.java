package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import Interfaces.IGraph;
/**
 * @author Hlungwani T 215021437
 *	This class represents a graph which contains set of vertices and a set of edges.
 *	Here the vertices are identified by their names and that is no two vertices are the same.
 *	The graph is modeled as undirected and a pair of vertices to one edge occurs. 
 *	The length between vertices (i.e. stored in the edge) determines the strength of
 *	the relationship between vertices.
 *	It uses a Map data structure to implement
 *	This class will implement the interface IGraph
 */
public class Graph implements IGraph{
	
	private HashMap<String, Vertex> numVertices;
	private HashMap<Integer, Edge> numEdges;
	/**
	 * non-argumented constructor
	 */
	public Graph(){
		numEdges = new HashMap<Integer, Edge>();
		numVertices = new HashMap<String, Vertex>();
	}
	
	/**
	 * Constructor used to populate the graph 
	 * @param numVertices are the vertices that populates the graph first
	 */
	public Graph(ArrayList<Vertex> nV){
		numVertices = new HashMap<String, Vertex>();
		numEdges = new HashMap<Integer, Edge>();
		
		//for each vertex, get and place the name to the graph 
		for(Vertex vertex : nV){
			numVertices.put(vertex.getvName(), vertex);
		}
	}
	
    /**
     * This method adds v1 and v2 and edge and its length
     * @param v1 The first Vertex of the Edge
     * @param v2 The second Vertex of the Edge
     * @param lenth The weight of the Edge
     * @return true/false 
     * 			true if no Edge already exists in the Graph
     * 			false if there is an edge in the graph
     */
    public boolean addEdge(Vertex v1, Vertex v2, int length){
        //Make sure the two vertices are not equal first
    	if(v1 == v2){
            return false;   
        }
       
        //Make sure that the Edge is not in the Graph
        Edge edge = new Edge(v1, v2, length);
        if(numEdges.containsKey(edge.hashCode())){
            return false;
        }
        
        //Now add vertices into the graph and connect them
        numEdges.put(edge.hashCode(), edge);
        v1.addFriend(edge);
        v2.addFriend(edge);
        return true;
    }
	
	
    /**
     * This method removes the specified Edge from the Graph.
     * @param edge is the Edge to remove from the Graph
     * @return Edge is the Edge removed from the Graph
     */
    public Edge removeEdge(Edge edge){
       edge.getV1().removeFriend(edge);
       edge.getV2().removeFriend(edge);
       return numEdges.remove(edge.hashCode());
    }
	
    /**
     * This method checks if the graph contains an edge
     * @param edge is the Edge to look up
     * @return true/false
     * 			 true if this Graph contains the Edge edge
     * 			 false if it doesn't contain the Edge edge
     */
    public boolean containsEdge(Edge edge){
        if(edge.getV1() == null || edge.getV2() == null){
            return false;
        }
        
        return numVertices.containsKey(edge.hashCode());
    }
    
    /**
     * This method checks if a graph contains a vertex
     * @param vertex is the Vertex to look up
     * @return true/false
     * 			true if this Graph contains a vertex
     * 			false if it doesn't
     */
    public boolean containsVertex(Vertex v){
        return numVertices.get(v.getvName()) != null;
    }
    
    /**
     * This method returns a specific vertex
     * @param name is the specified Vertex name
     * @return Vertex is the Vertex with the specified name
     */
    public Vertex getVertex(String sTname){
        return numVertices.get(sTname);
    }
    
    /**
     * This method adds a Vertex to the graph and also checks
     * if there is an existing vertex and it overwrites it
     * @param v is the vertex to add
     * @param overWrite is to overwrite the existing vertex
     * @return true/false
     * 			true if vertex was added to the Graph
     * 			false if vertex wasn't added
     */
    public boolean addVertex(Vertex v, boolean overWrite){
        Vertex current = this.numVertices.get(v.getvName());  //get the current vertex
        if(current != null){			//check if its not empty
            if(!overWrite){
                return false;
            }
            
        }
        numVertices.put(v.getvName(), v);
        return true;
    }
    
    /**
     * This method removes a vertex from the graph
     * @param name is the name of the Vertex to remove
     * @return v is the removed Vertex 
     */
    public Vertex removeVertex(String name){
        return numVertices.remove(name);
    }
    
    /**
     * This method returns the edges of the graph
     * @return Set<Edge> The Edges of this graph
     */
    public Set<Edge> getEdges(){
    	return new HashSet<Edge>(this.numEdges.values());
    }
    

}
