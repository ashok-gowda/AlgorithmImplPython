package TreeImplementations;
/*http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * Given a cost matrix cost[][] and a position (m, n) in cost[][],
 *  write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 *   Each cell of the matrix represents a cost to traverse through that cell. 
 *   Total cost of a path to reach (m, n) is sum of all the costs on that path 
 *   (including both source and destination). 
 *   You can only traverse down, right and diagonally lower cells from a given cell,
 *    i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
 *     You may assume that all costs are positive integers.
 * 
 * 
 * 
 */

public class MinimumSourcePath {
	public int arr[][];
	public int row;
	public int column;
	public int dp[][];
	
	public void fillValuesInArray(){
		dp=new int[row][column];
		dp[0][0]=arr[0][0];
		for(int i=1;i<column;i++){
			dp[0][i]=dp[0][i-1]+arr[0][i];
		}
		for(int i=1;i<row;i++){
			dp[i][0]=dp[i-1][0]+arr[i][0];
		}
		for(int i=1;i<row;i++){
			for(int j=1;j<column;j++){
				dp[i][j]= Math.min(dp[i-1][j]+arr[i][j],Math.min(
						dp[i-1][j-1]+arr[i][j],dp[i][j-1]+arr[i][j]));
			}
		}
		
	}
	
	public static void main(String args[]){
		MinimumSourcePath path=new MinimumSourcePath();
		int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
		path.arr=cost;
		path.row=3;
		path.column=3;
		path.fillValuesInArray();
		System.out.println(path.dp[2][2]);
	}

}
