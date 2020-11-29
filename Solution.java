public class Solution<Key extends Comparable<Key>, Value>  {
    private Node root;
    int size = 0;             // root of BST

    private class Node {
        private Key key;           
        private Value val;         
        private Node left, right;  

        public Node(Key key, Value val) {
            this.key = key; //Initialized 
            this.val = val;
        }
    }
    public boolean isEmpty() {
        if(size == 0){ //check whether the list is empty or not.
            return true;
        }
        return false;
    }
    public int size() {
      return size; //it will return size;
    }
    
   
    /*Inserts the specified key-value pair into the symbol table comparing the 
    key from root, overwriting the old value with the new value if the symbol 
    table already contains the specified key.*/

    public void put(Key key, Value val){
        if (key == null) 
            throw new IllegalArgumentException("first argument to put() is null");
        Node n= new Node(key,val); //created new node n.
        
        if(root == null){
            root = n;                 //if the list is empty, newill be root.
        }
        else{
            Node x = root;      //root is assign to x.
            Node parent;
            while(true){
                parent = x;
                int cmp = key.compareTo(x.key); //compare the keys
                if(cmp < 0){
                    x = x.left;
                    if(x == null){
                        parent.left = n;
                        size = size + 1;  //size increment
                    }
                    //if key is same to x it will replace it.
                    else if(x.key == key){
                        x.val = val;
                        return;
                    }
                }
                else if(cmp > 0){
                    x = x.right;   
                    if(x == null){
                        
                        parent.right = n;
                        size = size + 1;  //size will increase by 1.
                        return;
                    }
                    else if(x.key == key){              //if key is equal to x it will replace it.
                        x.val = val;
                        return;
                    }
                }
            }
        }
        size = size + 1;
    }
   

    public Value get(Key key) {
        if(key == null ) 
            throw new IllegalArgumentException("argument to get() is null");
        if(size()==0) 
            throw new NoSuchElementException("called get() with empty symbol table");

        Node x = root;
        while(x != null){
            int com = key.compareTo(x.key);
            if      (com < 0) x = x.left;
            else if (com > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    //return the smallest key from the tree

    public Key min() {
       if(isEmpty()){
        throw new NoSuchElementException("There is no element in the tree");
       }
       else{
            Node n = root;
            while(n.left != null){
                n = n.left;//while the left n is not null, n is pointed to left side.
            }
            return n.key;// it will return the key of the node.
       }
    } 



    /* traverse through the tree and return the Node whose key is less or equal 
    to given key but greatest key compare to other key in the tree. if the given key
    does not have floor key it will return null*/
       
    public Key floor(Key key) {
        if(isEmpty()){
            throw new NoSuchElementException(" Empty symbol table");
        }
        Node n = root;
        Node parent = null;                 //declare parents as null
        while(n != null){
            parent = n;                      //n is assign to parent
            int cmp = key.compareTo(parent.key);
            if(key == null){
                throw new IllegalArgumentException("argument is getting null");
            }
            if(cmp == 0){
                return parent.key;
            }
            if(cmp < 0){
                n = parent.left;
            }
            else if(cmp > 0){               
                n = parent.right;               
                int vmp = key.compareTo(n.key);
                if(vmp < 0){
                    return parent.key;
                }
                else{            
                    n = parent.right;
                }
            }
        }
        return parent.key;
    } 
     /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */

    //  public Key select(int rank){

    //     if(rank<0 || rank>=size()) 
    //     throw new NoSuchElementException("rank out of limit");

    //     Node temp = select(root, rank);
    //     if(temp!=null){
    //         return temp.key;
    //     } 
            
    //     return null;
    // }

    
    // private Node select(Node x, int rank){      
        
    //     while(x!=null){
    //         int t = size(x.left);

    //         if(t>rank) x = x.left;

           
    //         else if(t<rank){
    //             x = x.right;
    //             rank = rank-t-1;
    //         }

            
    //         else return x;
    //     }
    //     return null;

    // }
 
    
    public static void main(String[] args){ 
        
        Solution <String,Integer> obj = new Solution <String,Integer>();
        obj.put("ABDUL",1);
        obj.get("ABDUL");
        obj.put("HRITHIK",2);
        obj.put("SAI",3);
        obj.put("SAMAL",6);
        obj.get("SAI");  
        obj.put("TASHI",4);

        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("HRITHIK"));
        System.out.println(obj.floor("HAHA"));

        obj.put("CHIMI",5);
        obj.put("SAMAL",4);
        obj.get("SAMAL");
        obj.put("NIMA",7);

        System.out.println(obj.size());
        obj.get("CHIMI");
        System.out.println(obj.floor("CHIMI"));
        obj.put("SONAM",8);
        System.out.println("ABDUL CHIMI HRITHIK NIMA SAI SAMAL SONAM TASHI");

    }

}
