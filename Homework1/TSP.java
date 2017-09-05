//import
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap; 
public class TSP{
    //get weight and value sum of set 
   
    public static int calcualteCost(ArrayList<Integer>perm, HashMap<String, ArrayList<Integer>> dict, int numCities){
        int totalCost=0;
        for (int index=0; index<numCities; index++){
            int currentCity = perm.get(index);
            int destinationCity = perm.get(index+1);
            int cost = dict.get(currentCity).get(destinationCity - 1);
            totalCost= totalCost+ cost;
        }   
        return totalCost;    
    }
    public static int orderCheck(ArrayList<Integer>perm, int n){
        int criteriaMet = 0;
        for (int i = 1; i< n; i++){
            if (perm.get(i)> perm.get(i-1)){
                criteriaMet = 1;
            }
        }
        return criteriaMet;
    }

    public static int greatestIndexI (ArrayList<Integer>perm, int n){
        int greatestIndex =0;
        for (int i = 0; i<(n-1); i++){
            if (perm.get(i)<perm.get(i+1)){
                greatestIndex = i;
            }
        }
        return greatestIndex;
    }
    public static int greatestIndexJ (ArrayList<Integer>perm, int n, int i){
        int greatestIndex =0;
        for (int j = 0; j<n; j++){
            if (perm.get(i)<perm.get(j)){
                greatestIndex = j;
            }
        }
        return greatestIndex;
    }
    
    public static void main(String [] args) {
        
        System.out.println("Command-line arguments:");
        int n = 0;
        for (String arg : args) {
                n = Integer.parseInt(args[0]);
                System.out.println(n);
        }
        String fileName = "tsp_input.txt";
         try 
        {
            
            String line = null;
            //read file 
            FileReader fileReader = 
                new FileReader(fileName);

            //  BufferedReader to read lines 
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            //index to determine type of info retrieved (name, weight or value?)
            int city =1;
            HashMap<String, ArrayList<Integer>> dict = new HashMap<String, ArrayList<Integer>>();
            String firstLine= bufferedReader.readLine();
            String[] splitLine = firstLine.split("\\s+");
            int numOfCities = Integer.parseInt(splitLine[1]);

            while((line = bufferedReader.readLine()) != null) {
                String[] splited = line.split("\\s+"); 
                //index =0 then it is the name/key
                
                //other two options are added to values list
                List<Integer> values = new ArrayList<>(); 
                for (int l =0; l<numOfCities; l++){
                    values.add(Integer.parseInt(splited[l])); 
                }
                dict.put(city,values);
                city++;
                
            }
            // close file
            bufferedReader.close();   
          
                
        
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("sample_perm_output.txt"));
                ArrayList<Integer> perm = new ArrayList<>();
                for (int l=0; l< n; l++)
                {
                    perm.add(l+1);
                }
                String Line = Integer.toString(perm.get(0));
                for (int c = 1; c < n; c++){
                    Line = Line + " " + Integer.toString(perm.get(c));
                }
                try{
                        Line= Line + "\n";
                        writer.write(Line);
                    }
                catch  (IOException e) {
                    System.out.println("Failed to write to file ");
                }
                 while (orderCheck(perm,n) == 1){
                    int i = greatestIndexI(perm, n);
                    int j = greatestIndexJ(perm,n,i);
                    int aI = perm.get(i);
                    int aJ = perm.get(j);
                    perm.set(i, aJ);
                    perm.set(j, aI);
                    //for (int m = i+1;m < (n-1); m++){
                    int m = i+1;
                    int oldM = perm.get(m);
                    int newM = perm.get(n-1);
                    perm.set(m,newM);
                    perm.set((n-1),oldM);

                //}
                    int cost = calcualteCost(perm,dict, numOfCities);
                    String newLine = Integer.toString(perm.get(0));
                    for (int c = 1; c < n; c++){
                        newLine = newLine + "->" + Integer.toString(perm.get(c));
                    }
                    try{
                        newLine= newLine + "Score: "+ Integer.toString(cost)+"\n";
                        writer.write(newLine);
                    }
                    catch  (IOException e) {
                        System.out.println("Failed to write to file ");
                    }
                    
                }
                try {
                        writer.close();
                    }
                catch (IOException e) {
                        System.out.println("Failed to close file ");
                    }
            }
            catch(IOException e) {
                    System.out.println("Failed to create file ");
                }
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + fileName + "'");                  
        
        
        }
    }
}
