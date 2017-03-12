package TreeImplementations;

class SegmentTree{
	  int st[]; //Array to store segment tree
	  
	  void constructSegmentArray(int arr[],int n){
		  int heightofTree=(int)Math.ceil(Math.log(n)/Math.log(2));
		  int sizeOfArray=4*n;
		  st=new int[sizeOfArray];
		  fillSegmentValues(arr,0,n-1,0);
	  }
	  
	  int mid(int start,int end){
		  return start+(end-start)/2;
	  }
	  
	  int min(int a,int b){
		  return a<b?a:b;
	  }
	  
	 int fillSegmentValues(int arr[],int startingIndex,
			 int endingIndex,int segmentIndex){
		 System.out.println(startingIndex +" "+endingIndex +" "+segmentIndex);
		 printSegmentArray();
		 if(startingIndex==endingIndex){
			 st[segmentIndex]=arr[startingIndex];
			 
			 return st[segmentIndex];
		 }
		 int middleIndex=mid(startingIndex,endingIndex);
		 int returnedvalue=
				 min(fillSegmentValues(arr,startingIndex,middleIndex,2*segmentIndex+1),
					 fillSegmentValues(arr,middleIndex+1,endingIndex,2*segmentIndex+2));
		 return returnedvalue;
	 }
	 
	 public void printSegmentArray(){
		 for(int i=0;i<st.length;i++){
			 System.out.print(st[i]+" ");
		 }
		 System.out.println(" ");
	 }
	 
	 int minimumQuery(int startingIndexOfArray,int endingIndexOfArray,int qs,int qe,int segmentIndex){
		 if(qs<=startingIndexOfArray && qe>=endingIndexOfArray){
			 return st[segmentIndex];
		 }
		 if(endingIndexOfArray<qs || startingIndexOfArray> qe)
			 return Integer.MAX_VALUE;
		 int middleIndex=mid(startingIndexOfArray,endingIndexOfArray);
		 int returnedValue=min(minimumQuery(startingIndexOfArray,middleIndex,qs,qe,2*segmentIndex+1)
				 ,minimumQuery(middleIndex+1,endingIndexOfArray,qs,qe,2*segmentIndex+2));
		 return returnedValue;
	 }
	 
	 
	 public static void main(String args[]){
		 int arr[]={1,3,2,7,9,11};
		 SegmentTree tree=new SegmentTree();
		 tree.constructSegmentArray(arr, 6);
		 System.out.println(tree.minimumQuery(0,5,1,3,0));
		 
	 }
	  
	   
}