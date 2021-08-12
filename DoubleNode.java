/**
 * @author Rowena
 * This class represents the nodes in a doubly linked list.
 */

public class DoubleNode<T> {
	
	private DoubleNode<T> next;
	private DoubleNode<T> prev;
	private T data;
	
	/**
	 * Creates an empty node, where all instance variables are null.
	 */
	public DoubleNode() {
		next = null;
		prev = null;
		data = null;
	}
	
	/**
	 * Creates a node storing the given data in which next and prev are null.
	 */
	public DoubleNode(T newData) {
		next = null;
		prev = null;
		data = newData;
				
	}
	
	/**
	 * Returns the value of next.
	 */
	public DoubleNode<T> getNext() {
		return next;
	}
	
	/**
	 * Returns the value of prev.
	 */
	public DoubleNode<T> getPrev() {
		return prev;
	}
	
	/**
	 * Returns the value of data.
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Stores nextNode in next.
	 */
	public void setNext(DoubleNode<T> nextNode) {
		next = nextNode;
	}
	
	/**
	 * Stores prevNode in prev.
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		prev = prevNode;
	}
	
	/**
	 * Stores newData in data.
	 */
	public void setData(T newData) {
		data = newData;
	}
	
}
