package Interfaces;

import Graph.Edge;
/**
 * 
 * @author Hlungwani, T 215021437
 *
 */
public interface IVertex {
	public void addFriend(Edge edge);
	public Edge removeFriend(int index);
	public Edge getFriend(int index);
	public boolean hasFriend(Edge edge1);
	public void removeFriend(Edge other);
	public int getFriendCount();
	public String toString();
	public int hash();
	public boolean equals(Object vertex);
	
}
