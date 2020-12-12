import java.util.*;
import java.util.NoSuchElementException;

public class Digraph {
    private final int V;                  // number of vertices in this digraph
    private int E;                        // number of edges in this digraph
    private LinkedList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;               // indegree[v] = indegree of vertex v
    
   
    public Digraph(int V)
    {
       
        if (V<0)
            {
                throw new IllegalArgumentException("Error");
            }
        this.V=V;
        this.E=0;

        indegree = new int[V];
        adj = (LinkedList<Integer>[]) new LinkedList[V];

        for (int i=0;i<V ;i++ )
        {
            adj[i]=new LinkedList<Integer>();            
        }
        
    }    
    
    public int V()
    {
        return V;
       
    }
    
    public int E()
    {
        return E;
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v)
    {

        if (v<0 || v>=V)
        {
            System.out.println("Vertex out of range.");            
        }
    }
   
    public void addEdge(int v, int w)
    {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;        
    }

    public Iterable<Integer> adj(int v)
    {
        if(v<0 || v>V) throw new IllegalArgumentException ("Vertex out of range.");

        validateVertex(v);
        return adj[v];
    }
   
   
    public Digraph reverse()
    {

        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) 
        {
            for (int w : adj(v))
            {
                R.addEdge(w, v);
            }
        }
        return R;
    }

       
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        String NEWLINE=System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++)
        {
            s.append(String.format("%d: ", v));
            for (int w : adj[v])
            {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args)
    {

        Digraph d=new Digraph(10);

        d.addEdge(0,2);
        d.addEdge(1,4);
        d.addEdge(2,6);
        d.addEdge(3,1);
        d.addEdge(4,8);
        d.addEdge(5,0);
        d.addEdge(6,8);
        d.addEdge(7,1);
        d.addEdge(8,0);
        d.addEdge(9,8);
        


        d.validateVertex(2);

       
        System.out.println(d.toString());

        System.out.println("after reversing :");
        System.out.println(d.reverse());
        System.out.println("Vertices:"+d.V());
        System.out.println("Edge:"+ d.E());


       



    System.out.println("_______________________ALL TEST CASE PASSED_________________________");
        

    }

}