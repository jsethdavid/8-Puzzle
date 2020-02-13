import java.util.*;

public class Board
{
    private int N;
    private int [][] board;
    private ArrayList<Board> path;

    public Board(int [][] tiles) //constructor
    {
        N = tiles.length;
        board = new int[N ][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++) {
                board[i][j] = tiles[i][j];
            }


        path=new ArrayList<>(); //creates path
        path.add(this);//adds path to array list
    }


    public void UpdatePathToStartState(Board state)// returns path to start state
    {
        path = new ArrayList<>(state.getPath());//creates an array list with path of the state to goal
        path.add(this);//adds the state path into an array list
    }

    public ArrayList<Board> getPath() { // method to get path
        return path; //returns the path
    }

    public boolean isInPath(Board state)// to check if state is in path
    {
        return path.contains(state);// returns true if is in path
    }

    public int getDepth()// method to get the depth of the path
    {
        return path.size(); // returns the depth of the path
    }

    public String toString() //returns a string
    {
        String dimension = "";
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {

                dimension = dimension + (board[i] [j]);
            }
            dimension = dimension + "\n";
        }
        return dimension;
    }

    public int tileAt(int row, int col)// check if tiles are intact
    {
        if (row < 0 || row > N-1)throw new IllegalArgumentException("row should be between 0 and N-1");
        if (col < 0 || col > N-1)throw new IllegalArgumentException("col should be between 0 and N-1");
        return board[row] [col];
    }

    public int size()
    {
        return N;
    } // returns size of board

    public boolean isGoal()// checks if its the goal board
    {
        for (int i = 0; i < this.size(); i++)
        {
            for (int j = 0; j < this.size(); j++)
            {
                if (tileAt(i, j) != 0 && tileAt(i, j) != (i*N + j + 1))
                    return false;
            }
        }

        return true;
    }

    public boolean equals(Object y)//checks if two boards are equal
    {
        Board x = (Board)y;
        for (int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (board != y) {
                    return false;
                }
            }
        }
        return true;
    }

    public Iterable<Board> neighbors() // returns neighbouring boards or children boards
    {
        LinkedList <Board> neighborBoards = new LinkedList<>();
        int x=0;
        int y=0;
        for (int i=0; i<N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }

        if (x > 0) { neighborBoards.add(swapBoard(x,y,x-1,y)); } //north
        if (x < N-1) { neighborBoards.add(swapBoard(x,y,x+1,y)); } //south
        if (y > 0) { neighborBoards.add(swapBoard(x,y,x,y-1)); } //west
        if (y < N-1) { neighborBoards.add(swapBoard(x,y,x,y+1)); } // east

        return neighborBoards;
    }

    private Board swapBoard(int x,int y, int x1,int y1)// this is to swap the tiles
    {
        Board newNeighbor = new Board(board);
        newNeighbor.board[x][y] = board[x1][y1];
        newNeighbor.board[x1][y1] = 0;
        return newNeighbor;
    }



}

