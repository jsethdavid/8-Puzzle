public class BreadthFirstSearch extends BestFirstSearch // inherits methods from Best first search
{
    @Override
    protected int CalculatePriority(Board state)// implements the abstract method CalculatePriority from Best first search
    {
        return state.getDepth(); // gets path depth
    }
}

