package TreeImplementations;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
/*
 * This class is to find the immediate ancestor of a tree
 * using stack
 */

class TreeNode{
	  
	  int data;
	  List<TreeNode>parent;
	  TreeNode left;
	  TreeNode right;
	 public TreeNode(int data,TreeNode left,TreeNode right){
		 this.data=data;
		 this.left=left;
		 this.right=right;
		 this.parent=new ArrayList<TreeNode>();
	 }
}



public class AncestorsInaTree {

	TreeNode root;
	Stack<TreeNode> stackOfTreeNodes;
	
	public AncestorsInaTree(TreeNode root){
		this.root=root;
		stackOfTreeNodes=new Stack<TreeNode>();
	}
	
	public void findAncestors(TreeNode node){
		  if(node!=null){
			  if(!stackOfTreeNodes.empty()){
				  for(TreeNode parent:stackOfTreeNodes){
					  node.parent.add(parent);
				  }
			  }
			  stackOfTreeNodes.push(node);
			  findAncestors(node.left);
			  findAncestors(node.right);
			  stackOfTreeNodes.pop();
		  }
	}
	
	public  void printAncestors(TreeNode rootPointer){
		if(rootPointer==null)
			return;
		System.out.println("Node root"+rootPointer.data);
		for(TreeNode Ancestor:rootPointer.parent){
			System.out.print(Ancestor.data+" ");
		}
		System.out.println();
		printAncestors(rootPointer.left);
		printAncestors(rootPointer.right);
		
	}
	
	public static void main(String args[]){
		TreeNode root=new TreeNode(10,null,null);
		root.left=new TreeNode(2,null,null);
		root.right=new TreeNode(3,null,null);
		root.left.left=new TreeNode(100,null,null);
		AncestorsInaTree resultObject=new 
				AncestorsInaTree(root);
		resultObject.findAncestors(root);
		resultObject.printAncestors(root);
	} 
	
}
