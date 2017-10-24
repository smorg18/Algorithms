Public Class MaxFlow(){
//create a grpah by reading in afile 
  //while Q is not empty 
    //MainNode 
    //for every MainNode- adj node FORWARD EDGES
      //IF NOT LABLED
          // 
    //for every edge adj nodes -MainNode
      //IF NOT LABLED
          //
    //if last node labled 
        // blah
        //reintialize lables
  
}
// return flow 


Integer v, Integer parent, 

int bfs(HashMap<Integer, List<Integer>> verts, int source, int sink, int parent[],Integer marked[])
    {
 
        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        marked[source] = 1;
        parent[source]=-1;
 
        // Standard BFS Loop
        while (queue.size()!=0)
        {
            //??????
            int initV = queue.poll();
 
            for (int v=0; v<numOfVerts; v++)
            {
                if (visited[v]==0 && verts.get(initV)[v] > 0)
                {
                    queue.add(initV);
                    parent[v] = initV;
                    visited[v] = 1;
                }
            }
        }
 
        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[sink] == 1);
    }




















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
          
          
          
          
          
<--------------------------CHANGE THIS CODE BELOW ----------------------------->          
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
  
        // Let us create a graph shown in the above example
        int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0},
                                     {0, 0, 10, 12, 0, 0},
                                     {0, 4, 0, 0, 14, 0},
                                     {0, 0, 9, 0, 0, 20},
                                     {0, 0, 0, 7, 0, 4},
                                     {0, 0, 0, 0, 0, 0}
                                   };
        MaxFlow m = new MaxFlow();
 
        System.out.println("The maximum possible flow is " +
                           m.fordFulkerson(graph, 0, 5));
 
    }
}
