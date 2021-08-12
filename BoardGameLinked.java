/**
 * @author Rowena
 * This class represents the board game where the snake moves around eating apples.
 **/

public class BoardGameLinked {
	
	int boardLength;
	int boardWidth;
	SnakeLinked theSnake;
	DoubleList<String>[] board;
	
	/**
     * Constructor reads in lines from boardFile to place objects
     **/
	public BoardGameLinked(String boardFile) {
		
		MyFileReader in;
		int x;
		int y;
		
		in = new MyFileReader(boardFile);
	    
		in.readInt();
	    in.readInt();
	    
	    boardLength = in.readInt();
	    boardWidth = in.readInt();
		
	    x = in.readInt();
	    y = in.readInt();
	    
	    theSnake = new SnakeLinked(x,y);
	    
	    board = new DoubleList[boardWidth];

	    for (int i = 0; i < boardWidth; ++i) {
		    board[i] = new DoubleList<String>();
	    	for (int j = 0; j < boardLength; ++j) {
	    		board[i].addData(j, "empty");
	    	}
	    }
	    
	    while (in.endOfFile() == false) {
	    	int a = in.readInt();
	    	int b = in.readInt();
	    	String line = in.readString();
	    	board[a].setData(b, line);
		}    
	}
	
    /**
     * Returns the string stored in the node with index = col of
     * the doubly linked list referenced by board[row]
     **/
	public String getObject(int row, int col) throws InvalidPositionException {
		if (row >= boardWidth || row < 0 || col >= boardLength || col < 0) {
			throw new InvalidPositionException("Invalid position setObject. ");
		} 
		else {
			return board[row].getData(col);
		}
	}
	
    /**
     * Stores newObject in the node with index = col of the
     * doubly linked list referenced by board[row]
     **/
	public void setObject(int row, int col, String newObject) throws InvalidPositionException {
		if (row >= boardWidth || row < 0 || col >= boardLength || col < 0) {
			throw new InvalidPositionException("Invalid position setObject. ");
		}
		else {
			board[row].setData(col, newObject);
		}
	}
	
    /**
     * Returns theSnake
     **/
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}
	
    /**
     * Stores the value of newSnake in instance variable theSnake.
     **/
	public void setSnakeLinked(SnakeLinked newSnake) {
		theSnake = newSnake;
	}
	
    /**
     * returns boardLength
     **/
	public int getLength() {
		return boardLength;
	}
	
    /**
     * Returns boardWidth
     **/
	public int getWidth() {
		return boardWidth;
	}
}
