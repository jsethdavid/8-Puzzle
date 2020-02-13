public abstract class BestFirstSearch // abstract Best first search
{
    HeapPriorityQueue<Integer,Board> PQ; // Heap priority queue of type<Integer,Board>.
    public Board run(Board initState, Integer stoppingCondition)
    {
        PQ = new HeapPriorityQueue<>(); // instantiate PQ
        int quality = CalculatePriority(initState);
        PQ.insert(quality, initState); // insert initial state into the Priority Queue
        long timer = System.currentTimeMillis(); // return the current time
        while(!PQ.isEmpty() && System.currentTimeMillis() - timer < stoppingCondition) // while stopping condition is not true
        {
            Board nextState = PQ.removeMin().getValue();// gets value of first element in PQ
            if(nextState.isGoal()) // checks if its the goal element
                return nextState; // if yes return it
            for (Board board : nextState.neighbors()) //goes through the neighbouring boards
            {
                if (!nextState.isInPath(board)) //if child isn't in path
                {
                    board.UpdatePathToStartState(nextState);//updates path
                    int p = CalculatePriority(board);// calculate priority for child
                    PQ.insert(p, board);// insert into PQ
                }
            }
        }


        return null; // return null
    }//Best First search algorithm gotten from Antonio's code in class

    //Abstract priority queue, Heap priority queue, Priority queue, Entry and Default comparator all gotten from Antonio's examples

    protected abstract int CalculatePriority(Board state);// abstract method to calculate Priority
}