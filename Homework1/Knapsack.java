//-----------------import------------------------
import java.io.*;
import java.util.LinkedList;
import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap; 


//-----------------start of class-----------------
public class Knapsack {

//-------------lexicographic binary---------------
    public static void binaryPerm(String set, int recursion, List<String> results) {

        if(recursion == 0) {
            results.add(set);
        }
        else {
            binaryPerm(set + "0", recursion - 1, results);
            binaryPerm(set+ "1", recursion - 1, results);
        }
    }
//-------get weight and value sum of set---------
    public static int getSum (List<Integer>setAmounts){
        int sum =0;
        for (int i = 0; i<setAmounts.size(); i++){
            sum = sum+setAmounts.get(i);
        }
        return sum;
    }
//----------find best bang for buck--------------
    public static String BestSet(List<String>binaryList, HashMap<String, Integer[]> dict, int keySize, List<String> keys, int limit ){
        
        int greatestValue = 0;
        String greatestSet = "";
//----------go through each possible set and check values--------------
        for (int i =0; i < binaryList.size(); i++){
            List<Integer> setWeight = new ArrayList<>();
            List<Integer> setValues = new ArrayList<>();
            String binarySet = binaryList.get(i);
//----------check which item is picked from each possible set--------------
            for(int k = 0; k< keySize; k++){
                int itemIndex = dict.get(keys.get(k))[2];
                //System.out.println(itemIndex);
//--------------if in set calcualte weights and values --------------------
                if (binarySet.charAt(itemIndex) == '1'){
                    setValues.add(dict.get(keys.get(k))[1]);
                    setWeight.add(dict.get(keys.get(k))[0]);
                }
            }
//--------------if not too heavy check if best value  --------------------
            if (getSum (setWeight) <= limit){
                System.out.println(getSum(setValues));
                int value = getSum(setValues);
                if (value > greatestValue){
                    greatestValue= value;
                    greatestSet = binarySet;
                    System.out.println("here");

                }
            }
                
            
        }
        //System.out.println(greatestValue);
        return greatestSet;

    }
//----------------- Main --------------------
    public static void main(String [] args) {
        
        //open input fike
        String fileName = "knap_input.txt";

        // This will reference one line at a time
        String line = null;
        System.out.println("Command-line arguments:");
        int limit = 0;
        for (String arg : args) {
                limit = Integer.parseInt(args[0]);
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
//----------------Create binary perm-----------------------------
            List<String> results = new LinkedList<String>();
            binaryPerm("", numKeys, results);  
            //System.out.println(values.size());
//----------------Create dictioanry with item name as key ------------------------
//----------------------- weight and price as values -----------------------------
//--------------------- -----------------------------

            for (int l=0; l< numKeys; l++)
            {
                Integer[] info = {values.get(k), values.get(k+1),l};
                //System.out.println(keys.get(l));
                dict.put(keys.get(l), info);
                k=k+2;
            }
            ArrayList<Integer> test = new ArrayList<>();
           
        String set = BestSet(results, dict, numKeys, keys, 43);
        System.out.println(set);  
                
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
