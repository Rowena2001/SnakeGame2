/**
 * Created by Rowena Shi | 251073629
 * The class stores the information about the snake as it moves around the board.
 **/

public class SnakeLinked {
	
	int snakeLength;
	DoubleList<Position> snakeBody;
	
	/**
	 * The constructor for the class; the parameters are the coordinates
	 * of the head of the snake
	 **/
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody = new DoubleList<Position>();
		snakeBody.addData(0, new Position(row,col));
	}
	
	/**
	 * Returns the value of instance variable snakeLength.
	 **/
	public int getLength() {
		return snakeLength;
	}
	
	/**
	 * Returns the Position object stored in the node of
	 * the doubly linked list with the given index.
	 **/
	public Position getPosition(int index) {
		if (index < 0 || index >= snakeLength) {
			return null;
		}
		else {
			return snakeBody.getData(index); 
		}
	}
	
	/**
	 * Returns true if pos is in the doubly linked list
	 * of snakeBody, and it returns false otherwise.
	 **/
	public boolean snakePosition(Position pos) {
		for (int i = 0; i < snakeLength; ++i) 
			if (snakeBody.getData(i).equals(pos)) {
				return true;
			}
		return false;
	}
	
	/**
	 * Returns the new position that the head of the snake would
	 * occupy if the snake moved in the direction specified by the parameter.
	 **/
	public Position newHeadPosition(String direction) {
		int row = snakeBody.getData(0).getRow();
		int col = snakeBody.getData(0).getCol();
		if (direction == "right") {
			col++;	
		}
		else if (direction == "left") {
			col--;	
		}
		else if (direction == "up") {
			row--;
		}
		else if (direction == "down") {
			row++;
		}
		Position newPos = new Position(row,col);
		return newPos;
	}
	
	/**
	 * Moves the snake in the specified direction.
	 **/
	public void moveSnakeLinked(String direction) {
		Position newHead = newHeadPosition(direction);
		for (int i = snakeLength-2; i >= 0; --i) {
			snakeBody.setData(i+1, snakeBody.getData(i));
		}
		snakeBody.setData(0, newHead);
	}
	/**
	 * Decreases the value of snakeLength by 1 and deletes the last node
	 * in the doubly linked list of snakeBody.
	 **/
	public void shrink() {
		if (snakeLength == 1) {
			snakeLength = 0;
		}
		else {
			snakeBody.removeData(--snakeLength);
		}
	}
	
	/**
	 * Increases the length of the snake by 1 and moves the snake's head
	 * in the direction specified.
	 **/
	void grow(String direction) {
		Position newHead = newHeadPosition(direction);
		snakeBody.addData(snakeLength, null);
		for (int i = snakeLength - 1; i >= 0; --i) {
			snakeBody.setData(i+1, snakeBody.getData(i));
		}
		snakeBody.setData(0, newHead);
		snakeLength++;
	}
}