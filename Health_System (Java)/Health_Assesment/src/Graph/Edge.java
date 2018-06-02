package Graph;
/**
 * @author Hlungwani T 215021437
 *	This class represents an edge. which contains a length(initially 1) and
 *	the vertices it connects.
 *	The length simply means the relationship strength between vertices.
 *	This edge will store an answer based on the 2 questions stored by 
 *	the two vertices it connects.
 *	This class implements the IEdge interface
 *	
 */

import Interfaces.IEdge;

public class Edge implements IEdge{

	private int length;
	private Vertex v1, v2;
	
	/**
	 * Constructor
	 * @param v1 is the first vertex
	 * @param v2 is the second vertex
	 * @param length is the length/weight/cost between them
	 */
	public Edge(Vertex v1, Vertex v2) {
		length = 1;
		this.v1 = v1;
		this.v2 = v2;
	}
	
    /** 
    * @param v1 The first vertex in the Edge
    * @param v2 The second vertex of the Edge
    * @param leng The length of this Edge
    */
   public Edge(Vertex v1, Vertex v2, int leng){
       this.v1 = (v1.getvName().compareTo(v2.getvName()) <= 0) ? v1 : v2;
       this.v2 = (this.v1 == v1) ? v2 : v1;
       this.length = leng;
   }
	
   /**
    * This method gets the friend/neighbor of the current vertex
    * @param current
    * @return The friend of current along this Edge
    */
   public Vertex getFriends(Vertex current){
       if(!(current.equals(v1) || current.equals(v2))){
           return null;
       }
       
       return (current.equals(v1)) ? v2 : v1;
   }
	
  
   //Getters and setters
   public int getLength() {
	   return length;
   }

   public void setLength(int length) {
	   this.length = length;
   }

   public Vertex getV1() {
	   return v1;
   }

   public void setV1(Vertex v1) {
	   this.v1 = v1;
   }

   public Vertex getV2() {
		return v2;
   }

   public void setV2(Vertex v2) {
	   this.v2 = v2;
   }

   /**
    * This method compares two edges
    * @param e The Edge to compare against this
    * @return int length - e.length;
    */
   public int compareTo(Edge e){
       return length - e.length;
   }
   
   /**
    * This method returns an edge as a string
    * @return String A String representation of this Edge
    */
   public String toString(){
       return "({" + v1 + ", " + v2 + "}, " + length + ")";
   }
   
   /**
    * This method returns a hashcode of an edge
    * @return int The hash code for this Edge 
    */
   public int hashCode(){
       return (v1.getvName() + v2.getvName()).hashCode(); 
   }
   
   /**
    * This method compares edges if they have same vertices
    * @param other The Object to compare against this
    * @return true iff other is an Edge with the same Vertices as this
    */
   public boolean equals(Object e){
       if(!(e instanceof Edge)){
           return false;
       }
       
       Edge e1 = (Edge)e;
       return e1.v1.equals(this.v1) && e1.v2.equals(this.v2);
   }   
   
   
}
