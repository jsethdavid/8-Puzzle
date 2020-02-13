public class HeuristicSearch extends BestFirstSearch //inherits methods from Best first search
{
    @Override
    protected int CalculatePriority(Board state)// implements the abstract method CalculatePriority from Best first search
    {
        int mtiles=0;
        int bsize = state.size();
        for (int i=0; i < bsize * bsize; i++)
        {
            if(state.tileAt(i/bsize,i%bsize) != (i+1)%(bsize * bsize))
                mtiles++;
        }
        return mtiles; // returns misplaced tiles
    }
}
