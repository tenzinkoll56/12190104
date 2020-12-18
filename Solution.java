import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> 
{
    private Node root;      
    int size = 0;          

    private class Node 
    {
        private Key key;           
        private Value val;         
        private Node left, right;  
       
        public Node(Key key, Value val) 
        {
            this.key = key;
            this.val = val;
        }
    }

   
    public boolean isEmpty() 
    {
        if(size() == 0)	
        {
            return true;
        }
        return false;       
    }

   
    public int size() 
    {
        return size(root);      
    }

   
    private int size(Node x) 
    {
        if(x == null)	
            return 0;
        else
            return size;
    }
    
    public boolean contains(Key key) 
    {
    	
		if (key == null) 
        {
            throw new IllegalArgumentException("Key cannot be null"); 
        }
        return get(key) != null;
    }

    
    public Value get(Key key) 
    {
        if(key == null)	
        {
	        throw new IllegalArgumentException("Argument passed in key is null");
	    }
        Node current = root;	
        while(key != current.key)
        {
        	int compare = key.compareTo(current.key); 
        	if(compare < 0)
            {
        		current = current.left; 
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
        if (key == null) 	/if key is null
        {
            throw new IllegalArgumentException("Key cannot be null");
        }  

        Node newest = new Node(key, val); 
        if(root == null)
        {
            root = newest;	
        }
        else
        {
        	Node current = root;	 
        	Node parent;

        	while(true)
        	{
        		parent = current;	
        		int comp = key.compareTo(current.key);
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
		if (isEmpty()) 
        {
            throw new NoSuchElementException("Empty symbol table");
        }

        Node current = root;

        while (current.left != null) 
        { 
            current = current.left; 
        }
        return current.key;         
    } 

   
    public void deleteMin()
    {
        if (isEmpty()) 
        {
            throw new NoSuchElementException("Empty symbol table");
        }

        Node current = root;

        while (current.left != null)  
        { 
            current = current.left; 
        }
        current = null;
        size--; 
    }

    public void delete(Key key)
    {
        if (isEmpty()) 
        {
            throw new NoSuchElementException("Empty symbol table");
        }

        Node current = root;    
        while(key != current.key)
        {
            int compare = key.compareTo(current.key); 
            if(compare < 0)
            {
                current = current.left; 
            }
            else if(compare > 0)    
            {
                current = current.right;
            }
        }
        current.key = null;
        size--;
    }
    
    public Key floor(Key key) 
    {
        if(key == null)	
            throw new IllegalArgumentException("Argument passed in key is null");

        if(isEmpty())
        {
            throw new NoSuchElementException("Empty symbol table");
        }
        Node current = floor(root, key);	
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


