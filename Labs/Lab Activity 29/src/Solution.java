
public class Solution {
	
	public boolean validTicTacToe(String[] board)
	{
		int xCount = 0;
		int oCount = 0;
		int[] column = new int[3];
		int[] row = new int[3];
		int diagTL = 0;
		int diagTR = 0;
		boolean xWin = false;
		boolean oWin = false;
		
		for(int r = 0; r < 3; r++)
		{
			for(int c = 0; c < 3; c++)
			{
				String tile = board[r].substring(c, c + 1);
				if(tile.equals("X"))
				{
					xCount++;
					row[r]++;
					column[c]++;
					if(r == c)
						diagTL++;
					if(r + c == 2)
						diagTR++;
				}
				else if(tile.equals("O"))
				{
					oCount++;
					row[r]--;
					column[c]--;
					if(r == c)
						diagTL--;
					if(r + c == 2)
						diagTR--;
				}
			}
		}
		
		for(int x : row)
		{
			if(row[x] == 3)
				xWin = true;
			else if(row[x] == -3)
				oWin = true;
		}
		
		for(int x : column)
		{
			if(x == 3)
				xWin = true;
			else if(x == -3)
				oWin = true;
		}
		
		if(diagTL == 3 || diagTR == 3)
			xWin = true;
		if(diagTL == -3 || diagTR == -3)
			oWin = true;
		
		if(oCount == 1 && xCount == 0)
			return false;
		
		if(xCount - oCount > 1 || oCount - xCount > 0)
			return false;
		
		if(xWin && oWin)
			return false;
		
		return true;
	}
}
