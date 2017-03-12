package TreeImplementations;
/*
 * http://www.geeksforgeeks.org/sort-array-converting-elements-squares/
 * Given a array of both positive and negative integers ‘arr[]’ which are sorted. Task is to sort square of the numbers of the Array.
 */
public class SortArraysAfterConvertingToSquare {
	
	public static void main(String args[]){
		int arr[] = { -6 , -3 , -1 , 2 , 4 , 5 };
		int changeToPositive=0;
		while(arr[changeToPositive]<0){
			++changeToPositive;
		}
		int negativeSquare[]=new int[changeToPositive];
		int t=-1;
		for(int i=(changeToPositive-1);i>=0;i--){
			negativeSquare[++t]=arr[i]*arr[i];
		}
		int negativeIndex=0,positiveIndex=changeToPositive;
		int totalSize=arr.length;
		int result[]= new int [totalSize];
		int k=0;
		while(negativeIndex<changeToPositive && positiveIndex<totalSize){
			if(negativeSquare[negativeIndex]<(arr[positiveIndex]*arr[positiveIndex])){
				result[k]=negativeSquare[negativeIndex];
				negativeIndex++;
				++k;
			}
			else{
				result[k]=arr[positiveIndex]*arr[positiveIndex];
				positiveIndex++;
				++k;
			}
		}
		while(negativeIndex< changeToPositive){
			result[k]=negativeSquare[negativeIndex];
			negativeIndex++;
			++k;
		}
		
		while(positiveIndex<totalSize){
			result[k]=arr[positiveIndex]*arr[positiveIndex];
			positiveIndex++;
			++k;
		}
	 
		for(int i=0;i<totalSize;i++){
			System.out.print(result[i]+" ");
		}
	}

}
