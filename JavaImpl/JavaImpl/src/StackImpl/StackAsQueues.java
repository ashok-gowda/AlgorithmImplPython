
import java.util.LinkedList;
import java.util.Queue;
/*
 * This trys to implement a stack using two queues , the current implementation uses push of order of O(n)
 * and pop of order of O(1)
 * Above Implementation Uses Two Queues
 */

 class Stack{
	 Queue<Integer> q1;
	 Queue<Integer> q2;
	 
	 Stack(){
		 q1=new LinkedList<Integer>();
		 q2=new LinkedList<Integer>();
	 }
	 
	 void push(int data){
		 q1.add(data); 
	 }
	 
	 int pop(){
		 int i=0;
		 while(i<(q1.size()-1)){
			 q2.add(q1.poll());
		 }
		 int poppedElement=q1.poll();
		 q1=q2;
		 return poppedElement;                
	 }
	 
	 void printQueue(){
		Integer arr[]=q1.toArray(new Integer[1]);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] +" ");
		}
		System.out.println(" ");
	 }
}

public class StackAsQueues {
	
	public static void main(String args[]){
		Stack stackObject=new Stack();
		stackObject.push(2);
		stackObject.push(3);
		stackObject.printQueue();
		System.out.println(stackObject.pop());
	}

}
