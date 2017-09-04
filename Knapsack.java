//import
import java.io.*;

import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap; 
public class Knapsack {
    
    public static int getSum (ArrayList<Integer>setWeights){
        int sum =0;
        for (int i = 0; i<setWeights.size(); i++){
            sum = sum+setWeights.get(i);
        }
        return sum;
    }

    public static void main(String [] args) {
        // file
        String fileName = "knap_input.txt";

        // This will reference one line at a time
        String line = null;

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
            int n= keys.size();
            //System.out.println(values.size());
            for (int l=0; l< n; l++)
            {
                Integer[] info = {values.get(k), values.get(k+1),i};
                //System.out.println(keys.get(l));
                dict.put(keys.get(l), info);
                k=k+2;
            }
            ArrayList<Integer> test = new ArrayList<>();
           
           //System.out.println(dict.get("TV")[);
            // int result = dict.get(keys[0])[1];
            test.add(dict.get(keys.get(0))[1]);
            test.add(1);
            System.out.println(weight(test)); 
                
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
