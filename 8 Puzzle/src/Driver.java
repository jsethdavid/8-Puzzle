public class Driver
{
    public static void main(String[]args)
    {
        hTest(new Board(new int[][]{{1, 2, 3},{4, 0, 5},{7, 8, 6}}),2000);// test the state and timer using heuristic search
        hTest(new Board(new int[][]{{0, 1, 2},{4, 5, 3},{7, 8, 6}}),2000);// test the state and timer using heuristic search
        hTest(new Board(new int[][]{{0, 8, 6},{2, 7, 5},{1, 3, 4}}),2000);// test the state and timer using heuristic search
        System.out.println();
        bfTest(new Board(new int[][]{{1, 2, 3},{4, 0, 5},{7, 8, 6}}),2000);// test the state and timer using breadth first search
        bfTest(new Board(new int[][]{{0, 1, 2},{4, 5, 3},{7, 8, 6}}),2000);// test the state and timer using breadth first search
        bfTest(new Board(new int[][]{{0, 8, 6},{2, 7, 5},{1, 3, 4}}),2000);// test the state and timer using breadth first search
    }

    private static void path(Board state)// prints path of board initial to goal
    {
        if (state == null)// returns a string couldn't solve if state is null
        {System.out.println("Couldn't solve in the time frame given");
        }else
        {
            for (Board b : state.getPath())
            {
                System.out.println(b);
            }
        } // returns a string of state path traversed if not null
    }

    private static void bfTest(Board state, int ms)// breadth first search test to test our state
    {
        BestFirstSearch bSearch = new BreadthFirstSearch();//initialize breadth first search
        System.out.println("Breadth First Search Path Traversal");
        path(bSearch.run(state,ms));// gets the path of state using breadth first in a specific time
    }

    private static void hTest(Board state, int ms)// heuristic search test to test our state
    {
        BestFirstSearch hSearch = new HeuristicSearch();//initialize heuristic search
        System.out.println("Heuristic Search Path Traversal");
        path(hSearch.run(state,ms));// gets the path of state using breadth first in a specific time
    }
}
