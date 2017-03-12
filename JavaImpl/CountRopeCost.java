package TreeImplementations;

class BinaryHeap{
	  int arr[];
	  int capacity;
	  int lengthOfArray;
public BinaryHeap(int arr[],int capacity){
		  this.arr=arr;
		  this.capacity=capacity;
		  lengthOfArray=capacity-1;
	  }
	  
	 int getParent(int i){
		 return (i-1)/2;
	 }
	 
	 int getLeftChild(int i){
		 return 2*i+1;
	 }
	 
	 int getRightChild(int i){
		 return 2*i+2;
	 }
	 
	 void swap(int arr[],int i,int j){
		 int temp=arr[i];
		 arr[i]=arr[j];
		 arr[j]=temp;
	 }
	 
	 void heapify(int i,int n){
		 int largest=i;
		 if(getLeftChild(i)<n && arr[largest]>arr[getLeftChild(i)]){
			 largest=getLeftChild(i);
		 }
		 int rightChild=getRightChild(i);
		 if(getRightChild(i)<n && arr[largest]>arr[getRightChild(i)]){
			 largest=rightChild;
		 }
		 
		 if(largest!=i){
			 swap(arr,i,largest);
			 heapify(largest,n);
		 }
	 }
	 
	void createMinHeap(){
		for(int i=arr.length/2-1;i>=0;i--){
			heapify(i,arr.length);
		}
	}
	
	void insertHeap(int data){
		 arr[++lengthOfArray]=data;
		 int i=lengthOfArray;
		 while(i>0){
			 if(arr[getParent(i)]>arr[data]){
				 swap(arr,lengthOfArray,getParent(i));
				 i=getParent(i);
			 }
		 }
	}
	
	int getMin(){
		return arr[0];
	}
	
	void extractMin(){
		swap(arr,0,lengthOfArray);
		lengthOfArray--;
		heapify(0,lengthOfArray);
	}
}


public class CountRopeCost {
	
	public static void main(String args[]){
		int arr[]={13,2,5,12,3,4,5};
		BinaryHeap b=new BinaryHeap(arr,7);
		b.createMinHeap();
		System.out.println(b.getMin());
	}

}
