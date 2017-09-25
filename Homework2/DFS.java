//SAVANNAH MORGAN
//import
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Stack;

public class DFS {
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
    public static int DFS (Integer v, Stack vertexStack, Integer marked[] ,  HashMap<Integer, List<Integer>> verts ){
        //verticie marked as visited and with count of order visited
        // also kept in stack for  cyclic checking 
        //marked [v][0] = 1;
        marked[v]= 1;
        count ++; 
        //marked [v][1] = count; 
        vertexStack.push(v);
        List<Integer> neighbors = verts.get(v);
        System.out.println(neighbors.size());
        //recurion for all adjacent neighbors 
        //if adjacent neighbor already visited and in the stack than cyclic
        for (int adjI= 0; adjI< neighbors.size(); adjI++){
            Integer adjV = neighbors.get(adjI); 
            if (marked[adjV] == 0){
                if (DFS(adjV, vertexStack, marked, verts)== 1){
                     System.out.println("here"+adjV);
                    return 1;
                }
            }
            else if (vertexStack.search(adjV) != -1){
                return 1; 

            } 
        }
        vertexStack.pop();
        vertexStack.remove(v);
        return 0;
            
            
    }
        


        





//------------ IS CYCLIC OR NAH -------------
    public static int CyclicChecker (int numOfVerts, Stack vertexStack, Integer marked[] ,  HashMap<Integer, List<Integer>> verts){
        
        for (int v= 0; v< numOfVerts; v++){
            if (marked[v]==0){
                
                if (DFS(v,vertexStack, marked,verts) == 1){
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
        
        
        
        try {
            //read file 
            String line = null;
            FileReader fileReader = new FileReader(fileName);

            //  BufferedReader to read lines 
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        
            //index to determine type of info retrieved (name, weight or value?)
            HashMap<Integer,  List<Integer>> verts = new HashMap<Integer, List<Integer>>();
            int len =0;
            int v = -1;
            Integer[] marked = new Integer[500];
            while((line = bufferedReader.readLine()) != null) {
                v++;
                String[] newLine = line.split("\\s+"); 
                len = newLine.length;
                //System.out.println(len);
                List<Integer> neighbors = new ArrayList<>(); 
                //int k = -1;
                for (int i = 0; i<len; i++){
                    if (Integer.parseInt(newLine[i]) == 1 ){
                        //add to array neighbors
                        //k++;
                        neighbors.add(i);
                    }
                }
                //initialize amrk 
                marked[v] = 0;
                //marked[v] = -1; 
                // add v(vertex) as key and add neighbor as value  
                verts.put( v, neighbors);
            }
        
                   
        
        
            Stack vertexStack = new Stack();
            int numOfVerts = v+1;
            int cycleResult = CyclicChecker(numOfVerts,vertexStack, marked, verts);
            //call CYCLIC?
            //Print statement 
            if (cycleResult==1){
                System.out.println("CYCLE");
            }
            //end program 
//(Integer v, Stack vertexStack, Integer marked[][] ,  HashMap<Integer, List<Integer>> verts ){
            if (cycleResult==0){
                System.out.println("NO CYCLE");
            }
            // close file
            bufferedReader.close(); 
        }
    
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
        
        
        }
    }
    
            
}            
            