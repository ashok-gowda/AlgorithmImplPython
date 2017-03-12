package StackImpl;
/* This program is to implement two stacks as an array */
public class ImplementStackInArray {
	 int array[];
	 int top1,top2;
	 int size;
	 
	 public ImplementStackInArray(int n) {
		array=new int[n];
		top1=-1;
	    top2=n;
	    size=n;
	}
	 
	public void pushIntoFirstStack(int data){
		if(top2-top1>=1){
		array[++top1]=data;
		System.out.println(data+"pushed into array at index"
				+top1);
		}
		else{
			System.out.println("No more space left in stack");
		}
	}
	
	public void pushIntoSecondStack(int data){
		if(top2-top1>=1){
			array[--top2]=data;
		System.out.println(data+"pushed into array at index"
				+top2);
		}
		else{
			System.out.println("No more space left in stack");
		}
	}
		
	public int popDataFromStack1(){
		if(top1>=0)
		return array[top1--];
		else{
			System.out.println("Stack1 Empty");
			System.exit(1);
		}
		return 0;
	}
	
	public int popDataFromStack2(){
		if(top2<=size){
		return array[top2++];
		}
		else{
			System.out.println("Stack2 Empty");
			System.exit(1);
		}
		return 0;
	}

	public static void main(String args[]){
		ImplementStackInArray stackObject=new ImplementStackInArray(6);
		stackObject.pushIntoFirstStack(12);
		stackObject.pushIntoFirstStack(12);
		stackObject.pushIntoFirstStack(12);
		stackObject.pushIntoSecondStack(10);
		stackObject.pushIntoSecondStack(10);
		stackObject.pushIntoSecondStack(10);
		System.out.println(stackObject.popDataFromStack1());
		System.out.println(stackObject.popDataFromStack2());
	}
	
}
