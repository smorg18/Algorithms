//SAVANNAH MORGAN
//import
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;







//Implements a depth-first search traversal of a given graph
//Input: Graph G = ⟨V , E⟩ 
//Output: Graph G with its vertices marked with consecutive integers (verticies array changes)
//	in the order they are first encountered by the DFS traversal mark each vertex (stack)
//in V with 0 as a mark of being “unvisited” count ← 0 for each vertex v in V do
// go to each neighbor and call dfs for each if marked unvisited 
//visits recursively all the 
//unvisited vertices connected to vertex v and adds to stack add count 




//------------------ DFS --------------------
    public static int DFS (Integer v, Stack vertexStack, Integer marked[][] , Integer neighbors [][] ){
        //verticie marked as visited and with count of order visited
        // also kept in stack for  cyclic checking 
        marked [v][0] = 1;
        count ++; 
        marked [v][1] = count; 


        //recurion for all adjacent neighbors 
        //if adjacent neighbor already visited and in the stack than cyclic
        int adjacentVertexes = neighbors [v]
        for (adjI = 0; adjI< .size(); adjI++){
            int adjV = v.get(adjI); 
            if (visited[adjV][0] == 0){
                if (DFS(.....)== 1){
                    return 1;
                }
            }
            else if (vertexStack[adjV] ==1){
                return 1; 

            } 
        }
            vertexStack.pop(v)
            
            
    }
        


        





//------------ IS CYCLIC OR NAH -------------
    public static int CyclicChecker (ArrayList<Integer>perm, int n){
        for (int v= 0; v< len; v++){
            if (visited[v]==0){
                if (DFS() == 1){
                    return 1;
                }
            }
        }
        return 0; 
    }







//----------------- Main --------------------
    public static void main(String [] args) {
        String fileName ="";
        for (String arg : args) {
                fileName = args[0];
                //System.out.println(n);
        }
        
        
        
        try {
            //read file 
            String line = null;
            FileReader fileReader = 
                new FileReader(fileName);

            //  BufferedReader to read lines 
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
        
            //index to determine type of info retrieved (name, weight or value?)
            HashMap<String, Integer[]> dict = new HashMap<String, Integer[]>();
            int len =0;
            int v = -1;
            while((line = bufferedReader.readLine()) != null) {
                v++;
                newLine = line.split("\\s+"); 
                len = newLine.size();

                for (int i = 0; i<len; i++){
                    if (newLine == 1 ){
                        //add to array neighbors
                        //Integer[] neighbors = {values.get(k), values.get(k+1),l};
                    }
                }
                // add v(vertex) as key and add neighbor as value  
                //dict.put(keys.get(l), info);
                }
                   
        
            }
            //call CYCLIC?
            //Print statement 
            //end program 


            // close file
            bufferedReader.close(); 
            
            
            