//SAVANNAH MORGAN :)
//import
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Stack;
import java.util.Arrays; 

public class DFSu {
    public static int count = -1; 
//Implements a depth-first search traversal of a given graph
//Input: Graph G = ⟨V , E⟩ 
//Output: Graph G with its vertices marked with consecutive integers (verticies array changes)
//	in the order they are first encountered by the DFS traversal mark each vertex (stack)
//in V with 0 as a mark of being “unvisited” count ← 0 for each vertex v in V do
// go to each neighbor and call dfs for each if marked unvisited 
//visits recursively all the 
//unvisited vertices connected to vertex v and adds to stack add count 




//------------------ DFS --------------------
    public static int DFS (Integer v, Integer parent, Stack vertexStack, Integer marked[] ,  HashMap<Integer, List<Integer>> verts ){
        //verticie marked as visited 
        marked[v]= 1;
        
        count ++; 
        //marked [v][1] = count; 
        vertexStack.push(v);
        List<Integer> neighbors = verts.get(v);
        //int parent = v; 
        //recursion for all adjacent neighbors 
        //if adjacent neighbor already visited and in the stack then cyclic
        //System.out.println ("here");
        for (int adjI= 0; adjI< neighbors.size(); adjI++){  
            //System.out.println ("here");
            Integer adjV = neighbors.get(adjI); 
            if (marked[adjV] == 0 ){
                //recursion if not marked follow the neighbor path 
                if (DFS(adjV, v, vertexStack, marked, verts)== 1){
                        
                    return 1;
                }
            }
            else if (adjV != parent && vertexStack.search(adjV) != -1){
                //System.out.println (parent);
                //System.out.println (v);
                return 1; 
            } 
            
        }
        vertexStack.pop();
        vertexStack.remove(v); 
        return 0;
            
            
    }
        


        





//------------ IS CYCLIC OR NAH -------------
    public static int CyclicChecker (int numOfVerts, Stack vertexStack, Integer marked[] ,  HashMap<Integer, List<Integer>> verts){
        //for each verticie call dfs to chec all possibilities of a cycle
        
        for (int v= 0; v< numOfVerts; v++){
            //System.out.println("CYCLE");
            if (marked[v]==0){
                // if returns 1 then a cycle found so return 1 no cycle and continue 
                Integer parent = - 1;
                if (DFS(v,parent, vertexStack, marked,verts) == 1){
                    return 1;
                }
            }
        }
        return 0; 
    }





//List<Integer> values = new ArrayList<>(); 

//----------------- Main --------------------
    public static void main(String [] args) {
        String fileName ="";
        for (String arg : args) {
                fileName = args[0];
                
        }
        
        
        // read file
        try {
            //read file 
            String line = null;
            FileReader fileReader = new FileReader(fileName);

            //  BufferedReader to read lines 
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        
            //make a dictionary with vertice being key and adj verticies as the values 
            HashMap<Integer,  List<Integer>> verts = new HashMap<Integer, List<Integer>>();
            int len =0;
            int v = -1;
            //Integer[] marked = new Integer[500];
            while((line = bufferedReader.readLine()) != null) {
                v++;
                //System.out.println(v);
                String[] newLine = line.split("\\s+"); 
                len = newLine.length;
                List<Integer> neighbors = new ArrayList<>(); 
                //int k = -1;
                for (int i = 0; i<len; i++){
                    if (Integer.parseInt(newLine[i]) == 1 ){
                        //add to array neighbors
                        neighbors.add(i);
                    }
                }
                //marked[v] =0;
                //initialize amrk 
                //add verticie and neighbors/adjacent verticices to dictionary verts
                verts.put( v, neighbors);
            }
            Integer[] marked = new Integer[v+1];
            for ( int m= 0; m<= v; m++){
                marked[m] = 0;
            }
            //create a stack for checking 

            Stack vertexStack = new Stack();
            int numOfVerts = v+1;
            //System.out.println(numOfVerts);
            //check for cycle
            int cycleResult = CyclicChecker(numOfVerts,vertexStack, marked, verts);
            
            //if there is a cycle print cycle and the stack to get the cycle path 
            if (cycleResult==1){
                System.out.println("CYCLE");
                int numInPath= vertexStack.size();
                    String path = "";
                    path = path + vertexStack.pop();
                    while (vertexStack.empty()==false){
                        path= path+ " - "+vertexStack.pop();
                        numInPath --;
                    }
                    //print cycle
                    System.out.println(path); 
            }
            //no cycle if returns 0 
            if (cycleResult==0){
                System.out.println("NO CYCLE");
            }
            ///end program 
            bufferedReader.close(); 
        }
    
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
        
        
        }
    }
    
            
}            
            