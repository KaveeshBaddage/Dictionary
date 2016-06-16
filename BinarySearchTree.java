import java.io.*;

public class BinarySearchTree {
	public static  Node root;
	public BinarySearchTree(){
		this.root = null;
	}
	
	public boolean find(String d){
		String id = d.toLowerCase();
		Node current = root;
		while(current!=null){
			if((current.data).equals(id)){
				return true;
			}else if(((current.data).compareTo(id))>0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	public boolean delete(String d){
		String id = d.toLowerCase();
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(((current.data).equals(id))==false){
			parent = current;
			if(((current.data).compareTo(id))>0){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		
		public void search(String sWord){
			String id = d.toLowerCase();
		Node current = root;
		while(current!=null){
			if((current.data).equals(id)){
				System.out.println(current.meaning);
			}else if(((current.data).compareTo(id))>0){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		System.out.println("Word is not there");
		}
			
		
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	public void insert(String d ,String m){
		String id = d.toLowerCase();
		Node newNode = new Node(id,m);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){  //(((current.data).compareTo(id))>0)
			parent = current;
			if(((current.data).compareTo(id))>0){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	public static void main(String arg[]){
		/*BinarySearchTree b = new BinarySearchTree();
		b.insert("e","asd");b.insert("B","sdf");
		/*b.insert("i");b.insert("D");b.insert("a");b.insert("f");b.insert("h");b.insert("g");
		b.insert("j");b.insert("k");b.insert("n");b.insert("c");
		System.out.println("Original Tree : ");
		b.display(b.root);
		System.out.println("");
		System.out.println("Check whether Node with value ABC exists : " + b.find("ABC"));
		System.out.println("try to delete node that not exist : " + b.delete("Abc"));		
		b.display(root);
		System.out.println("\n Delete Node  AB: " + b.delete("AB"));		
		b.display(root);
		System.out.println("\n Delete Node A : " + b.delete("A"));		
		b.display(root);*/
	}
}

class Node{
	String data;
	String meaning;
	Node left;
	Node right;	
	public Node(String d,String m){
		String data = d.toLowerCase();
		meaning = m;
		this.data = data;
		left = null;
		right = null;
	}
}