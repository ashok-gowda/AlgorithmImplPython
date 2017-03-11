package TreeImplementations;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

class Position{
	int i,j;

	
	
	public Position(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "Position [i=" + i + ", j=" + j + "]";
	}
	
}

public class MaximumSizeSubarray {

	int arr[][];
	int subArray[][];
	int r;
	int c;
	
	public MaximumSizeSubarray(int arr[][],int r,int c) {
		this.arr=arr;
		subArray=new int[r][c];
		this.r=r;
		this.c=c;
	}
	
	public Position fillSubArray(int arr[][],int r,int c){
		int maxValue=0;
		Position maxPosition=new Position(-1,-1);
		for(int i=0;i<r;i++){
			subArray[i][0]=arr[i][0];
		}
		for(int i=0;i<c;i++){
			subArray[0][i]=arr[0][i];
		}
		
		for(int i=1;i<r;i++){
			for(int j=1;j<c;j++){
				if(arr[i][j]==1)
				subArray[i][j]=Math.min(Math.min(subArray[i-1][j],subArray[i][j-1]),subArray[i-1][j-1])+1;
				else
			    subArray[i][j]=0;
				if(maxValue<subArray[i][j]){
				   maxValue=subArray[i][j];
				   maxPosition=new Position(i,j);
				}
			}
		}
		return maxPosition;
	}
	
	
	
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int arr[][]=new int[r][c];
		for(int i=0;i<r;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++){
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		MaximumSizeSubarray obj=new MaximumSizeSubarray(arr,r,c);
		System.out.println(obj.fillSubArray(arr, r, c).toString());
		System.exit(0);
	}
			
}
