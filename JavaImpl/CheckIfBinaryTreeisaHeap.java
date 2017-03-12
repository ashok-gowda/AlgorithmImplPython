package TreeImplementations;

class Node{
	  int data;
	  Node left;
	  Node right;
	  
	  Node(int data){
		  this.data=data;
	  }
}

public class CheckIfBinaryTreeisaHeap {
	 
	 
	 CheckIfBinaryTreeisaHeap(){
		 
	 }
	 
	boolean checkIfBinaryTreeIsHeap(Node root) {
		if (root == null)
			return true;
		else if (root.left == null && root.right != null)
			return false;
		else if (root.left != null && root.right != null) {
			if (root.data < root.left.data || root.data < root.right.data) {
				return false;
			}
		}
		 return checkIfBinaryTreeIsHeap(root.left)&& checkIfBinaryTreeIsHeap(root.right);
		
	}
	
	
	public static void main(String args[])
    {
		CheckIfBinaryTreeisaHeap bt = new CheckIfBinaryTreeisaHeap();
         
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);
 
        if(bt.checkIfBinaryTreeIsHeap(root) == true)
            System.out.println("Given binary tree is a Heap");
        else
            System.out.println("Given binary tree is not a Heap");
    }

}
