/**
 * @author Niclas Hofmann
 */
public class Create3dSudokuSimpleBacktracking
{
	private int n;
	private int n2;
	private int[][][] _3dSudoku; // x, y, z

	/**
	 * Creates an instance of an empty 3d-Sudoku with 3x3 boxes.
	 */
	public Create3dSudokuSimpleBacktracking ()
	{
		init(3);
	}

	/**
	 * Creates an instance of an empty 3d-Sudoku with nxn boxes.
	 */
	public Create3dSudokuSimpleBacktracking (int n)
	{
		init(n);
	}

	/**
	 * Prints out the 3d-Sudoku.
	 */
	public void print3dSudoku ()
	{
		for (int z = 0; z < n2; ++z){
			System.out.println ("Ebene " + (z+1));
			for (int y = 0; y < n2; ++y){
				for (int x = 0; x < n2; ++x){
					System.out.print (_3dSudoku[x][y][z] + " ");
				} // for x
				System.out.println ();
			} // for y
			System.out.println ();
		} // for z
	}

	/**
	 * Creates a 3d-Sudoku.
	 */
	public void create3dSudoku ()
	{
		if (!backtrack (0, 0, 0))
			System.err.println ("ERROR: could not create a 3d-Sudoku!!!");
	}

	/**
	 * Returns the 3d-Sudoku.
	 */
	public int[][][] get3dSudoku()
	{
		return _3dSudoku;
	}

	private void init (int n)
	{
		this.n = n;
		n2 = n * n;
		_3dSudoku = new int[n2][n2][n2];

		for (int z = 0; z < n2; ++z)
			for (int y = 0; y < n2; ++y)
				for (int x = 0; x < n2; ++x)
					_3dSudoku[x][y][z] = 0;
	}

	private boolean isLegal (int x, int y, int z)
	{
		if (!areRowsAndColumnsOk (x, y, z) || !areBoxesOk (x, y, z))
			return false;
		return true;
	}

	private boolean areRowsAndColumnsOk (int x, int y, int z)
	{
		for (int i = 0; i < n2; ++i)
			if ((i != x && _3dSudoku[i][y][z] == _3dSudoku[x][y][z])
				|| (i != y && _3dSudoku[x][i][z] == _3dSudoku[x][y][z])
				|| (i != z && _3dSudoku[x][y][i] == _3dSudoku[x][y][z]))
				return false;
		return true;
	}

	private boolean areBoxesOk (int x, int y, int z)
	{
		int tx = x % n;
		int ty = y % n;
		int tz = z % n;

		for (int j = 0; j < n; ++j)
			for (int i = 0; i < n; ++i)
				if ((tx != i && ty != j && _3dSudoku[x-tx+i][y-ty+j][z] == _3dSudoku[x][y][z])
					|| (tz != i && ty != j && _3dSudoku[x][y-ty+j][z-tz+i] == _3dSudoku[x][y][z])
					|| (tx != i && tz != j && _3dSudoku[x-tx+i][y][z-tz+j] == _3dSudoku[x][y][z]))
						return false;
		return true;
	}

	private boolean backtrack (int x, int y, int z)
	{
		if (x == n2){ // check if line finished
			x = 0;
			++y;
		}

		if (y == n2){ // check if plag finished
			y = 0;
			++z;
		}

		if (z == n2)
			return true; // 3d-Sudoku created / solved

		for (int i = 0; i < n2; ++i){
			_3dSudoku[x][y][z] = i+1;
			if (isLegal (x, y, z))
				if (backtrack (x+1, y, z))
					return true;
		} // for i

		_3dSudoku[x][y][z] = 0;

		return false;
	}
}
