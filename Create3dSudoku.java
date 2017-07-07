/**
 * @author Niclas Hofmann
 */
public class Create3dSudoku
{
	private int n;
	private JEdge[] edges;
	private JNode[] nodes;
	
	public Create3dSudoku (int n)
	{
		int noe = (int)(0.5*n*n*(n-1));
		this.n = n;
		edges = new JEdge[noe];
		nodes = new JNode[n*n];
	}
	
	public void init ()
	{
		int counter = 0;
		
		for (int i = 0; i < n; ++i)
			for(int j = 0; j < n; ++j)
				nodes[i*n+j] = new JNode ((byte)i, (byte)j, (byte)n);
		
		for (int i = 0; i < n; ++i){
			for (int j = i+1; j < n; ++j){
				for (int k = 0; k < n; ++k){
					edges[counter] =
						new JEdge ((byte)(k+1), new JNode[]{nodes[i], nodes[j]});
					++counter;
				} // for k
			} // for j
		} // for i
	}
}