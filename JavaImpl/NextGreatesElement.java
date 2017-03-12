package StackImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Node{
	 int value;
	 int arrayIndex;
	 
	 public Node(int value,int arrayIndex){
		 this.value=value;
		 this.arrayIndex=arrayIndex;
	 }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getArrayIndex() {
		return arrayIndex;
	}

	public void setArrayIndex(int arrayIndex) {
		this.arrayIndex = arrayIndex;
	}
	 
	 
	 
	 
}

public class NextGreatesElement {
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br=new 
				BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int arr[]=new int[n];
		st=new StringTokenizer(br.readLine());
		Stack<Node> stackNode=new Stack<Node>();
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
			stackNode.add(new Node(arr[i],i));
		}
		int greatestValue=-1;
		while(!stackNode.isEmpty()){
			 Node t=stackNode.pop();
			 if(greatestValue>t.value){
				 arr[t.arrayIndex]=greatestValue;
			 }
			 else{
				 greatestValue=t.value;
				 arr[t.arrayIndex]=-1;
			 }
		}
		for(int i=0;i<n;i++){
			System.out.println(arr[i]);
		}
		
	}

}
