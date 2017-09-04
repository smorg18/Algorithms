
//import
import java.io.*;

import java.util.HashMap; 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap; 
public class Permutation {
    //get weight and value sum of set 
    public static int orderCheck(ArrayList<Integer>perm, int n){
        int criteriaMet = 0;
        for (int i = 1; i< n; j++){
            if (perm[i]> perm[i-1]){
                criteriaMet = 1;
            }
        }
        return criteriaMet;
    }

    public static int greatestIndexI (ArrayList<Integer>perm, int n){
        int greatestIndex =0;
        for (int i = 0; i<(n-1); i++){
            if (perm[i]<perm[i+1]){
                greatestIndex = i;
            }
        }
        return greatestIndex;
    }
    public static int greatestIndexJ (ArrayList<Integer>perm, int n, i){
        int greatestIndex =0;
        for (int j = 0; j<n; j++){
            if (perm[i]<perm[j]){
                greatestIndex = j;
            }
        }
        return greatestIndex;
    }

    

    public static int BestSet(ArrayList<Integer>binaryList, HashMap<String, Integer[]> dict ){


    }
    public static void main(String [] args) {
            // get info from system
            Scanner sc = new Scanner(System.in);
            int n = sc.nextint();
            ArrayList<Integer> perm = new ArrayList<>();
            for (int l=0; l< n; l++)
            {
                perm.add(l+1);
            }
            
           
           //System.out.println(dict.get("TV")[);
            // int result = dict.get(keys[0])[1];
            // test.add(dict.get(keys.get(0))[1]);
            // test.add(1);
            // System.out.println(weight(test)); 
                
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
