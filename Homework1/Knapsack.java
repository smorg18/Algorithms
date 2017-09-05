//import
import java.io.*;
import java.util.LinkedList;
import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap; 
public class Knapsack {
    public static void binaryPerm(String set, int recursion, List<String> results) {

        if(recursion == 0) {
            results.add(set);
        }
        else {
            binaryPerm(set + "0", recursion - 1, results);
            binaryPerm(set+ "1", recursion - 1, results);
        }
    }
    //get weight and value sum of set 
    public static int getSum (ArrayList<Integer>setWeights){
        int sum =0;
        for (int i = 0; i<setWeights.size(); i++){
            sum = sum+setWeights.get(i);
        }
        return sum;
    }
    public static int BestSet(LinkedList<String>binaryList, HashMap<String, Integer[]> dict ){
        List<Integer> setWeight = new ArrayList<>();
        List<Integer> setValues = new ArrayList<>();
        int greatestValue = 0;
        String greatestSet = "";
        for (int i =0; i < binaryList.size(); i++){
            String binarySet = binaryList.get(i);
            for
            
        }

    }
    public static void main(String [] args) {
        // file
        List<String> results = new LinkedList<String>();
        binaryPerm("", 4, results);
        //System.out.println(results.size());
        
        String fileName = "knap_input.txt";

        // This will reference one line at a time
        String line = null;
        System.out.println("Command-line arguments:");
        int n = 0;
        for (String arg : args) {
                n = Integer.parseInt(args[0]);
                System.out.println(n);
        }
        try {
            //read file 
            FileReader fileReader = 
                new FileReader(fileName);

            //  BufferedReader to read lines 
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            //keep a list of keys and values for dictionary of objects
            List<String> keys = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            //index to determine type of info retrieved (name, weight or value?)
            int i =0;
            while((line = bufferedReader.readLine()) != null) {
                
                //index =0 then it is the name/key
                if (i == 0){ 
                    keys.add(line);
                    i=1;   
                }   
                //other two options are added to values list 
                else if (i==1){
                    int result = Integer.parseInt(line);
                    values.add(result);
                    i = 2;
                }
                else{
                    int result = Integer.parseInt(line);
                    values.add(result);
                    i=0;
                }
            }
            // close file
            bufferedReader.close();   
            HashMap<String, Integer[]> dict = new HashMap<String, Integer[]>();
            int k=0;
            int numKeys= keys.size();
            //System.out.println(values.size());
            for (int l=0; l< numKeys; l++)
            {
                Integer[] info = {values.get(k), values.get(k+1),i};
                //System.out.println(keys.get(l));
                dict.put(keys.get(l), info);
                k=k+2;
            }
            ArrayList<Integer> test = new ArrayList<>();
           
           
                
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
