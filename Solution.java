import java.util.*;

public class BinarySearchTree<Key extends Comparable<Key>, Value> 
{
    private Node root;      // root of BST
    int size = 0;          // number of nodes in subtree

    private class Node 
    {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
       
        public Node(Key key, Value val) //Node constructor
        {
            this.key = key;
            this.val = val;
        }
    }

    // returns empty symbol table
    public boolean isEmpty() 
    {
        if(size() == 0)	//if the size is zero
        {
            return true;
        }
        return false;       
    }

   //returns number of key-value pairs
    public int size() 
    {
        return size(root);       //Check size at node root
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) 
    {
        if(x == null)	//if the symbol table is empty
            return 0;
        else
            return size;
    }
    
    public boolean contains(Key key) 
    {
    	//should not accept null key
		if (key == null) 
        {
            throw new IllegalArgumentException("Key cannot be null"); 
        }
        return get(key) != null;//when key is not null 
    }

    //returns value associated with key
    public Value get(Key key) 
    {
        if(key == null)	//should not accept null key
        {
	        throw new IllegalArgumentException("Argument passed in key is null");
	    }
        Node current = root;	// temporary external variable for traversing
        while(key != current.key)
        {
        	int compare = key.compareTo(current.key); //compare the key with each key of a node
        	if(compare < 0)
            {
        		current = current.left; //if key is less than root key
        	}
	        else if(compare > 0)	//else
            {
	        	current = current.right;
	        }
        }
        return current.val;
    }
    
    public void put(Key key, Value val) 
    {
        if (key == null) 	//if key is null
        {
            throw new IllegalArgumentException("Key cannot be null");
        }  

        Node newest = new Node(key, val); // create new node
        if(root == null)
        {
            root = newest;	//when the root is null
        }
        else
        {
        	Node current = root;	//for traversing through the bst 
        	Node parent;

        	while(true)
        	{
        		parent = current;	// parent node is current
        		int comp = key.compareTo(current.key);//compare the key with each key in node
	            if(comp < 0)	// to put on the left
	            {
	                current = current.left;
                    if(current == null)
                    {
                        parent.left = newest;
                        size += 1;
                        return;
                    }
	            }
	            else if(comp > 0)	// put in the right
	            {
	            	current = current.right;
	            	if(current == null)
	            	{
	            		parent.right = newest;
                        size += 1;
                        return;
	            	}
	            }
	            else
	            {
	            	current.val = val;
	                return;
        		}    
	        }            
        }
        size += 1;
    }

    public Key min() 
    {
		if (isEmpty()) //For empty symbol table
        {
            throw new NoSuchElementException("Empty symbol table");
        }

        Node current = root;

        while (current.left != null) //Finding left most node 
        { 
            current = current.left; 
        }
        return current.key;         
    } 

    // delete the minimum key in symbol table
    public void deleteMin()
    {
        if (isEmpty()) //For empty symbol table
        {
            throw new NoSuchElementException("Empty symbol table");
        }

        Node current = root;

        while (current.left != null) //Finding left most node 
        { 
            current = current.left; 
        }
        current = null;
        size--; 
    }

    public void delete(Key key)
    {
        if (isEmpty()) //For empty symbol table
        {
            throw new NoSuchElementException("Empty symbol table");
        }

        Node current = root;    
        while(key != current.key)
        {
            int compare = key.compareTo(current.key); 
            if(compare < 0)
            {
                current = current.left; //if key is less than root key
            }
            else if(compare > 0)    //else
            {
                current = current.right;
            }
        }
        current.key = null;
        size--;
    }
    //returns the largest key less than or equal to key
    public Key floor(Key key) 
    {
        if(key == null)	//cannot have null key argument
            throw new IllegalArgumentException("Argument passed in key is null");

        if(isEmpty())
        {
            throw new NoSuchElementException("Empty symbol table");
        }
        Node current = floor(root, key);	// To traverse the bst starting from root
        if(current == null)
        {
            return null;
        }
        else 
        {
            return current.key;
        }

    } 

    private Node floor(Node x, Key key) 
    {
        Node floor = null;	
        while(x != null)
        {
            int compare = key.compareTo(x.key);
            if(compare == 0)
            {
                return x;
            }
            else if(compare < 0)
            {
                x = x.left;
            }
            else
            {
                floor = x;
                x = x.right;
            }
        }
        return floor;
       
    } 

    // return the key whose rank is k
    public Key select(int k) 
    {
        if(k == 0)	//Null rank passed
        {
            throw new IllegalArgumentException("argument to get value() is null");
        }
        Node current = root; // current node is root
        while(k != 0)//when k is not null
        {
            int left = size(current.left);	//Left size of left 
            if(left > k)
            {
                current = current.left;
            }
            else if(left < k)
            {
                current = current.right;
                k = k - left - 1;
            }
            //else
              //  return current.key;
        }
        return current.key;
    }

    // returns all the keys in symbol table between the given range as an iterables
    public Iterable<Key> keys(Key lo, Key hi) 
    {
    	if(lo == null || hi == null)
    		throw new IllegalArgumentException("Minimum and Maximum endpoint should not be null");

        Stack<Node> stack = new Stack<Node>();
        ArrayList<Key> keys = new ArrayList<Key>();
        Node x = root;
        while (x != null || !stack.isEmpty()) 
        {
            if (x != null) 
            {
                stack.push(x);
                x = x.left;
            }
            else 
            {
                x = stack.pop();
                keys.add(x.key);
                x = x.right;
            }
        }
        return keys;
    } 
  
    public static void main(String[] args) 
    { 
        BinarySearchTree<String, Integer> obj = new BinarySearchTree<String, Integer>();

        obj.put("Ada", 1);
        obj.put("Ballerina", 3);
        System.out.println(obj.get("Ada"));
        obj.put("Html", 5);
        obj.put("Java", 7);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.min());
        System.out.println(obj.floor("Ballerina"));
        //System.out.println(obj.select(3));
        System.out.println(obj.keys("Ada", "Java"));
        obj.put("Java", 8);
        obj.put("Dart", 9);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());
        obj.deleteMin();
        System.out.println(obj.keys("Ballerina", "Java"));
        obj.delete("Java");
    }
}


