
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


class LLNode{
	  private int data;
	   LLNode next;
	  
	  public LLNode(int data){
		  this.data=data;
		  this.next=null;
	  }
	  
	  public  int getData(){
		  return data;
	  }
	  
	  public LLNode getNextNode(){
		  return next;
	  }
	  
	  public void setNextLLNode(LLNode next){
		  this.next=next;
	  }
}


public class SortNumbersOnDifferentMachine {
       private List<LLNode> heapOfMachineHeads;
       
       public SortNumbersOnDifferentMachine(){
    	   heapOfMachineHeads=new Vector<>();
       }
       
       public void addMachineToHeap(LLNode headOfMachine){
    	   heapOfMachineHeads.add(headOfMachine);
       }
       
       public int getParent(int i){
    	   return (i-1)/2;
       }
       
       public int getLeftChild(int i){
    	   return 2*i+1;
       }
       
       public int getRightChild(int i){
    	   return 2*i+2;
       }
       
       public void swap(List<LLNode> listOfNodes,int index1,int index2){
    	    LLNode temp=listOfNodes.get(index1);
    	    LLNode temp2=listOfNodes.get(index2);
    	    listOfNodes.set(index1,temp2);
    	    listOfNodes.set(index2,temp);
       }
       
       public void heapify(int i,int sizeOfHeap){
    	   int smallest=i;
    	   int leftChildIndex=getLeftChild(i);
    	   if(leftChildIndex<sizeOfHeap &&
    			   heapOfMachineHeads.get(smallest).getData()>heapOfMachineHeads.get(leftChildIndex).getData()){
    		   smallest=leftChildIndex;
    	   }
    	   int rightChildIndex=getRightChild(i);
    	   if(rightChildIndex<sizeOfHeap && heapOfMachineHeads.get(smallest).getData()
    			   >heapOfMachineHeads.get(rightChildIndex).getData()){
    		  smallest=rightChildIndex;
    	   }
    	   
    	   if(smallest!=i){
    		   swap(heapOfMachineHeads,i,smallest);
    		   heapify(smallest,sizeOfHeap);
    	   }
       }
       
       public void createMinHeap(){
    	   int sizeofHeap=heapOfMachineHeads.size();
    	   for(int i=(sizeofHeap/2-1);i>=0;i--){
    		   heapify(i,sizeofHeap);
    	   }
       }
       
       public void getValuesofAllNodes(){
    	   for(int i=0;i<heapOfMachineHeads.size();i++){
    		   System.out.print(heapOfMachineHeads.get(i).getData()+" ");
    	   }
    	   System.out.println();
       }
	
       
       public int extractMin(){
    	   int valueToBeReturned=0;
    	   int sizeOfHeap=heapOfMachineHeads.size()-1;
    	   if(sizeOfHeap<0){
    		   return valueToBeReturned;
    	   }
    	   else{
    		   swap(heapOfMachineHeads,0,sizeOfHeap);
    		   valueToBeReturned=heapOfMachineHeads.get(sizeOfHeap).getData();
    	     LLNode nextNode=heapOfMachineHeads.get(sizeOfHeap).getNextNode();
    	     if(nextNode==null){
    	    	 heapOfMachineHeads.remove(sizeOfHeap);
    	     }
    	     else{
    	    	 heapOfMachineHeads.set(sizeOfHeap,nextNode);
    	    	 int i=sizeOfHeap;
    	    	 createMinHeap();
    	     }
    		   
    	   }
    	   return valueToBeReturned;
       }
	
       public static void main(String args[]){
    	   LLNode headOfFirstMachine=new LLNode(3);
    	   headOfFirstMachine.next=new LLNode(5);
    	   headOfFirstMachine.next.next=new LLNode(7);
    	   LLNode headOfSecondMachine=new LLNode(1);
    	   headOfSecondMachine.next=new LLNode(2);
    	   headOfSecondMachine.next.next=new LLNode(8);
    	   headOfSecondMachine.next.next.next=new LLNode(10);
    	   LLNode head3=new LLNode(15);
    	   head3.setNextLLNode(new LLNode(16));
    	   head3.next.next=new LLNode(21);
    	   SortNumbersOnDifferentMachine sort=new SortNumbersOnDifferentMachine();
    	   sort.addMachineToHeap(headOfFirstMachine);
    	   sort.addMachineToHeap(headOfSecondMachine);
    	   sort.addMachineToHeap(head3);
    	   sort.createMinHeap();
   int  value=sort.extractMin();
    	   while(value!=0){
    		   System.out.println(value);
    		  value=sort.extractMin();
    	   }
    	   
       }
}
