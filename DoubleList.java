/**
 * @author Rowena
 * This class represents a doubly linked list of nodes of the class DoubleNode.
 **/

public class DoubleList<T> {
	
	private DoubleNode<T> head;
	private DoubleNode<T> rear;
	private int numDataItems;
	
	/**
	 * This creates an empty list with zero nodes.
	 */
	public DoubleList() {
		head = null;
		rear = null;
		numDataItems = 0;
	}
	
	/**
	 * This method adds a new node to the list storing newData.
	 * The node is inserted in the index position of the list.
	 */
    public void addData(int index, T newData) throws InvalidPositionException {
        DoubleNode<T> newNode = new DoubleNode();
        newNode.setData(newData);
        if (index == 0 ) {
            if (head == null) {
                head = newNode;
            } else {
                newNode.setNext(head);
                head = newNode;
            }
            numDataItems++;
        }
        else if (index > 0 && index < numDataItems) {
            DoubleNode<T> current = getNode(index); // uses getNode method to find node at index
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            numDataItems++;
        }
        else if (index == numDataItems) { // last item
            if (rear == null) {
            	head.setNext(newNode);
                rear = newNode;
            } else {
                rear.setNext(newNode);
                rear = newNode;
            }
            numDataItems++;
        }
        else {
            throw new InvalidPositionException("Invalid position addData.");
        }
    }
	
	/**
	 * Returns the node that is at the index position of the list.
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException {
		DoubleNode<T> current = head.getNext();
		if (index < 0 || index >= numDataItems) { // if index is invalid, throws exception
			throw new InvalidPositionException("Invalid position getNode.");
			}
		else if (index == 0) {
			return head;
		}
		else if (index == numDataItems - 1) {
			return rear;
		}
		else {
			for (int i = 1; i < numDataItems - 1; i++) { // for loop to find current node at index
				if (i < index) {
					current = current.getNext();
				}
				else {
					break;
				}	
			}
			return current;
		}
	}
	
	/**
	 * Removes the node that is at the index position of the list.
	 */
	public void removeData(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems) { // if index is invalid, throws exception
			throw new InvalidPositionException("Invalid position removeData.");
		}
		else if (index == 0) {
			head = getNode(index);
			head = getNode(index+1);
			numDataItems--;
		}
		else if (index == numDataItems - 1) {
			rear = getNode(index);
			rear = getNode(index-1);
			numDataItems--;
		}
		else {
			DoubleNode<T> current = getNode(index);
			DoubleNode<T> previous = getNode(index-1);
			DoubleNode<T> next = getNode(index+1);
			previous.setNext(next);
			numDataItems--;
		}
	}
	
	/**
	 * Returns the data stored in the node located at the index position of the list.
	 */
	public T getData(int index) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems) { // if index is invalid, throws exception
			throw new InvalidPositionException("Invalid position getData.");
		}
		DoubleNode<T> current = getNode(index);
		return current.getData();
	}
	
	/**
	 * Store newData at the node in position index of the list.
	 */
	public void setData(int index, T newData) throws InvalidPositionException {
		if (index < 0 || index >= numDataItems) { // if index is invalid, throws exception
			throw new InvalidPositionException("Invalid position setData.");
		}
		DoubleNode<T> current = getNode(index);
		current.setData(newData);
	}
	
}
