package TreeImplementations;

public class HeapSort{
	  int arr[];
	  int n;
	  
	  HeapSort(int n,int arr[]){
		  this.arr=arr;
		  this.n=n;
	  }
	  
	  
	  void heapify(int arr[],int size,int i){
		  int largest=i;
		  int leftchild=2*i+1;
		  if(leftchild<size && arr[leftchild]>arr[largest]){
			  largest=leftchild;
		  }
		  int rightchild=2*i+2;
		  if(rightchild<size && arr[rightchild]>arr[largest]){
			 largest=rightchild;
		  }
		  if(largest!=i){
			  int temp=arr[i];
			  arr[i]=arr[largest];
			  arr[largest]=temp;
			  heapify(arr,size,largest);
		  }
		  
	  }
	  
	  void HeapSort(){
		  for(int i=n/2-1;i>=0;i--){
			  heapify(arr,n,i);
		  }
		   printArray();
		  for(int i=(n-1);i>0;i--){
			  int temp=arr[0];
			  arr[0]=arr[i];
			  arr[i]=temp;
			  heapify(arr,i,0);
		  }
	  }
	  
	  void printArray(){
		  for(int i=0;i<arr.length;i++){
			  System.out.print(arr[i]+" ");
		  }
		  System.out.println(" ");
	  }
	  
	  public static void main(String args[]){
		  int arr[]={12,3,10,14,2,9};
		  HeapSort obj=new HeapSort(6,arr);
		  obj.HeapSort();
		  obj.printArray();
	  }
}