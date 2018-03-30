package trees;

class Node
{
    int value;
    Node left, right;
 
    public Node(int item)
    {
        value= item;
        left = right = null;
    }
}
 
public class BST
{
    //Root of the Binary Tree
    Node root;
    
    private boolean isBST() {
		
		return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
    
    private static boolean isBSTUtil(Node n,int min,int max){
    	if(n==null){
    		return true;
    	}
     if(n!=null && n.value>=min && n.value<=max){
    	 return isBSTUtil(n.left,min,n.value) && isBSTUtil(n.right,n.value,max);
     }
     return false;
    	
    }
    
    public static void main(String args[])
    {
        BST tree = new BST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
 
       
            System.out.println("IS BST"+tree.isBST());
       
    }
}

 
