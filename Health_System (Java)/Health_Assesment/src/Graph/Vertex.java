package Graph;

import java.util.ArrayList;

import Interfaces.IVertex;
/**
 * 
 *	@author Hlungwani T 215021437
 *	This class represents a vertex and uses arrayList data structure to store 
 *	edges as friends that connect multiple vertices.
 *	The vertex will store a question.
 *	This class will implement the IVertex interface
 */
public class Vertex implements IVertex{

	private ArrayList<Edge> friends;
	private String vName;
	
	/**
	 * Constructor
	 * @param vName the name of the vertex
	 */
	public Vertex(String vName) {
		this.friends = new ArrayList<Edge>();
		this.vName = vName;
	}
	
	/**
	 * This method will add an friendship of the graph only if no edge is present
	 * @param edge is the edge to be added
	 */
	public void addFriend(Edge edge){
		if(friends.contains(edge)){
			return;
		}
		
		friends.add(edge);
	}
	
	/**
	 * This method is used to remove an edge
	 * @param index is the index of the edge
	 * @return edge is the edge to be removed
	 */
	public Edge removeFriend(int index){
		return friends.remove(index);
	}
	
	/**
	 * The method used to attain an edge
	 * @param index is the index of the edge that will be retrieved
	 * @return edge which is the edge associated with the index
	 */
	public Edge getFriend(int index){
		return friends.get(index);
	}
	
	/**
	 * Used to search for an edge
	 * @param edge1 to be searched for
	 * @return true/false
	 * 			true if edge1 is inside this.friends
	 * 			false if edge1 is not within friends
	 */
	public boolean hasFriend(Edge edge1){
		return friends.contains(edge1);
				
	}
	
	/**
	 * Used to remove an edge from friends
	 * @param other is the edge to be removed
	 */
	public void removeFriend(Edge other){
		friends.remove(other);
	}
	
	/**
     * Counts friends of the vertex
     * @return int The number of friends of this Vertex
     */
    public int getFriendCount(){
        return friends.size();
    }
    
    
    /**
     * This method returns the name of the vertex
     * @return vName The name of this Vertex
     */
    public String getvName(){
        return vName;
    }
    
    
    /**
     * This method represents a vertex as a string
     * @return vName A String representation of this Vertex
     */
    public String toString(){
        return vName;
    }
    
    /**
     * This method attain the hashCode of the vertex name
     * @return The hash code of this Vertex's name
     */
    public int hash(){
        return vName.hashCode();
    }
    
    /**
     * This method compares vertexes against each other
     * @param vertexname The object to compare
     * @return 
     */
    public boolean equals(Object vertex){
        if(!(vertex instanceof Vertex)){
            return false;
        }
        
        Vertex v = (Vertex)vertex;
        return vName.equals(v.vName);
    }
    
    /**
     * 
     * @return ArrayList<Edge> A copy of this.friends. 
     * Modifying the returned ArrayList will not affect the friends of this Vertex
     */
    public ArrayList<Edge> getFriends(){
        return new ArrayList<Edge>(friends);
    }

}
