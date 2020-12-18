import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root; 
    int size = 0;           
    private class Node {
        private Key key; 
        private Value value;          
        private Node left, right;  
      
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            
        }
    }

   
    public Solution() {
    	root = null;
    }

    
    public boolean isEmpty() {
    	if(size() == 0){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    
    public int size() {
    	return size;
    }

   
    
    
    public Value get(Key key) {
 		if(key == null){
			throw new IllegalArgumentException("Error");
		}
 		return get(root, key);
    }
    private Value get(Node x, Key key) {
 		if(x == null){
 			return null;
 		}
			int cmp = key.compareTo(x.key);
			if (cmp < 0){
				return get(x.left, key);
			} 
			else if (cmp > 0){
				return get(x.right, key);
			}			
			else{
				return x.val;
			}
		}
   
    public void put(Key key, Value val) {
    	if (key == null){
    		throw new IllegalAccessException ("Error");
    	}
    	root = put(root, key, val);    
    }

    private Node put(Node x, Key key, Value val) {
    	if(x == null){
    	 	return new Node(key, val, 0);
    	}
	    	int cmp = key.compareTo(x.key);
	    	if(cmp < 0){
	    		x.left = put(x.left, key, val);
	    	}
	    	else if(cmp > 0){
	    		x.right = put(x.right, key, val);
	    	}
	    	else{
	    		x.val = val;
	    	}
	    	x.size = 1 + size(x.left) + size(x.right);
	    	return x;
	  }

    
    public Key min() {
    	return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) {
        	return x;
        }
        return min (x.left); 
    } 

   

    
    public Key floor(Key key) {
        Node x = floor(root, key);
        if(x == null){
        	return null;
        }
        return x.key;
    } 

    private Node floor(Node x, Key key) {
    	if(x == null){
    		return null;
    	}
    	int cmp = key.compareTo(x.key);
    	if(cmp ==0){
    		return x;
    	}
    	if(cmp < 0){
    		return floor(x.left,key);
    	}
    	Node t = floor(x.right, key);
    	if(t != null){
    		return t;
    	}
    	else{
    		return x;
    	}
    } 


    
    

    
    // public Key select(int k) {
        
    // }

   

   
    public static void main(String[] args) { 
        Solution <String, Integer> obj = new Solution<String, Integer>();
        

        obj.put("Ada",1);
        obj.put("Ballerian",3);        
        System.out.println(obj.get("Ada"));
        obj.put("Html",5);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("Ballerian"));
        obj.put("Java",8);
        obj.put("Dart",9);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());





       
    }
}